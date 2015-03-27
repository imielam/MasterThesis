package com.maciej.imiela.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.maciej.imiela.repository.UserRepository;

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

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory
            .getLogger(CourseService.class);

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

    @Transactional
    public Course findOneWithParticipantsIsNull(int id) {
        Course course = this.findOne(id);
        List<Participant> participants = this.participantRepository
                .findByCourseIsNull();
        course.setParticipants(participants);
        return course;
    }

    public List<Course> findWithStartDateLaterThen(Date date) {
        return this.courseRepository.findByStartDateAfter(date);
    }

    public Course save(Course course) {
        Course oldCourse = course;
        if (course != null) {
            if (course.getId() != null) {
                oldCourse = this.findOne(course.getId());
                oldCourse.updateEssentials(course);
            }
        } else {
            logger.error("course == null");
            return course;
        }
        Teacher newTeacher = course.getTeacher();
        Teacher oldTeacher = oldCourse.getTeacher();

        if (newTeacher != null && newTeacher.getId() != null) {
            oldTeacher = this.teacherRepository.findOne(newTeacher.getId());
        }
        // this.teacherRepository.save(oldTeacher);
        oldCourse.setTeacher(oldTeacher);

        CourseType newType = course.getType();
        CourseType oldType = oldCourse.getType();

        if (newType != null && newType.getId() != null) {
            oldType = this.courseTypeRepository.findOne(newType.getId());
        }
        // this.courseTypeRepository.save(oldType);
        oldCourse.setType(oldType);
        return this.courseRepository.save(oldCourse);
    }

    public Course saveParticipants(Course course) {
        Course oldCourse = course;
        if (course != null) {
            if (course.getId() == null) {
                // oldCourse = this.findOneWithParticipants(course.getId());
                // } else {
                logger.error("Forgot to set ID in controller");
                return course;
            }
        } else {
            logger.error("course == null");
            return course;
        }
        // List<Participant> newList = this.participantRepository.findAll(course
        // .getParticipantsID());
        // List<Participant> oldList = oldCourse.getParticipants();
        for (Participant p : oldCourse.getParticipants()) {
            p.setUser(this.userRepository.findOne(p.getUser().getId()));
            p.setCourse(course);
            this.participantRepository.save(p);
        }
        // oldList.addAll(newList);
        // oldCourse.setParticipants(oldList);
        return this.findOneWithParticipants(course.getId());
    }

    @Transactional
    public Course signNewParticipant(Participant p) {
        p.setCourse(this.courseRepository.findOne(p.getCourse().getId()));
        this.participantRepository.save(p);
        return this.courseRepository.findOne(p.getCourse().getId());
    }
}
