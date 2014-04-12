/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maciej.imiela.entity.User;
import com.maciej.imiela.service.UserService;

/**
 *
 * @author Maciej
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory
            .getLogger(AdminController.class);

    @RequestMapping(value = { "/users" })
    public String userDetails(Model model) {
        List<User> u = this.userService.findAll();
        model.addAttribute("users", u);
        logger.info(Arrays.toString(u.toArray()));
        return "admin/users";
    }
}
