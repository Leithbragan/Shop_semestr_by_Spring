package ru.kpfu.itis.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.form.ProductModifyForm;
import ru.kpfu.itis.form.collateralForms.ProductInOrderForm;
import ru.kpfu.itis.model.Product;
import ru.kpfu.itis.model.ProductInOrder;
import ru.kpfu.itis.service.ProductInOrderService;
import ru.kpfu.itis.service.ProductService;
import ru.kpfu.itis.service.StocktakingService;
import ru.kpfu.itis.service.WarehouseService;

import java.util.List;

@Controller
@RequestMapping(value = "product")
public class ProductUserController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductInOrderService productInOrderService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String catalog(@RequestParam(value = "name", required = false) String productname, Model model) {

        if (productname != null) {
            model.addAttribute("name", productname);
            model.addAttribute("products", productService.getAllByName(productname));
            model.addAttribute("product_", new ProductInOrderForm());
            return "catalog";
        }

        model.addAttribute("product_", new ProductInOrderForm());
        model.addAttribute("products", productService.getAll());
        return "catalog";
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public String catalog(@ModelAttribute("product_id") ProductInOrderForm form) {

        Product product = productService.getById(form.getProduct_id());
        ProductInOrder productInOrder = new ProductInOrder();
        productInOrder.setProduct(product);
        productInOrder.setQuantity(1);
        productInOrderService.save(productInOrder);
        return "redirect:/basket/";
    }

    @RequestMapping(value = "/{id}")
    public String product_page(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "product_page";
    }
}
