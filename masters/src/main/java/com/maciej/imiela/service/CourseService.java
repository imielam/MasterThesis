package com.maciej.imiela.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maciej.imiela.entity.Course;
import com.maciej.imiela.entity.Participant;
import com.maciej.imiela.repository.CourseRepository;
import com.maciej.imiela.repository.ParticipantRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ParticipantRepository participantRepository;

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
}
