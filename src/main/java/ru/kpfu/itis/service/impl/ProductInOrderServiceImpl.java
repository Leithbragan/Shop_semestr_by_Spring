package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.ProductInOrder;
import ru.kpfu.itis.repository.ProductInOrderRepository;
import ru.kpfu.itis.service.ProductInOrderService;

import java.util.List;

@Service
public class ProductInOrderServiceImpl implements ProductInOrderService {

    @Autowired
    ProductInOrderRepository productInOrderRepository;

    @Override
    public List<ProductInOrder> getAll() {
        return productInOrderRepository.findAll();
    }

    @Override
    public void delete(long id) {
        productInOrderRepository.delete(id);
    }

    @Override
    public void save(ProductInOrder productInOrder) {
        productInOrderRepository.save(productInOrder);
    }
}
