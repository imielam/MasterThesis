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

    public List<Role> getRoles() {
        return this.roles;
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
                + ((this.roles == null) ? 0 : this.roles.hashCode());
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

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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
        if (newLogin.getRoles() != null
                && !newLogin.getRoles().equals(this.getRoles())) {
            // TODO te¿ nie tak to powinno wygl¹daæ, chyba ...
            this.roles = newLogin.roles;
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
