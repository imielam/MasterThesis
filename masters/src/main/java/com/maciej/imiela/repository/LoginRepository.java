package com.maciej.imiela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
