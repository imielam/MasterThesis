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
import org.springframework.web.bind.annotation.RequestMethod;

import com.maciej.imiela.entity.Course;
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

    // private MyService service;
    // private MailSender mailSender;

    private static final Logger logger = LoggerFactory
            .getLogger(GuestController.class);

    /*
     * public GuestController(MyService service, MailSender mailSender) {
     * this.service = service; this.mailSender = mailSender; }
     */

    // public GuestController(MailSender mailSender) {
    // super();
    // this.mailSender = mailSender;
    // }

    @RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
    public String createContactMessage(Model model) {
        // model.addAttribute("contactMessage", new ContactMessage());
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

    @RequestMapping(value = { "/course/list" })
    public String displayCoursesList(Model model) {
        final List<Course> allCourses = this.courseService.findAll();
        logger.info(Arrays.toString(allCourses.toArray()));
        model.addAttribute("courses", allCourses);
        return "course/list";
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

    // @RequestMapping(value = { "/contact" }, method = RequestMethod.POST)
    // public String saveNewUser(@Valid ContactMessage contactMessage,
    // BindingResult bResult) {
    // if (bResult.hasErrors()) {
    // return "contact";
    // }
    //
    // SimpleMailMessage msg = new SimpleMailMessage();
    // msg.setTo("maciej.imiela@gmail.com");
    // msg.setText(contactMessage.getMessage());
    // msg.setSubject("Please contact me, as soon as you can: "
    // + contactMessage.getEmail());
    // try {
    // this.mailSender.send(msg);
    // } catch (MailException ex) {
    // // log it and go on
    // logger.error(ex.getMessage());
    // return "redirect:/home?message=" + FAIL_MESSAGE;
    // }
    // return "redirect:/home?message=" + SUCCES_MESSAGE;
    // }
    //
    // @RequestMapping(value = { "/register" }, method = RequestMethod.POST)
    // public String saveNewUser(@Valid User user, BindingResult bResult) {
    // if (bResult.hasErrors()) {
    // return "register";
    // }
    // // service.saveUser(user);
    // // return "redirect:/users/user?id=" + user.getId();
    // return "redirect:/home?message=" + SUCCES_REGISTER;
    // }

    @RequestMapping(value = { "/", "/index", "/home" }, method = RequestMethod.GET)
    public String showHomePage() {
        // User u = service.getUser(1);
        // model.addAttribute("user", u);
        // logger.info("{}.", u);
        return "index";
    }
}
