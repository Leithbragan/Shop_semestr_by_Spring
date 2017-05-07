package ru.kpfu.itis.util.transform;

import ru.kpfu.itis.form.OrderModifyForm;
import ru.kpfu.itis.model.Order;

public class OrderModifyFormTransform {

    public static Order transform(OrderModifyForm form){
        Order order = new Order();
        order.setUser(form.getUser());
        order.setId(form.getId());
        order.setTypeOrder(form.getTypeOrder());
        return order;
    }
}
