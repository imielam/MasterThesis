package com.maciej.imiela.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Course {

    @Id
    @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private Integer id;

    @OneToOne
    private CourseType type;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @OneToMany(mappedBy = "course")
    private List<Participant> participants;

    @ManyToOne
    @JoinTable(name = "teacher_id")
    private Teacher teacher;

    public Date getEndDate() {
        return this.endDate;
    }

    public Integer getId() {
        return this.id;
    }

    public List<Participant> getParticipants() {
        return this.participants;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public CourseType getType() {
        return this.type;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

}
