package com.maciej.imiela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.CourseType;

public interface CourseTypeRepository extends
JpaRepository<CourseType, Integer> {

    CourseType findByName(String name);

}
