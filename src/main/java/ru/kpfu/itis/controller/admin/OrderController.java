package ru.kpfu.itis.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.form.OrderModifyForm;
import ru.kpfu.itis.form.collateralForms.OrderForm;
import ru.kpfu.itis.model.Order;
import ru.kpfu.itis.model.enums.OrderType;
import ru.kpfu.itis.service.OrderService;
import ru.kpfu.itis.service.UserService;

@Controller
@RequestMapping(value = "admin/order")
public class OrderController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public java.lang.String all_users(Model model) {
        model.addAttribute("order_modify_form", new OrderForm());
        model.addAttribute("orders", orderService.getAll());
        return "all_orders";
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public java.lang.String all_users(@ModelAttribute("order_modify_form") OrderForm form) {
        Order order = orderService.getById(form.getId());
        OrderType typeOrder = OrderType.valueOf(form.getTypeOrder());
        OrderModifyForm orderModifyForm = new OrderModifyForm();
        orderModifyForm.setId(order.getId());
        orderModifyForm.setUser(order.getUser());
        orderModifyForm.setTypeOrder(typeOrder);
        orderService.modify(orderModifyForm);
        return "redirect:/admin/order/all";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public java.lang.String delete(@RequestParam(value="id", required=true) Long id, Model model) {
        orderService.delete(id);
        model.addAttribute("id", id);
        return "redirect:/admin/order/all";
    }
}
