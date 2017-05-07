package ru.kpfu.itis.form.collateralForms;

public class OrderForm {

    private long order_id;
    private String typeOrder;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(String typeOrder) {
        this.typeOrder = typeOrder;
    }
}
