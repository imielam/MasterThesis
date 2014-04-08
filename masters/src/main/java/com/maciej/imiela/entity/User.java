package com.maciej.imiela.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {

    @Id
    @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private Integer id;

    private String name;

    private String emil;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs;

    @ManyToMany
    @JoinTable
    private List<Role> roles;

    public List<Blog> getBlogs() {
        return this.blogs;
    }

    public String getEmil() {
        return this.emil;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
