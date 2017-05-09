package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.model.Order;
import ru.kpfu.itis.model.ProductInOrder;

import java.util.List;

public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {

    List<ProductInOrder> findAll();
    ProductInOrder findById(long id);
    List<ProductInOrder> findAllByOrder(Order order);
}
