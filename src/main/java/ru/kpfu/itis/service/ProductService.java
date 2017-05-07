package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.AddProductForm;
import ru.kpfu.itis.form.ProductModifyForm;
import ru.kpfu.itis.model.Product;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAll();
    Product getById(long id);
    List<Product> getByIdIn(List<Long> ids);
    void save(AddProductForm form);
    void modify(ProductModifyForm form, Product m_product);
}
