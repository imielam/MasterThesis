package com.maciej.imiela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maciej.imiela.entity.CourseType;
import com.maciej.imiela.repository.CourseTypeRepository;

@Service
public class CourseTypeService {

    @Autowired
    private CourseTypeRepository courseTypeRepository;

    public List<CourseType> findAll() {
        return this.courseTypeRepository.findAll();
    }

    public CourseType findOne(int id) {
        return this.courseTypeRepository.findOne(id);
    }

    // public CourseType save(CourseType courseType) {
    // return this.courseTypeRepository.save(courseType);
    // }
    public CourseType save(CourseType courseType) {
        CourseType oldCourseType = courseType;
        if (courseType.getId() != null) {
            oldCourseType = this.findOne(courseType.getId());
            oldCourseType.update(courseType);
        }
        return this.courseTypeRepository.save(oldCourseType);
    }
}
