package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Order;
import ru.kpfu.itis.model.ProductInOrder;

import java.util.List;

public interface ProductInOrderService {

    List<ProductInOrder> getAll();
    ProductInOrder getById(long id);
    List<ProductInOrder> getAllByOrder(Order order);
    List<ProductInOrder> getAllByOrderIn(List<Order> orders);
    void delete(long id);
    void delete(List<ProductInOrder> productInOrders);
}
