package ru.kpfu.itis.util.transform;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.form.ProductModifyForm;
import ru.kpfu.itis.model.Product;
import ru.kpfu.itis.service.ProductService;

public class ProductModifyFormTransform {

    @Autowired
    private ProductService productService;

    public Product transform(ProductModifyForm form, Product m_product) {
        Product product = new Product();
        product.setName(form.getName());
        product.setDescription(form.getDescription());
        product.setPrice(form.getPrice());
        product.setType(form.getType());
        product.setId(form.getId());
        if (form.getName() == null || form.getName().isEmpty()) {
            product.setName(m_product.getName());
        }
        if (form.getDescription() == null || form.getDescription().isEmpty()) {
            product.setDescription(m_product.getDescription());
        }
        return product;
    }
}
