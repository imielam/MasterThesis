package com.maciej.imiela.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maciej.imiela.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("user", this.userService.findOne(id));
        return "user-detail";
    }

    @RequestMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", this.userService.findAll());
        return "users";
    }
}
