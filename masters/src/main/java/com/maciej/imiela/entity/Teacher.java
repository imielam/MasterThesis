package com.maciej.imiela.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Teacher {

    @Id
    @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private Integer id;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = true)
    private Date endDate;

    @Column(nullable = false)
    private Double salary;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public List<Course> getCourses() {
        return this.courses;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public Integer getId() {
        return this.id;
    }

    public Double getSalary() {
        return this.salary;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public User getUser() {
        return this.user;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
