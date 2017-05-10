package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.OrderModifyForm;
import ru.kpfu.itis.message.MailMail;
import ru.kpfu.itis.model.Order;
import ru.kpfu.itis.model.ProductInOrder;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.OrderType;
import ru.kpfu.itis.repository.OrderRepository;
import ru.kpfu.itis.repository.ProductInOrderRepository;
import ru.kpfu.itis.service.OrderService;
import ru.kpfu.itis.service.StocktakingService;
import ru.kpfu.itis.util.transform.OrderModifyFormTransform;

import java.util.LinkedList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductInOrderRepository productInOrderRepository;
    @Autowired
    private MailMail mailMail;
    @Autowired
    private StocktakingService stocktakingService;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getByUserId(long id) {
        return orderRepository.findAllByUserId(id);
    }

    @Override
    public Order getById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order getByUserAndTypeOrder(User user, OrderType orderType) {
        return orderRepository.findByUserAndTypeOrder(user, orderType);
    }

    @Override
    public List<Order> getByUser(User user) {
        return orderRepository.findByUser(user);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @Override
    public void save(User user, ProductInOrder productInOrder) {
        if (getByUserAndTypeOrder(user, OrderType.DIALED) != null) {
            Order order = getByUserAndTypeOrder(user, OrderType.DIALED);
            List<ProductInOrder> productInOrders = productInOrderRepository.findAllByOrder(order);
            boolean flag = false;
            for (ProductInOrder productInOrder1 : productInOrders) {
                if (productInOrder1.getProduct().getId() == productInOrder.getProduct().getId()) {
                    productInOrder1.setQuantity(productInOrder1.getQuantity() + 1);
                    flag = true;
                }
            }
            if (!flag) {
                productInOrder.setQuantity(1);
                productInOrders.add(productInOrder);
            }
            order.setProductInOrders(productInOrders);
            orderRepository.save(order);
            for (ProductInOrder productInOrder1 : productInOrders) {
                productInOrder1.setOrder(orderRepository.findById(order.getId()));
                productInOrderRepository.save(productInOrder1);
            }
        } else {
            List<ProductInOrder> productInOrders = new LinkedList<>();
            Order order = new Order();
            order.setTypeOrder(OrderType.DIALED);
            order.setUser(user);
            productInOrder.setQuantity(1);
            productInOrders.add(productInOrder);
            order.setProductInOrders(productInOrders);
            orderRepository.save(order);
            productInOrder.setOrder(getByUserAndTypeOrder(user, OrderType.DIALED));
            productInOrderRepository.save(productInOrder);
        }


    }


    @Override
    public void modify(OrderModifyForm form) {
        Order order = OrderModifyFormTransform.transform(form);
        if (order.getTypeOrder() == OrderType.SEARS) {
            mailMail.sendMail("from@no-spam.com", order.getUser().getEmail(),
                    "Shop",
                    "Ваш товар собирается");
        } else if (order.getTypeOrder() == OrderType.COMPLETED) {
            mailMail.sendMail("from@no-spam.com", order.getUser().getEmail(),
                    "Shop",
                    "Ваш товар отправлен");
        }else if (order.getTypeOrder() == OrderType.FORMAD) {
            mailMail.sendMail("from@no-spam.com", order.getUser().getEmail(),
                    "Shop",
                    "Ваш заказ отправлен на сборку");
        }
        orderRepository.save(order);
    }

    @Override
    public void delete(long id) {
        orderRepository.delete(id);
    }

    public int getResponseAboutMinusCount(long id, int count) {
        int availableCount = getCountById(id);
        int neededCount = count - 1;

        int response = setResponse(id, neededCount, availableCount);

        System.out.println(id + " - " + response);

        return response;
    }

    public int getResponseAboutPlusCount(long id, int count) {
        int availableCount = getCountById(id);
        int neededCount = count + 1;

        int response = setResponse(id, neededCount, availableCount);

        System.out.println(id + " - " + response);

        return response;
    }


    private int setResponse(long id, int neededCount, int availableCount) {
        System.out.println(neededCount + " --- " + availableCount);
        if (neededCount > availableCount)
            return -1;
        else if (neededCount <= 0)
            return -2;
        else if (neededCount <= availableCount) {
            ProductInOrder productInOrder = productInOrderRepository.findByProductId(id);
            productInOrder.setQuantity(neededCount);
            productInOrderRepository.save(productInOrder);
            return neededCount;
        }
        return 0;
    }

    public int getCountById(long id) {
        return stocktakingService.getAllQuantityOnWarehouse(stocktakingService.getAllByProductId(id));
    }
}
