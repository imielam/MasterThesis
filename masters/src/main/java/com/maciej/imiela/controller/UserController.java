package com.maciej.imiela.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.maciej.imiela.entity.User;
import com.maciej.imiela.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory
            .getLogger(UserController.class);

    // TODO:
    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createNewUser(Model model) {
        model.addAttribute("user", new User());
        return "users/edit";
    }

    @RequestMapping("/users/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("user", this.userService.findOne(id));
        return "user-detail";
    }

    // TODO:
    @RequestMapping(method = RequestMethod.POST)
    public String saveNewUser(/* @Valid */User user, BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "users/edit";
        }
        this.userService.save(user);
        return "redirect:/users/user.html?id=" + user.getId();
    }

    // TODO:
    @RequestMapping(value = { "/user" }, method = RequestMethod.GET)
    public String userDetails(@RequestParam("id") Long userID, Model model) {
        // User u = service.getUser(userID);
        // model.addAttribute("user", u);
        // logger.info("{}.", u);
        return "users/details";
    }

    // TODO:
    @RequestMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", this.userService.findAll());
        return "users";
    }
}
