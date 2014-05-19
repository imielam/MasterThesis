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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Teacher {

    @Id
    @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private Integer id;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Column(nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @Column(nullable = false)
    private Double salary;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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
        Teacher other = (Teacher) obj;
        if (this.courses == null) {
            if (other.courses != null) {
                return false;
            }
        } else if (!this.courses.equals(other.courses)) {
            return false;
        }
        if (this.endDate == null) {
            if (other.endDate != null) {
                return false;
            }
        } else if (!this.endDate.equals(other.endDate)) {
            return false;
        }
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
            return false;
        }
        if (this.salary == null) {
            if (other.salary != null) {
                return false;
            }
        } else if (!this.salary.equals(other.salary)) {
            return false;
        }
        if (this.startDate == null) {
            if (other.startDate != null) {
                return false;
            }
        } else if (!this.startDate.equals(other.startDate)) {
            return false;
        }
        if (this.user == null) {
            if (other.user != null) {
                return false;
            }
        } else if (!this.user.equals(other.user)) {
            return false;
        }
        return true;
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((this.courses == null) ? 0 : this.courses.hashCode());
        result = prime * result
                + ((this.endDate == null) ? 0 : this.endDate.hashCode());
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result
                + ((this.salary == null) ? 0 : this.salary.hashCode());
        result = prime * result
                + ((this.startDate == null) ? 0 : this.startDate.hashCode());
        result = prime * result
                + ((this.user == null) ? 0 : this.user.hashCode());
        return result;
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

    public Teacher update(Teacher newTeacher) {
        if (newTeacher.id != null && !newTeacher.id.equals(this.id)) {
            this.id = newTeacher.id;
        }
        if (newTeacher.endDate != null
                && !newTeacher.endDate.equals(this.endDate)) {
            this.endDate = newTeacher.endDate;
        }
        // TODO: to nie tak powinno dzia³aæ
        if (newTeacher.courses != null
                && !newTeacher.courses.equals(this.courses)) {
            this.courses = newTeacher.courses;
        }
        if (newTeacher.salary != null && !newTeacher.salary.equals(this.salary)) {
            this.salary = newTeacher.salary;
        }
        if (newTeacher.startDate != null
                && !newTeacher.startDate.equals(this.startDate)) {
            this.startDate = newTeacher.startDate;
        }
        // TODO: to nie tak powinno dzia³aæ
        if (newTeacher.user != null && !newTeacher.user.equals(this.user)) {
            this.user = newTeacher.user;
        }
        return this;
    }

    public Teacher updateEssentials(Teacher newTeacher) {
        if (newTeacher.id != null && !newTeacher.id.equals(this.id)) {
            this.id = newTeacher.id;
        }
        if (newTeacher.endDate != null
                && !newTeacher.endDate.equals(this.endDate)) {
            this.endDate = newTeacher.endDate;
        }
        if (newTeacher.salary != null && !newTeacher.salary.equals(this.salary)) {
            this.salary = newTeacher.salary;
        }
        if (newTeacher.startDate != null
                && !newTeacher.startDate.equals(this.startDate)) {
            this.startDate = newTeacher.startDate;
        }
        return this;
    }

}
