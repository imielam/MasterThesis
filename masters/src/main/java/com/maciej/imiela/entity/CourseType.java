package com.maciej.imiela.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CourseType {

    @Id
    @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private Integer id;

    @Size(min = 3, message = "Must have at least 3 characters!")
    @Column(unique = true, nullable = false)
    private String name;

    @NotNull
    @Max(30)
    @Column(nullable = false)
    private Integer maxParticipantNumber;

    @Column(nullable = true)
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
        if (this.description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!this.description.equals(other.description)) {
            return false;
        }
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
            return false;
        }
        if (this.maxParticipantNumber == null) {
            if (other.maxParticipantNumber != null) {
                return false;
            }
        } else if (!this.maxParticipantNumber
                .equals(other.maxParticipantNumber)) {
            return false;
        }
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
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
        result = prime
                * result
                + ((this.description == null) ? 0 : this.description.hashCode());
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime
                * result
                + ((this.maxParticipantNumber == null) ? 0
                        : this.maxParticipantNumber.hashCode());
        result = prime * result
                + ((this.name == null) ? 0 : this.name.hashCode());
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
