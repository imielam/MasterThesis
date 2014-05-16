package com.maciej.imiela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maciej.imiela.entity.Login;
import com.maciej.imiela.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public List<Login> findAll() {
        return this.loginRepository.findAll();
    }

    /*
     * TODO: Add null check
     */
    public Login findByLogin(String login) {
        return this.loginRepository.findByLogin(login);
    }

    public Login findOne(int id) {
        return this.loginRepository.findOne(id);
    }

    public void save(Login login) {
        this.loginRepository.save(login);

    }
}
