package com.maciej.imiela.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

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

    // @Pattern(regexp = "(true)|(false)", message =
    // "field can only be true or false")
    @NotNull
    @Column(nullable = false)
    private Boolean passed;

    // @Pattern(regexp = "[1-5]", message =
    // "value of the field must be between numbers 1 and 5")
    @DecimalMax(value = "5")
    @DecimalMin(value = "1")
    @Column(nullable = true)
    private Integer score;

    @Column(nullable = true)
    private String note;

    public Participant() {
        // TODO Auto-generated constructor stub
    }

    public Participant(Integer id) {
        super();
        this.id = id;
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
        Participant other = (Participant) obj;
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
            return false;
        }
        if (this.note == null) {
            if (other.note != null) {
                return false;
            }
        } else if (!this.note.equals(other.note)) {
            return false;
        }
        if (this.passed == null) {
            if (other.passed != null) {
                return false;
            }
        } else if (!this.passed.equals(other.passed)) {
            return false;
        }
        if (this.score == null) {
            if (other.score != null) {
                return false;
            }
        } else if (!this.score.equals(other.score)) {
            return false;
        }
        return true;
    }

    public Course getCourse() {
        return this.course;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNote() {
        return this.note;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((this.course == null) ? 0 : this.course.hashCode());
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result
                + ((this.note == null) ? 0 : this.note.hashCode());
        result = prime * result
                + ((this.passed == null) ? 0 : this.passed.hashCode());
        result = prime * result
                + ((this.score == null) ? 0 : this.score.hashCode());
        result = prime * result
                + ((this.user == null) ? 0 : this.user.hashCode());
        return result;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNote(String note) {
        this.note = note;
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

    public Participant update(Participant newParticipant) {
        if (newParticipant.passed != null
                && !newParticipant.passed.equals(this.passed)) {
            this.passed = newParticipant.passed;
        }
        if (newParticipant.course != null
                && newParticipant.course.equals(this.course)) {
            // TODO: to nie bêdzie tak tzeba zmineiæ zaraz
            this.course = newParticipant.course;
        }
        if (newParticipant.id != null && !newParticipant.id.equals(this.id)) {
            this.id = newParticipant.id;
        }
        if (newParticipant.note != null
                && !newParticipant.note.equals(this.note)) {
            this.note = newParticipant.note;
        }
        if (newParticipant.score != null
                && !newParticipant.score.equals(this.score)) {
            this.score = newParticipant.score;
        }
        // if (newParticipant.user != null) {
        // if (this.user == null) {
        // this.user = newParticipant.user;
        // } else if (!newParticipant.user.equals(this.user)) {
        // // TODO: to nie bêdzie tak tzeba zmineiæ zaraz
        // this.user = newParticipant.user;
        // }
        // }
        if (newParticipant.user != null
                && !newParticipant.user.equals(this.user)) {
            this.user = newParticipant.user;
        }
        return this;
    }

    public Participant updateEssentials(Participant newParticipant) {
        if (newParticipant.passed != null
                && !newParticipant.passed.equals(this.passed)) {
            this.passed = newParticipant.passed;
        }
        if (newParticipant.id != null && !newParticipant.id.equals(this.id)) {
            this.id = newParticipant.id;
        }
        if (newParticipant.note != null
                && !newParticipant.note.equals(this.note)) {
            this.note = newParticipant.note;
        }
        if (newParticipant.score != null
                && !newParticipant.score.equals(this.score)) {
            this.score = newParticipant.score;
        }
        return this;
    }
}
