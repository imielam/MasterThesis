/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maciej.imiela.entity.Course;
import com.maciej.imiela.service.CourseService;

/**
 *
 * @author Maciej
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    private static final Logger logger = LoggerFactory
            .getLogger(CourseController.class);

    @RequestMapping(value = { "/detail/{id}" })
    public String detail(Model model, @PathVariable int id) {
        final Course course = this.courseService.findOneWithParticipants(id);
        model.addAttribute("course", course);
        return "course/details";
    }

    @RequestMapping(value = { "/list" })
    public String displayCoursesList(Model model) {
        final List<Course> allCourses = this.courseService.findAll();
        // logger.info(Arrays.toString(allCourses.toArray()));
        model.addAttribute("courses", allCourses);
        return "course/list";
    }
}
