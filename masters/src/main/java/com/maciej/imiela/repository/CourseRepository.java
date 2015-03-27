package com.maciej.imiela.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    public List<Course> findByStartDateAfter(Date date);

}
