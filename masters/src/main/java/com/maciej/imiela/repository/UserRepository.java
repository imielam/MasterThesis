package com.maciej.imiela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    // @Query("select u from User where ("
    // + "(select l.id from l Login where l.login = :login)"
    // + " = u.login_id")

    public User findByLoginLogin(String login);

    public User findByName(String username);

}
