/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maciej.imiela.domain.ContactMessage;
import com.maciej.imiela.entity.User;

/**
 * 
 * @author Maciej
 */
@Controller
@RequestMapping("/materials")
public class MaterialController {

    private static final Logger logger = LoggerFactory
            .getLogger(MaterialController.class);

    @RequestMapping(value = { "/full" }, method = RequestMethod.GET)
    public String createContactMessage(Model model) {
        model.addAttribute("contactMessage", new ContactMessage());
        return "materials/full";
    }

    @RequestMapping(value = { "/example" }, method = RequestMethod.GET)
    public String createNewUser(Model model) {
        model.addAttribute("user", new User());
        return "materials/example";
    }
}
