package ru.kpfu.itis.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.form.AddWarehouseForm;
import ru.kpfu.itis.service.ProductService;
import ru.kpfu.itis.service.StocktakingService;
import ru.kpfu.itis.service.WarehouseService;

@Controller
@RequestMapping(value = "warehouse")
public class WarehouseController {

    @Autowired
    private ProductService productService;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private StocktakingService stocktakingService;

    @RequestMapping(value = "/all")
    public String catalog(Model model) {
        model.addAttribute("warehouses", warehouseService.getAll());
        return "list_warehouses";
    }

    @RequestMapping("/{id}")
    public String product_page(@PathVariable("id") long id, Model model) {
        model.addAttribute("warehouse", warehouseService.getById(id));
        model.addAttribute("stocktaking", stocktakingService.getByWarehouseId(id));
        model.addAttribute("quantity", stocktakingService.getAllQuantityOnWarehouse(stocktakingService.getByWarehouseId(id)));
        model.addAttribute("products", productService.getByIdIn(stocktakingService.getIdsProducts(stocktakingService.getByWarehouseId(id))));
        return "warehouse_page";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add_warehouse_page(Model model){
        model.addAttribute("warehouse_form", new AddWarehouseForm());
        return "add_warehouse_page";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add_warehouse(@ModelAttribute("warehouse_form") AddWarehouseForm form){
        warehouseService.save(form);
        return "redirect:/warehouse/all/";
    }
}
