/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maciej.imiela.domain.ContactMessage;
import com.maciej.imiela.entity.User;
import com.maciej.imiela.service.CourseService;

/**
 *
 * @author Maciej
 */
@Controller
public class GuestController {

    public static final String SUCCES_REGISTER = "Your account has been created!";

    public static final String SUCCES_MESSAGE = "Message was sent!";

    public static final String FAIL_MESSAGE = "Message wasn't sent due to unexpected error, please try again!";

    @Autowired
    private CourseService courseService;

    @Autowired
    private MailSender mailSender;

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
        return "register";
    }

    @RequestMapping(value = { "/about" }, method = RequestMethod.GET)
    public String displayAbout(Model model) {
        return "about";
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String displayLogInForm(Model model) {
        return "login";
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
    public String saveNewUser(Model model, @Valid User user,
            BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "register";
        }
        // service.saveUser(user);
        // return "redirect:/users/user?id=" + user.getId();
        return "redirect:/home?message=" + SUCCES_REGISTER;
    }

    // TODO: check why in this case, validation is not working
    @RequestMapping(value = { "/contact" }/* , method = RequestMethod.POST */)
    public String sendMessage(Model model,
            @Valid ContactMessage contactMessage, BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "contact";
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
            return "redirect:/contact.html?success=false";
        }
        return "redirect:/contact.html?success=true";
    }

    @RequestMapping(value = { "/", "/index", "/home" }, method = RequestMethod.GET)
    public String showHomePage() {
        // User u = service.getUser(1);
        // model.addAttribute("user", u);
        // logger.info("{}.", u);
        return "index";
    }
}
