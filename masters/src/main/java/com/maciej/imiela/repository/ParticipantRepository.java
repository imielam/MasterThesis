package com.maciej.imiela.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.Course;
import com.maciej.imiela.entity.Participant;
import com.maciej.imiela.entity.User;

public interface ParticipantRepository extends
        JpaRepository<Participant, Integer> {

    List<Participant> findByCourse(Course course);

    List<Participant> findByCourseAndAccepted(Course course, boolean accepted);

    Participant findByCourseAndUser(Course course, User user);

    List<Participant> findByCourseIsNull();

    List<Participant> findByUser(User user);
}
