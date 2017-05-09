package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Order;
import ru.kpfu.itis.model.ProductInOrder;

import java.util.List;

public interface ProductInOrderService {

    List<ProductInOrder> getAll();
    ProductInOrder getById(long id);
    List<ProductInOrder> getAllByOrder(Order order);
    void delete(long id);
}
