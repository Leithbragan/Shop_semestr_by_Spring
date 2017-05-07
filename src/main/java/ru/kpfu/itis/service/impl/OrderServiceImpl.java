package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.OrderModifyForm;
import ru.kpfu.itis.model.Order;
import ru.kpfu.itis.repository.OrderRepository;
import ru.kpfu.itis.service.OrderService;
import ru.kpfu.itis.util.transform.OrderModifyFormTransform;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getByUserId(long id) {
        return orderRepository.findByUserId(id);
    }

    @Override
    public Order getById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void modify(OrderModifyForm form) {
        Order order = OrderModifyFormTransform.transform(form);
        orderRepository.save(order);
    }

    @Override
    public void delete(long id) {
        orderRepository.delete(id);
    }
}
