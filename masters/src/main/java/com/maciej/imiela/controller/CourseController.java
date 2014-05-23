/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maciej.imiela.entity.Course;
import com.maciej.imiela.entity.CourseType;
import com.maciej.imiela.entity.Teacher;
import com.maciej.imiela.service.CourseService;
import com.maciej.imiela.service.CourseTypeService;
import com.maciej.imiela.service.TeacherService;

/**
 *
 * @author Maciej
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseTypeService courseTypeService;

    private static final Logger logger = LoggerFactory
            .getLogger(CourseController.class);

    @RequestMapping(value = { "/create" }, method = RequestMethod.GET)
    public String createNewCourse(Model model) {
        model.addAttribute("course", new Course());
        Map<Integer, String> mapTeachers = new HashMap<Integer, String>();
        List<Teacher> teachers = this.teacherService.findAll();
        for (Teacher t : teachers) {
            mapTeachers.put(t.getId(), t.getUser().getName());
        }
        model.addAttribute("mapTeachers", mapTeachers);
        Map<Integer, String> mapType = new HashMap<Integer, String>();
        List<CourseType> types = this.courseTypeService.findAll();
        for (CourseType t : types) {
            mapType.put(t.getId(), t.getName());
        }
        model.addAttribute("mapType", mapType);
        return "course/create";
    }

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

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String editCourse(Model model, @PathVariable int id) {
        model.addAttribute("course",
                this.courseService.findOneWithParticipants(id));
        Map<Integer, String> mapTeachers = new HashMap<Integer, String>();
        List<Teacher> teachers = this.teacherService.findAll();
        for (Teacher t : teachers) {
            mapTeachers.put(t.getId(), t.getUser().getName());
        }
        model.addAttribute("mapTeachers", mapTeachers);
        Map<Integer, String> mapType = new HashMap<Integer, String>();
        List<CourseType> types = this.courseTypeService.findAll();
        for (CourseType t : types) {
            mapType.put(t.getId(), t.getName());
        }
        model.addAttribute("mapType", mapType);
        return "course/edit";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String saveCourse(Model model, @PathVariable int id, Course course,
            BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "course/edit";
        }
        course.setId(id);
        this.courseService.save(course);
        return "redirect:/course/detail/" + course.getId()
                + ".html?success=true";
    }

    @RequestMapping(value = { "/create" }, method = RequestMethod.POST)
    public String saveNewCourse(Course course, BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "course/edit";
        }
        course = this.courseService.save(course);
        return "redirect:/course/detail/" + course.getId()
                + ".html?success=true";
    }
}
