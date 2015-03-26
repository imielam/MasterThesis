package com.maciej.imiela.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.maciej.imiela.annotation.UniqueLoginEmail;
import com.maciej.imiela.annotation.UniqueLoginLogin;

@Entity
public class Login {

    @Id
    // @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy",
    // strategy = "hilo")
    // @GeneratedValue(generator = "hilo-strategy")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull
    @Size(min = 3, message = "Must have at least 3 characters!")
    @UniqueLoginLogin(message = "Login is occupied!")
    @Column(unique = true, nullable = false)
    private String login;

    @Email
    @NotNull
    @UniqueLoginEmail(message = "Email is occupied!")
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    @Size(min = 8, message = "Must have at least 8 characters!")
    @Column(nullable = false)
    private String password;

    @Size(min = 8, message = "Must have at least 8 characters!")
    // TODO: add validator for checking if rePassword equals password
    // customValidator probably
    @Transient
    private String rePassword;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    // TODO Add a verification

    // @OneToOne
    // @JoinColumn(name = "user_id", nullable = false)
    // private User user;

    public Login() {
        this.role = new Role();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Login other = (Login) obj;
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

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

    //
    // public User getUser() {
    // return this.user;
    // }

    public Role getRole() {
        return this.role;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    public void setEmail(String emil) {
        this.email = emil;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //
    // public void setUser(User user) {
    // this.user = user;
    // }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Login update(Login newLogin) {
        if (newLogin.id != null && !newLogin.id.equals(this.id)) {
            this.id = newLogin.id;
        }
        if (newLogin.email != null && !newLogin.email.equals(this.email)) {
            this.email = newLogin.email;
        }
        if (newLogin.getPassword() != null
                && !newLogin.password.equals(this.password)) {
            this.password = newLogin.password;
        }
        if (newLogin.getRole() != null
                && !newLogin.getRole().equals(this.getRole())) {
            // TODO te� nie tak to powinno wygl�da�, chyba ...
            this.role = newLogin.role;
        }
        if (newLogin.login != null && !newLogin.login.equals(this.login)) {
            this.login = newLogin.login;
        }
        return this;
    }

    public Login updateEssentials(Login newLogin) {
        if (newLogin.id != null && !newLogin.id.equals(this.id)) {
            this.id = newLogin.id;
        }
        if (newLogin.email != null && !newLogin.email.equals(this.email)) {
            this.email = newLogin.email;
        }
        if (newLogin.getPassword() != null
                && !newLogin.password.equals(this.password)) {
            this.password = newLogin.password;
        }
        if (newLogin.login != null && !newLogin.login.equals(this.login)) {
            this.login = newLogin.login;
        }
        return this;
    }

}
