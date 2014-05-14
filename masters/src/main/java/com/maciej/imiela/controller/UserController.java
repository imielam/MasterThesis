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

import com.maciej.imiela.entity.User;
import com.maciej.imiela.service.AddressService;
import com.maciej.imiela.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    private static final Logger logger = LoggerFactory
            .getLogger(UserController.class);

    // // TODO:
    // @RequestMapping(method = RequestMethod.GET, params = "new")
    // public String createNewUser(Model model) {
    // model.addAttribute("user", new User());
    // return "user/edit";
    // }

    @RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("user", this.userService.findOne(id));
        return "user/detail";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("user", this.userService.findOne(id));
        return "user/edit";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String save(Model model, @PathVariable int id, User user,
            BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "user/edit";
        }
        user.setId(id);
        logger.info(user.toString());
        this.addressService.save(user.getPermamentAddress());
        this.addressService.save(user.getResidenceAddress());
        this.userService.save(user);
        return "redirect:/user/" + user.getId() + ".html?success=true";
    }

    // // TODO:
    // @RequestMapping(method = RequestMethod.POST)
    // public String saveNewUser(/* @Valid */User user, BindingResult bResult) {
    // if (bResult.hasErrors()) {
    // return "user/edit";
    // }
    // this.userService.save(user);
    // return "redirect:/user/user.html?id=" + user.getId();
    // }

    // TODO:
    @RequestMapping(value = { "" }, method = RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("users", this.userService.findAll());
        return "user";
    }
}
