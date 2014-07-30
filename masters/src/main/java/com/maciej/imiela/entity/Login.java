package com.maciej.imiela.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Login {

    @Id
    @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private Integer id;

    @Size(min = 3, message = "Must have at least 3 characters!")
    @Column(unique = true, nullable = false)
    private String login;

    @Email
    @NotNull
    @Column(unique = true, nullable = false)
    private String email;

    @Size(min = 8, message = "Must have at least 8 characters!")
    @Column(nullable = false)
    private String password;

    @Size(min = 8, message = "Must have at least 8 characters!")
    // TODO: add validator for checking if rePassword equals password
    // customValidator probably
    @Transient
    private String rePassword;

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
        if (this.email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!this.email.equals(other.email)) {
            return false;
        }
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
            return false;
        }
        if (this.login == null) {
            if (other.login != null) {
                return false;
            }
        } else if (!this.login.equals(other.login)) {
            return false;
        }
        if (this.password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!this.password.equals(other.password)) {
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

    public Role getRole() {
        return this.role;
    }

    //
    // public User getUser() {
    // return this.user;
    // }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((this.email == null) ? 0 : this.email.hashCode());
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result
                + ((this.login == null) ? 0 : this.login.hashCode());
        result = prime * result
                + ((this.password == null) ? 0 : this.password.hashCode());
        result = prime * result
                + ((this.role == null) ? 0 : this.role.hashCode());
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
            // TODO te¿ nie tak to powinno wygl¹daæ, chyba ...
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
