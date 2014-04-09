package com.maciej.imiela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
