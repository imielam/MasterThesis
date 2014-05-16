package com.maciej.imiela.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Login {

    @Id
    @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Transient
    private String rePassword;

    // @OneToOne
    // @JoinColumn(name = "user_id", nullable = false)
    // private User user;

    @ManyToMany
    @JoinTable
    private List<Role> roles;

    public String getEmail() {
        return this.email;
    }

    public Integer getId() {
        return this.id;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRePassword() {
        return this.rePassword;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setEmail(String emil) {
        this.email = emil;
    }

    //
    // public User getUser() {
    // return this.user;
    // }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    //
    // public void setUser(User user) {
    // this.user = user;
    // }

    public Login update(Login newLogin) {
        if (newLogin.getEmail() != null && newLogin.getEmail() != this.email) {
            this.email = newLogin.getEmail();
        }
        if (newLogin.getPassword() != null
                && newLogin.getPassword() != this.password) {
            this.password = newLogin.getPassword();
        }
        if (newLogin.getRoles() != null
                && !newLogin.getRoles().equals(this.getRoles())) {
            this.roles = newLogin.getRoles();
        }
        if (newLogin.getLogin() != null && newLogin.getLogin() != this.login) {
            this.login = newLogin.getLogin();
        }
        return this;
    }

}
