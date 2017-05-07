package ru.kpfu.itis.form;

import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.OrderType;

public class OrderModifyForm {

    private long id;
    private User user;
    private OrderType typeOrder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderType getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(OrderType typeOrder) {
        this.typeOrder = typeOrder;
    }
}
