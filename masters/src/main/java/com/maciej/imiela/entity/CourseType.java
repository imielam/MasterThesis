package com.maciej.imiela.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.maciej.imiela.annotation.UniqueCourseTypeName;

@Entity
public class CourseType {

    @Id
    // @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy",
    // strategy = "hilo")
    // @GeneratedValue(generator = "hilo-strategy")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Size(min = 3, message = "Must have at least 3 characters!")
    @NotNull
    @UniqueCourseTypeName(message = "Course type with such name already exists!")
    @Column(unique = true, nullable = false)
    private String name;

    @NotNull
    @Max(30)
    @Column(nullable = false)
    private Integer maxParticipantNumber;

    @Column(nullable = true, length = 10000)
    private String description;

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
        CourseType other = (CourseType) obj;
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
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

    public CourseType update(CourseType newType) {
        if (newType.id != null && !newType.id.equals(this.id)) {
            this.id = newType.id;
        }
        if (newType.description != null
                && !newType.description.equals(this.description)) {
            this.description = newType.description;
        }
        if (newType.maxParticipantNumber != null
                && !newType.maxParticipantNumber
                        .equals(this.maxParticipantNumber)) {
            this.maxParticipantNumber = newType.maxParticipantNumber;
        }
        if (newType.name != null && !newType.name.equals(this.name)) {
            this.name = newType.name;
        }

        return this;
    }
}
