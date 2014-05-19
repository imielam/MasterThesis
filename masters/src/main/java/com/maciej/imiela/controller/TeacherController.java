package com.maciej.imiela.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.maciej.imiela.entity.Teacher;
import com.maciej.imiela.service.TeacherService;

/**
 *
 * @author Maciej
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    private static final Logger logger = LoggerFactory
            .getLogger(TeacherController.class);

    @RequestMapping(value = { "/detail/{id}" }, method = RequestMethod.GET)
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("teacher", this.teacherService.findOne(id));
        return "teacher/detail";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("teacher", this.teacherService.findOne(id));
        return "teacher/edit";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String save(Model model, @PathVariable int id, Teacher teacher,
            BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "teacher/edit";
        }
        teacher.setId(id);
        this.teacherService.save(teacher);
        return "redirect:/teacher/detail/" + teacher.getId()
                + ".html?success=true";
    }
}
