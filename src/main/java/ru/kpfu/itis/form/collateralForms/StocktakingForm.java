package ru.kpfu.itis.form.collateralForms;

public class StocktakingForm {

    private long product;
    private long warehouse;
    private int quantity;

    public long getProduct() {
        return product;
    }

    public void setProduct(long product) {
        this.product = product;
    }

    public long getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(long warehouses) {
        this.warehouse = warehouses;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
