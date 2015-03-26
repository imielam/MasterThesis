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

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
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
import com.maciej.imiela.entity.Login;
import com.maciej.imiela.entity.Participant;
import com.maciej.imiela.entity.Role;
import com.maciej.imiela.entity.Teacher;
import com.maciej.imiela.entity.User;
import com.maciej.imiela.service.CourseService;
import com.maciej.imiela.service.CourseTypeService;
import com.maciej.imiela.service.LoginService;
import com.maciej.imiela.service.ParticipantService;
import com.maciej.imiela.service.RoleService;
import com.maciej.imiela.service.TeacherService;
import com.maciej.imiela.service.UserService;

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

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private LoginService loginService;

    private static final Logger logger = LoggerFactory
            .getLogger(CourseController.class);

    @RequestMapping(value = { "/add/participants/{id}" }, method = RequestMethod.GET)
    public String addParticipants(Model model, @PathVariable int id) {
        Course course = this.courseService.findOneWithParticipantsIsNull(id);
        // List<Participant> participants = course.getParticipants();
        List<User> users = this.userService.findUsersAvailableToAddToCourse(id);
        model.addAttribute("course", course);
        Map<Integer, String> mapUsers = new HashMap<Integer, String>();
        for (User p : users) {
            mapUsers.put(p.getId(), p.getName());
        }
        model.addAttribute("mapParticipants", mapUsers);
        return "course/edit/participants";
    }

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

    @RequestMapping(value = { "/detail/{id}" }, method = RequestMethod.GET)
    public String detail(Model model, @PathVariable int id) {
        final Course course = this.courseService.findOneWithParticipants(id);
        model.addAttribute("course", course);
        return "course/details";
    }

    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String displayCoursesList(Model model) {
        final List<Course> allCourses = this.courseService.findAll();
        // logger.info(Arrays.toString(allCourses.toArray()));
        model.addAttribute("courses", allCourses);
        return "course/list";
    }

    // @RequestMapping(value = { "/edit/participants/{id}" }, method =
    // RequestMethod.GET)
    // public String editParticipants(Model model, @PathVariable int id) {
    // Course course = this.courseService.findOneWithParticipants(id);
    // course.getParticipants();
    // model.addAttribute("course", course);
    // Map<Integer, String> mapParticipants = new HashMap<Integer, String>();
    // List<Participant> participants = this.participantService.findAll();
    // for (Participant p : participants) {
    // mapParticipants.put(p.getId(), p.getUser().getName());
    // }
    // model.addAttribute("mapParticipants", mapParticipants);
    // return "course/edit/participants";
    // }

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
        binder.registerCustomEditor(List.class, new CustomCollectionEditor(
                List.class) {

            @Override
            protected Object convertElement(Object element) {
                Integer id = null;

                if (element instanceof String && !((String) element).equals("")) {
                    // From the JSP 'element' will be a String
                    try {
                        id = Integer.parseInt((String) element);
                    } catch (NumberFormatException e) {
                        logger.error("Element was " + ((String) element), e);
                    }
                } else if (element instanceof Integer) {
                    // From the database 'element' will be a Long
                    id = (Integer) element;
                }
                if (id != null) {
                    Participant p = new Participant();
                    p.setUser(new User(id));
                    return p;
                } else {
                    return null;
                }

            }
        });
    }

    @RequestMapping(value = { "/add/participants/{id}" }, method = RequestMethod.POST)
    public String saveAddedParticipants(Model model, @PathVariable int id,
            Course course) {
        // Course oldCourse = this.courseService.findOneWithParticipants(id);
        // List<Participant> oldListParticipants = oldCourse.getParticipants();
        course.setId(id);
        course = this.courseService.saveParticipants(course);
        Role roleParticipant = this.roleService.findByName("ROLE_PARTICIPANT");
        for (Participant p : course.getParticipants()) {
            Login l = this.userService.findOne(p.getUser().getId()).getLogin();
            l.setRole(roleParticipant);
            this.loginService.save(l);
        }
        return "redirect:/course/detail/" + id + ".html?success=true";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String saveCourse(Model model, @PathVariable int id,
            @Valid Course course, BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "course/edit";
        }
        course.setId(id);
        this.courseService.save(course);
        return "redirect:/course/detail/" + course.getId()
                + ".html?success=true";
    }

    @RequestMapping(value = { "/create" }, method = RequestMethod.POST)
    public String saveNewCourse(Model model, @Valid Course course,
            BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "course/edit";
        }
        course = this.courseService.save(course);
        return "redirect:/course/detail/" + course.getId()
                + ".html?success=true";
    }

    @RequestMapping(value = { "/edit/participants/{id}" }, method = RequestMethod.POST)
    public String saveParticipants(Model model, @PathVariable int id,
            @Valid Course course, BindingResult bResult) {
        // Course course = this.courseService.findOneWithParticipants(id);
        if (bResult.hasErrors()) {
            logger.error(bResult.toString());
            return "course/edit/participants";
        }
        course.getParticipants();
        model.addAttribute("course", course);
        Map<Participant, String> mapParticipants = new HashMap<Participant, String>();
        List<Participant> participants = this.participantService.findAll();
        for (Participant p : participants) {
            mapParticipants.put(p, p.getUser().getName());
        }
        model.addAttribute("mapParticipants", mapParticipants);
        return "course/edit/participants";
    }
}
