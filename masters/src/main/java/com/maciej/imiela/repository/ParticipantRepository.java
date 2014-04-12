package com.maciej.imiela.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.Course;
import com.maciej.imiela.entity.Participant;

public interface ParticipantRepository extends
        JpaRepository<Participant, Integer> {

    List<Participant> findByCourse(Course course);
}
