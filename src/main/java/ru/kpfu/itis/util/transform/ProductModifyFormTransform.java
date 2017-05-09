package ru.kpfu.itis.util.transform;

import ru.kpfu.itis.form.ProductForm;
import ru.kpfu.itis.model.Product;

public class ProductModifyFormTransform {



    public Product transform(ProductForm form) {
        Product product = new Product();
        product.setName(form.getName());
        product.setDescription(form.getDescription());
        product.setPrice(form.getPrice());
        product.setType(form.getType());
        product.setId(form.getId());
        return product;
    }
}
