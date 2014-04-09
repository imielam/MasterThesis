package com.maciej.imiela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.Participant;

public interface ParticipantRepository extends
        JpaRepository<Participant, Integer> {

}
