package ru.kpfu.itis.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.form.AddProductForm;
import ru.kpfu.itis.form.ProductModifyForm;
import ru.kpfu.itis.model.Product;
import ru.kpfu.itis.service.ProductService;
import ru.kpfu.itis.service.StocktakingService;
import ru.kpfu.itis.service.WarehouseService;
import ru.kpfu.itis.util.validators.ValidatorAddProductForm;

@Controller
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private StocktakingService stocktakingService;

    private ValidatorAddProductForm validatorAddProductForm = new ValidatorAddProductForm();

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String catalog(Model model) {
        model.addAttribute("products", productService.getAll());
        return "catalog";
    }

    @RequestMapping(value = "/{id}")
    public String product_page(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "product_page";
    }
}
