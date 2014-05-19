package com.maciej.imiela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maciej.imiela.entity.Teacher;
import com.maciej.imiela.repository.TeacherRepository;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> findAll() {
        return this.teacherRepository.findAll();
    }

    public Teacher findOne(int id) {
        return this.teacherRepository.findOne(id);
    }

    // public Teacher save(Teacher teacher) {
    // return this.teacherRepository.save(teacher);
    // }
    public Teacher save(Teacher teacher) {
        Teacher oldTeacher = teacher;
        if (teacher.getId() != null) {
            oldTeacher = this.findOne(teacher.getId());
            oldTeacher.update(teacher);
        }
        return this.teacherRepository.save(oldTeacher);
    }
}
