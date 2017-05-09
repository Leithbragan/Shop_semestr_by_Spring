package ru.kpfu.itis.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.service.OrderService;

@Controller
@RequestMapping(value = "basket")
public class BasketController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String basket(@PathVariable("id") long id, Model model) {
        model.addAttribute("order", orderService.getById(id));
        return "basket";
    }
}
