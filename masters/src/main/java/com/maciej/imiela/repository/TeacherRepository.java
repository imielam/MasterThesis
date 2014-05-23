package com.maciej.imiela.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.Teacher;
import com.maciej.imiela.entity.User;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    List<Teacher> findByUser(User user);

}
