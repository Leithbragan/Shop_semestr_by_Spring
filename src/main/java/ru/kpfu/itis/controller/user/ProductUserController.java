package ru.kpfu.itis.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.service.ProductService;
import ru.kpfu.itis.service.StocktakingService;
import ru.kpfu.itis.service.WarehouseService;

@Controller
@RequestMapping(value = "product")
public class ProductUserController {

    @Autowired
    private ProductService productService;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private StocktakingService stocktakingService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String mainPage(Model model, @RequestParam(value = "name", required = false) String productname) {
        if (productname != null){
            model.addAttribute("name", productService.getAllByName(productname));
            model.addAttribute("products", productService.getAllByName(productname));
            return "catalog";
        }
        model.addAttribute("products", productService.getAllByName(productname));
        return "catalog";
    }

    @RequestMapping(value = "/{id}")
    public String product_page(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "product_page";
    }
}
