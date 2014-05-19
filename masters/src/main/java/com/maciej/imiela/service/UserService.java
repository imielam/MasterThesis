package com.maciej.imiela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maciej.imiela.entity.Login;
import com.maciej.imiela.entity.User;
import com.maciej.imiela.repository.AddressRepository;
import com.maciej.imiela.repository.LoginRepository;
import com.maciej.imiela.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private LoginRepository loginRepository;

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findOne(int id) {
        return this.userRepository.findOne(id);
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
