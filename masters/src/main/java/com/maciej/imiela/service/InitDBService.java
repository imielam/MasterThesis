package com.maciej.imiela.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maciej.imiela.entity.Address;
import com.maciej.imiela.entity.Course;
import com.maciej.imiela.entity.CourseType;
import com.maciej.imiela.entity.Login;
import com.maciej.imiela.entity.Participant;
import com.maciej.imiela.entity.Role;
import com.maciej.imiela.entity.Teacher;
import com.maciej.imiela.entity.User;
import com.maciej.imiela.repository.AddressRepository;
import com.maciej.imiela.repository.CourseRepository;
import com.maciej.imiela.repository.CourseTypeRepository;
import com.maciej.imiela.repository.LoginRepository;
import com.maciej.imiela.repository.ParticipantRepository;
import com.maciej.imiela.repository.RoleRepository;
import com.maciej.imiela.repository.TeacherRepository;
import com.maciej.imiela.repository.UserRepository;

@Transactional
@Service
public class InitDBService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseTypeRepository courseTypeRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private LoginRepository loginRepository;

    @PostConstruct
    public void init() {
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        this.roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        this.roleRepository.save(roleAdmin);

        Address a1 = new Address();
        a1.setStreet("Pozarowa");
        a1.setStreetHN("3B");
        a1.setStreetAN("71");
        a1.setCity("Warszawa");
        a1.setPostalCode("03-309");
        this.addressRepository.save(a1);

        Address a2 = new Address();
        a2.setStreet("Budryka");
        a2.setStreetHN("14");
        a2.setStreetAN("5");
        a2.setCity("Belchatow");
        a2.setPostalCode("97-400");
        this.addressRepository.save(a2);

        Login l1 = new Login();
        l1.setLogin("admin");
        l1.setPassword("admin");
        l1.setEmail("admin@ma.com");
        // l1.setUser(userAdmin);
        List<Role> lr = new ArrayList<Role>();
        lr.add(roleAdmin);
        l1.setRoles(lr);
        this.loginRepository.save(l1);

        User userAdmin = new User();
        userAdmin.setName("Maciej Imiela");
        userAdmin.setPermamentAddress(a1);
        userAdmin.setResidenceAddress(a2);
        userAdmin.setLogin(l1);
        this.userRepository.save(userAdmin);

        Login l2 = new Login();
        l2.setLogin("teacher");
        l2.setPassword("teacher");
        l2.setEmail("teacher@ma.com");
        // l2.setUser(userTeacher);
        lr = new ArrayList<Role>();
        lr.add(roleUser);
        l2.setRoles(lr);
        this.loginRepository.save(l2);

        User userTeacher = new User();
        userTeacher.setName("Nauczyciel1");
        userTeacher.setPermamentAddress(a1);
        userTeacher.setLogin(l2);
        this.userRepository.save(userTeacher);

        Login l3 = new Login();
        l3.setLogin("participant");
        l3.setPassword("participant");
        l3.setEmail("participant@ma.com");
        // l3.setUser(userKursant);
        lr = new ArrayList<Role>();
        lr.add(roleUser);
        l3.setRoles(lr);
        this.loginRepository.save(l3);

        User userKursant = new User();
        userKursant.setName("Kursant1");
        userKursant.setPermamentAddress(a2);
        userKursant.setResidenceAddress(a1);
        userKursant.setLogin(l3);
        this.userRepository.save(userKursant);

        Teacher t1 = new Teacher();
        t1.setSalary((double) 2500);
        t1.setStartDate(new Date());
        t1.setUser(userTeacher);
        this.teacherRepository.save(t1);

        CourseType ct1 = new CourseType();
        ct1.setName("SZKOLENIA OKRESOWE");
        ct1.setMaxParticipantNumber(15);
        ct1.setDescription("System szkoleñ okresowych „35 h w dowolnym tempie” zosta³ skonstruowany tak, aby z jednej strony realizowaæ odgórny program szkolenia zgodny z podstaw¹ prawn¹ a z drugiej – daæ mo¿liwoœæ w ramach obowi¹zkowych 35 godzin na dopasowanie treœci szkolenia do specjalizacji kierowcy.");
        this.courseTypeRepository.save(ct1);

        Course c1 = new Course();
        c1.setStartDate(new Date());
        c1.setEndDate(new Date());
        c1.setTeacher(t1);
        c1.setType(ct1);
        this.courseRepository.save(c1);

        Participant p1 = new Participant();
        p1.setCourse(c1);
        p1.setPassed(false);
        p1.setUser(userKursant);
        this.participantRepository.save(p1);

    }

}
