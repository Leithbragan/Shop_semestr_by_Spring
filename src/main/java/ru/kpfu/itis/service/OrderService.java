package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.OrderModifyForm;
import ru.kpfu.itis.model.Order;

import java.util.List;
@Service
public interface OrderService {

    List<Order> getAll();
    List<Order> getByUserId(long id);
    Order getById(long id);
    void modify(OrderModifyForm form);
    void delete(long id);
}
