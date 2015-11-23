/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maciej.imiela.domain.ContactMessage;
import com.maciej.imiela.entity.Role;
import com.maciej.imiela.entity.User;
import com.maciej.imiela.service.CourseService;
import com.maciej.imiela.service.RoleService;
import com.maciej.imiela.service.UserService;
import com.octo.captcha.service.CaptchaService;
import com.octo.captcha.service.CaptchaServiceException;

/**
 * 
 * @author Maciej
 */
@Controller
@Scope("session")
public class GuestController {

    public static final String SUCCES_REGISTER = "Your account has been created!";

    public static final String SUCCES_MESSAGE = "Message was sent!";

    public static final String FAIL_CAPTCHA = "Wrong Captcha! Try again!";

    public static final String FAIL_MESSAGE = "Message wasn't sent due to unexpected error, please try again!";

    @Autowired
    private CourseService courseService;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private CaptchaService captchaService;

    private static final Logger logger = LoggerFactory
            .getLogger(GuestController.class);

    @RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
    public String createContactMessage(Model model) {
        model.addAttribute("contactMessage", new ContactMessage());
        return "contact";
    }

    @RequestMapping(value = { "/register" }, method = RequestMethod.GET)
    public String createNewUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("mapRoles", this.prepareRoleAttr());
        return "user/register";
    }

    @RequestMapping(value = { "/about" }, method = RequestMethod.GET)
    public String displayAbout(Model model) {
        return "about";
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String displayLogInForm(Model model) {
        return "login";
    }

    @RequestMapping(value = { "/invalidate" }, method = RequestMethod.GET)
    public String loggedOutPage(Model model) {
        return "invalidate";
    }

    @RequestMapping(value = { "/error/404" }, method = RequestMethod.GET)
    public String pageNotFound(Model model) {
        return "error/404";
    }

    @RequestMapping(value = { "/error" }, method = RequestMethod.GET)
    public String pageUnderConstruction(Model model) {
        return "error";
    }

    @RequestMapping(value = { "/register" }, method = RequestMethod.POST)
    public String registerUser(HttpServletRequest request, Model model,
            @Valid User user, BindingResult bResult) {
        Boolean isResponseCorrect = false;

        String sessionId = request.getSession().getId();

        try {
            isResponseCorrect = this.captchaService.validateResponseForID(
                    sessionId, user.getCaptcha().getMessage());
        } catch (CaptchaServiceException ex) {
            // should not happen, may be thrown if the id is not valid
            logger.warn("Session Id " + sessionId + " Not valid", ex);
        }

        if (!isResponseCorrect || bResult.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("mapRoles", this.prepareRoleAttr());
            return "redirect:register.html?success=false";
        }
        user = this.userService.save(user);
        return "redirect:home.html?success=true";
    }

    // TODO: check why in this case, validation is not working
    @RequestMapping(value = { "/contact" }, method = RequestMethod.POST)
    public String sendMessage(Model model, HttpServletRequest request,
            @Valid ContactMessage contactMessage, BindingResult bResult) {

        Boolean isResponseCorrect = false;
        String sessionId = request.getSession().getId();

        try {
            isResponseCorrect = this.captchaService.validateResponseForID(
                    sessionId, contactMessage.getCaptcha().getMessage());
        } catch (CaptchaServiceException ex) {
            // should not happen, may be thrown if the id is not valid
            logger.warn("Session Id " + sessionId + " Not valid", ex);
        }

        if (!isResponseCorrect || bResult.hasErrors()) {
            model.addAttribute("contactMessage", contactMessage);
            return "redirect:contact.html?success=false";
        }

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("maciej.imiela@gmail.com");
        msg.setText(contactMessage.getMessage());
        msg.setSubject("Please contact me, as soon as you can: "
                + contactMessage.getEmail());
        try {
            // this.mailSender.send(msg);
        } catch (MailException ex) {
            // log it and go on
            logger.error(ex.getMessage());
            return "redirect:contact.html?success=false";
        }
        return "redirect:contact.html?success=true";
    }

    // @RequestMapping(value = { "/register" }, method = RequestMethod.POST)
    // public String saveNewUser(Model model, @Valid User user,
    // BindingResult bResult) {
    // if (bResult.hasErrors()) {
    // return "register";
    // }
    // // service.saveUser(user);
    // // return "redirect:users/user?id=" + user.getId();
    // return "redirect:home?message=" + SUCCES_REGISTER;
    // }

    @RequestMapping(value = { "/", "/index", "/home" }, method = RequestMethod.GET)
    public String showHomePage() {
        // User u = service.getUser(1);
        // model.addAttribute("user", u);
        // logger.info("{}.", u);
        return "index";
    }

    private Map<Integer, String> prepareRoleAttr() {
        Map<Integer, String> mapRoles = new HashMap<Integer, String>();
        List<Role> roles = this.roleService.findAll();
        for (Role r : roles) {
            mapRoles.put(r.getId(), r.getName());
        }
        return mapRoles;
    }
}
