package ru.kpfu.itis.form;

import ru.kpfu.itis.model.Stocktaking;

public class AddQuantityForm {

    private Stocktaking stocktaking;
    private int quantity;

    public Stocktaking getStocktaking() {
        return stocktaking;
    }

    public void setStocktaking(Stocktaking stocktaking) {
        this.stocktaking = stocktaking;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
