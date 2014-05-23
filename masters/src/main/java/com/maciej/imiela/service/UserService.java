package com.maciej.imiela.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maciej.imiela.entity.Login;
import com.maciej.imiela.entity.Participant;
import com.maciej.imiela.entity.Teacher;
import com.maciej.imiela.entity.User;
import com.maciej.imiela.repository.AddressRepository;
import com.maciej.imiela.repository.LoginRepository;
import com.maciej.imiela.repository.ParticipantRepository;
import com.maciej.imiela.repository.TeacherRepository;
import com.maciej.imiela.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findOne(int id) {
        return this.userRepository.findOne(id);
    }

    @Transactional
    public User findOneWithParticipantAndTeachers(int id) {
        User user = this.findOne(id);
        List<Participant> participants = this.participantRepository
                .findByUser(user);
        user.setParticipants(participants);
        List<Teacher> teachers = this.teacherRepository.findByUser(user);
        user.setTeachers(teachers);
        return user;
    }

    // public User save(User user) {
    // return this.userRepository.save(user);
    // }

    public User save(User user) {
        // logger.info(user.toString());
        this.addressRepository.save(user.getPermamentAddress());
        this.addressRepository.save(user.getResidenceAddress());
        user.setLogin(this.saveLogin(user));
        return this.userRepository.save(user);
    }

    /*
     * TODO: Add validation for contraint (unique login and email)
     */
    private Login saveLogin(User user) {
        Login newLogin = user.getLogin();
        Login oldLogin = newLogin;
        if (user.getId() != null) {
            User oldUser = this.findOne(user.getId());
            oldLogin = this.loginRepository.findOne(oldUser.getLogin().getId());
            oldLogin.update(newLogin);
        }
        this.loginRepository.save(oldLogin);
        return oldLogin;
    }
}
