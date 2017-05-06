package ru.kpfu.itis.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.form.AddProductForm;
import ru.kpfu.itis.service.ProductService;
import ru.kpfu.itis.service.StocktakingService;
import ru.kpfu.itis.service.WarehouseService;

@Controller
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private StocktakingService stocktakingService;

    @RequestMapping(value = "/all")
    public String catalog(Model model) {
        model.addAttribute("products", productService.getAll());
        return "list_product";
    }

    @RequestMapping("/{id}")
    public String product_page(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "product_page";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add_warehouse_page(Model model){
        model.addAttribute("product_form", new AddProductForm());
        return "add_product_page";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add_product(@ModelAttribute("product_form") AddProductForm form){
        productService.save(form);
        return "redirect:/product/all/";
    }
}
