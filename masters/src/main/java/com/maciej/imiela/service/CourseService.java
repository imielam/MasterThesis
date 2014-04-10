package com.maciej.imiela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maciej.imiela.entity.Course;
import com.maciej.imiela.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    public Course findOne(int id) {
        return this.courseRepository.findOne(id);
    }
}
