package com.maciej.imiela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
