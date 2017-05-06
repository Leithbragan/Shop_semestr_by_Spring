package ru.kpfu.itis.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.form.AddQuantityForm;
import ru.kpfu.itis.form.AddStocktakingForm;
import ru.kpfu.itis.form.collateralForms.QuantityForm;
import ru.kpfu.itis.form.collateralForms.StocktakingForm;
import ru.kpfu.itis.model.Product;
import ru.kpfu.itis.model.Stocktaking;
import ru.kpfu.itis.model.Warehouse;
import ru.kpfu.itis.service.ProductService;
import ru.kpfu.itis.service.StocktakingService;
import ru.kpfu.itis.service.WarehouseService;

@Controller
@RequestMapping(value = "stocktaking")
public class StocktakingController {

    @Autowired
    private StocktakingService stocktakingService;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add_stocktaking(Model model){
        model.addAttribute("stocktaking_form", new StocktakingForm());
        model.addAttribute("products", productService.getAll());
        model.addAttribute("warehouses", warehouseService.getAll());
        return "add_stocktaking_page";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add_stocktaking(@ModelAttribute("stocktaking_form") StocktakingForm form){
        Product product = productService.getById(form.getProduct());
        Warehouse warehouse = warehouseService.getById(form.getWarehouse());
        AddStocktakingForm addStocktakingForm = new AddStocktakingForm();
        addStocktakingForm.setProduct(product);
        addStocktakingForm.setWarehouse(warehouse);
        stocktakingService.save(addStocktakingForm);
        return "redirect:/";


    }@RequestMapping(value = "/quantity", method = RequestMethod.GET)
    public String add_quantity(Model model){
        model.addAttribute("quantity_form", new QuantityForm());
        model.addAttribute("stocktaking", stocktakingService.getAll());
        return "add_quantity";
    }

    @RequestMapping(value = "/quantity", method = RequestMethod.POST)
    public String add_quantity(@ModelAttribute("quantity_form") QuantityForm form){
        Stocktaking stocktaking = stocktakingService.getById(form.getStocktaking());
        AddQuantityForm addQuantityForm = new AddQuantityForm();
        addQuantityForm.setStocktaking(stocktaking);
        addQuantityForm.setQuantity(form.getQuantity());
        stocktakingService.putQuantity(addQuantityForm);
        return "redirect:/";
    }
}
