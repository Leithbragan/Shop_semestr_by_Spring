package ru.kpfu.itis.form;

import org.springframework.security.access.method.P;
import ru.kpfu.itis.model.Product;
import ru.kpfu.itis.model.Warehouse;
import ru.kpfu.itis.service.ProductService;
import ru.kpfu.itis.service.WarehouseService;
import ru.kpfu.itis.service.impl.ProductServiceImpl;
import ru.kpfu.itis.service.impl.WarehouseServiceImpl;

public class AddStocktakingForm {

    private Product product;
    private Warehouse warehouse;
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
