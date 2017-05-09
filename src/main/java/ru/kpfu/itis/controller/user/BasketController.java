package ru.kpfu.itis.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.model.Order;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.OrderType;
import ru.kpfu.itis.service.OrderService;
import ru.kpfu.itis.service.ProductInOrderService;

@Controller
@RequestMapping(value = "basket")
public class BasketController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductInOrderService productInOrderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String basket(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Order basket = orderService.getByUserAndTypeOrder(user, OrderType.DIALED);
        model.addAttribute("order", basket);
        model.addAttribute("products", productInOrderService.getAllByOrder(basket));
        return "basket";
    }
}
