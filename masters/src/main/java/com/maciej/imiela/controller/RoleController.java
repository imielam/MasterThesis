package com.maciej.imiela.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maciej.imiela.entity.Role;
import com.maciej.imiela.service.RoleService;

/**
 * 
 * @author Maciej
 */
@Controller
@Scope("session")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    private static final Logger logger = LoggerFactory
            .getLogger(RoleController.class);

    @RequestMapping(value = { "/detail/{id}" }, method = RequestMethod.GET)
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("role", this.roleService.findOne(id));
        return "role/detail";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("role", this.roleService.findOne(id));
        return "role/edit";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String save(Model model, @PathVariable int id, @Valid Role role,
            BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "role/edit";
        }
        role.setId(id);
        this.roleService.save(role);
        return "redirect:role/detail/" + role.getId() + ".html?success=true";
    }

}
