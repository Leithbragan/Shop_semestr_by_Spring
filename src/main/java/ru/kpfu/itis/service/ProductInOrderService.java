package ru.kpfu.itis.service;

import ru.kpfu.itis.model.ProductInOrder;

import java.util.List;

public interface ProductInOrderService {

    List<ProductInOrder> getAll();
    void delete(long id);
    void save(ProductInOrder productInOrder);
}
