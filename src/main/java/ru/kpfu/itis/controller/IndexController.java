package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.ValidatorForm;

@Controller
public class IndexController {

    private final UserService userService;

    private ValidatorForm validatorForm = new ValidatorForm();

    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/")
    public String getIndexPage() {
        return "home";
    }

    @RequestMapping(value = "/forbidden")
    public String getForbiddenPage() {
        return "404";
    }

    @RequestMapping(value = "/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("userform", new UserRegistrationForm());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userform") UserRegistrationForm form, BindingResult result) {
        validatorForm.validate(form, result);

        if (result.hasErrors()) {
            return "registration";
        } else {
            userService.save(form);
            return "redirect:/";
        }
    }



}