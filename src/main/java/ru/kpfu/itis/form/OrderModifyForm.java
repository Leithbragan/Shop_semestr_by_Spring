package ru.kpfu.itis.form;

import ru.kpfu.itis.model.Order;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.OrderType;

public class OrderModifyForm {

    private Order order;
    private OrderType typeOrder;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderType getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(OrderType typeOrder) {
        this.typeOrder = typeOrder;
    }
}
