package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.model.ProductInOrder;

public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {
}
