package com.maciej.imiela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maciej.imiela.entity.Participant;
import com.maciej.imiela.repository.ParticipantRepository;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> findAll() {
        return this.participantRepository.findAll();
    }

    public Participant findOne(int id) {
        return this.participantRepository.findOne(id);
    }

    public Participant save(Participant participant) {
        Participant oldParticipant = participant;
        if (participant.getId() != null) {
            oldParticipant = this.findOne(participant.getId());
            oldParticipant.update(participant);
        }
        return this.participantRepository.save(oldParticipant);
    }

}
