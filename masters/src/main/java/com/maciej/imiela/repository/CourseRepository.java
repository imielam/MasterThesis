package com.maciej.imiela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
