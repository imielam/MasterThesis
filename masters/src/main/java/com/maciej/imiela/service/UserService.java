package com.maciej.imiela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maciej.imiela.entity.User;
import com.maciej.imiela.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findOne(int id) {
        return this.userRepository.findOne(id);
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }
}
