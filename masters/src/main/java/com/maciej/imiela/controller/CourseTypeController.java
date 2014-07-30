/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maciej.imiela.entity.CourseType;
import com.maciej.imiela.service.CourseTypeService;

/**
 *
 * @author Maciej
 */
@Controller
@RequestMapping("/course_type")
public class CourseTypeController {

    // @Autowired
    // private CourseService courseService;
    //
    // @Autowired
    // private TeacherService teacherService;

    @Autowired
    private CourseTypeService courseTypeService;

    private static final Logger logger = LoggerFactory
            .getLogger(CourseTypeController.class);

    @RequestMapping(value = { "/create" }, method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("courseType", new CourseType());
        return "course_type/edit";
    }

    @RequestMapping(value = { "/detail/{id}" }, method = RequestMethod.GET)
    public String detail(Model model, @PathVariable int id) {
        final CourseType courseType = this.courseTypeService.findOne(id);
        model.addAttribute("courseType", courseType);
        return "course_type/details";
    }

    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String displayCoursesList(Model model) {
        final List<CourseType> allTypes = this.courseTypeService.findAll();
        // logger.info(Arrays.toString(allCourses.toArray()));
        model.addAttribute("types", allTypes);
        return "course_type/list";
    }

    // @InitBinder
    // public void initBinder(WebDataBinder binder) {
    // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // dateFormat.setLenient(false);
    // binder.registerCustomEditor(Date.class, new CustomDateEditor(
    // dateFormat, false));
    // }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("courseType", this.courseTypeService.findOne(id));
        return "course_type/edit";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String save(Model model, @PathVariable int id,
            @Valid CourseType courseType, BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "course_type/edit";
        }
        courseType.setId(id);
        this.courseTypeService.save(courseType);
        return "redirect:/course_type/detail/" + courseType.getId()
                + ".html?success=true";
    }

    @RequestMapping(value = { "/create" }, method = RequestMethod.POST)
    public String saveNew(Model model, @Valid CourseType courseType,
            BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "course_type/edit";
        }
        this.courseTypeService.save(courseType);
        return "redirect:/course_type/detail/" + courseType.getId()
                + ".html?success=true";
    }
}
