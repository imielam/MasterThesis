package com.maciej.imiela.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CourseType {

    @Id
    @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer maxParticipantNumber;

    @Column(nullable = true)
    private String description;

    public String getDescription() {
        return this.description;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getMaxParticipantNumber() {
        return this.maxParticipantNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMaxParticipantNumber(Integer maxParticipantNumber) {
        this.maxParticipantNumber = maxParticipantNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
}
