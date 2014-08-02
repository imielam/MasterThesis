package com.maciej.imiela.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.Login;
import com.maciej.imiela.entity.Role;

public interface LoginRepository extends JpaRepository<Login, Integer> {

    Login findByEmail(String email);

    Login findByLogin(String login);

    List<Login> findByRole(Role role);

}
