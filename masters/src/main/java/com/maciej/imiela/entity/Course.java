package com.maciej.imiela.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Course {

    @Id
    // @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy",
    // strategy = "hilo")
    // @GeneratedValue(generator = "hilo-strategy")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "type_id", nullable = false)
    private CourseType type;

    @NotNull
    @Column(name = "start_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @NotNull
    // @Future
    @Column(name = "end_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @OneToMany(mappedBy = "course")
    private List<Participant> participants;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    public Course() {
        this.participants = new LinkedList<Participant>();
    }

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
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
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

    public List<Integer> getParticipantsID() {
        List<Integer> ids = new LinkedList<Integer>();
        if (this.participants != null) {
            for (Participant p : this.participants) {
                ids.add(p.getId());
            }
        }
        return ids;
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
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
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
        // TODO: to trzeba rozwi¹zaæ inaczej
        if (newCourse.participants != null
                && !newCourse.endDate.equals(this.participants)) {
            this.participants = newCourse.participants;
        }
        if (newCourse.startDate != null
                && !newCourse.startDate.equals(this.startDate)) {
            this.startDate = newCourse.startDate;
        }
        // TODO: to trzeba rozwi¹zaæ inaczej
        if (newCourse.teacher != null
                && !newCourse.teacher.equals(this.teacher)) {
            this.teacher = newCourse.teacher;
        }
        // TODO: to trzeba rozwi¹zaæ inaczej
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

    @AssertTrue(message = "startDate must be set before endDate!")
    private boolean isValid() {
        return this.startDate.before(this.endDate);
    }
}
