package com.maciej.imiela.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Participant {

    @Id
    @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Boolean passed;

    @Column(nullable = true)
    private Integer score;

    @Column(nullable = true)
    private String notes;

    public Course getCourse() {
        return this.course;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNotes() {
        return this.notes;
    }

    public Boolean getPassed() {
        return this.passed;
    }

    public Integer getScore() {
        return this.score;
    }

    public User getUser() {
        return this.user;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
