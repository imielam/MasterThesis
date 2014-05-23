package com.maciej.imiela.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maciej.imiela.entity.Course;
import com.maciej.imiela.entity.CourseType;
import com.maciej.imiela.entity.Participant;
import com.maciej.imiela.entity.Teacher;
import com.maciej.imiela.repository.CourseRepository;
import com.maciej.imiela.repository.CourseTypeRepository;
import com.maciej.imiela.repository.ParticipantRepository;
import com.maciej.imiela.repository.TeacherRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private CourseTypeRepository courseTypeRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    public Course findOne(int id) {
        return this.courseRepository.findOne(id);
    }

    @Transactional
    public Course findOneWithParticipants(int id) {
        Course course = this.findOne(id);
        List<Participant> participants = this.participantRepository
                .findByCourse(course);
        course.setParticipants(participants);
        return course;
    }

    public Course save(Course course) {
        Course oldCourse = course;
        Teacher newTeacher = course.getTeacher();
        Teacher oldTeacher = newTeacher;
        CourseType newType = course.getType();
        CourseType oldType = newType;

        if (course.getId() != null) {
            oldCourse = this.findOne(course.getId());
            oldCourse.update(course);
        }
        if (newTeacher.getId() != null) {
            oldTeacher = this.teacherRepository.findOne(newTeacher.getId());
            oldTeacher.update(newTeacher);
        }
        this.teacherRepository.save(oldTeacher);

        if (newType.getId() != null) {
            oldType = this.courseTypeRepository.findOne(newType.getId());
            oldType.update(newType);
        }
        this.courseTypeRepository.save(oldType);
        return this.courseRepository.save(oldCourse);
    }
}
