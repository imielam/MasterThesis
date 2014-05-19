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
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Course {

    @Id
    @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "type_id", nullable = false)
    private CourseType type;

    @Column(name = "start_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @OneToMany(mappedBy = "course")
    private List<Participant> participants;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

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
        Course other = (Course) obj;
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
        if (this.participants == null) {
            if (other.participants != null) {
                return false;
            }
        } else if (!this.participants.equals(other.participants)) {
            return false;
        }
        if (this.startDate == null) {
            if (other.startDate != null) {
                return false;
            }
        } else if (!this.startDate.equals(other.startDate)) {
            return false;
        }
        if (this.teacher == null) {
            if (other.teacher != null) {
                return false;
            }
        } else if (!this.teacher.equals(other.teacher)) {
            return false;
        }
        if (this.type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!this.type.equals(other.type)) {
            return false;
        }
        return true;
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((this.endDate == null) ? 0 : this.endDate.hashCode());
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime
                * result
                + ((this.participants == null) ? 0 : this.participants
                        .hashCode());
        result = prime * result
                + ((this.startDate == null) ? 0 : this.startDate.hashCode());
        result = prime * result
                + ((this.teacher == null) ? 0 : this.teacher.hashCode());
        result = prime * result
                + ((this.type == null) ? 0 : this.type.hashCode());
        return result;
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

    @Override
    public String toString() {
        return "Course [id=" + this.id + ", type=" + this.type + ", startDate="
                + this.startDate + ", endDate=" + this.endDate + "]";
    }

    public Course update(Course newCourse) {
        if (newCourse.id != null && !newCourse.id.equals(this.id)) {
            this.id = newCourse.id;
        }
        if (newCourse.endDate != null
                && !newCourse.endDate.equals(this.endDate)) {
            this.endDate = newCourse.endDate;
        }
        // TODO: to trzeba rozwi�za� inaczej
        if (newCourse.participants != null
                && !newCourse.endDate.equals(this.participants)) {
            this.participants = newCourse.participants;
        }
        if (newCourse.startDate != null
                && !newCourse.startDate.equals(this.startDate)) {
            this.startDate = newCourse.startDate;
        }
        // TODO: to trzeba rozwi�za� inaczej
        if (newCourse.teacher != null
                && !newCourse.teacher.equals(this.teacher)) {
            this.teacher = newCourse.teacher;
        }
        // TODO: to trzeba rozwi�za� inaczej
        if (newCourse.type != null && !newCourse.type.equals(this.type)) {
            this.type = newCourse.type;
        }

        return this;
    }

    public Course updateEssentials(Course newCourse) {
        if (newCourse.id != null && !newCourse.id.equals(this.id)) {
            this.id = newCourse.id;
        }
        if (newCourse.endDate != null
                && !newCourse.endDate.equals(this.endDate)) {
            this.endDate = newCourse.endDate;
        }
        if (newCourse.startDate != null
                && !newCourse.startDate.equals(this.startDate)) {
            this.startDate = newCourse.startDate;
        }

        return this;
    }
}
