package com.maciej.imiela.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maciej.imiela.entity.Role;
import com.maciej.imiela.entity.User;
import com.maciej.imiela.service.AddressService;
import com.maciej.imiela.service.LoginService;
import com.maciej.imiela.service.RoleService;
import com.maciej.imiela.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private RoleService roleService;

    private static final Logger logger = LoggerFactory
            .getLogger(UserController.class);

    @RequestMapping(value = { "/register" }, method = RequestMethod.GET)
    public String createNewUser(Model model) {
        model.addAttribute("user", new User());
        Map<Integer, String> mapRoles = new HashMap<Integer, String>();
        List<Role> roles = this.roleService.findAll();
        for (Role r : roles) {
            mapRoles.put(r.getId(), r.getName());
        }
        model.addAttribute("mapRoles", mapRoles);
        return "user/register";
    }

    @RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("user",
                this.userService.findOneWithParticipantAndTeachers(id));
        return "user/detail";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("user", this.userService.findOne(id));
        Map<Integer, String> mapRoles = new HashMap<Integer, String>();
        List<Role> roles = this.roleService.findAll();
        for (Role r : roles) {
            mapRoles.put(r.getId(), r.getName());
        }
        model.addAttribute("mapRoles", mapRoles);
        return "user/edit";
    }

    @RequestMapping(value = { "/register" }, method = RequestMethod.POST)
    public String registerUser(User user, BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "user/edit";
        }
        user = this.userService.save(user);
        return "redirect:/user/" + user.getId() + ".html?success=true";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String save(Model model, @PathVariable int id, User user,
            BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "user/edit";
        }
        user.setId(id);
        user = this.userService.save(user);
        return "redirect:/user/" + user.getId() + ".html?success=true";
    }

    // TODO:
    @RequestMapping(value = { "" }, method = RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("users", this.userService.findAll());
        return "user";
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

}
