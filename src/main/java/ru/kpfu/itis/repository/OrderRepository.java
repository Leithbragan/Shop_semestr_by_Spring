package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
