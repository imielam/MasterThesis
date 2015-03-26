package com.maciej.imiela.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    // @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy",
    // strategy = "hilo")
    // @GeneratedValue(generator = "hilo-strategy")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Size(min = 3, message = "Must have at least 3 characters!")
    @NotNull
    @Column(nullable = false)
    private String name;

    @Valid
    @OneToOne
    @JoinColumn(name = "address_per", nullable = false)
    private Address permamentAddress;

    @Valid
    @OneToOne(optional = true)
    @JoinColumn(name = "address_res", nullable = true)
    private Address residenceAddress;

    @OneToMany(mappedBy = "user")
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "user")
    private List<Participant> participants;

    @Valid
    @OneToOne
    @JoinColumn(name = "login_id", nullable = false)
    private Login login;

    public User() {
        this.teachers = new LinkedList<Teacher>();
        this.participants = new LinkedList<Participant>();
    }

    public User(Integer id) {
        this();
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
        User other = (User) obj;
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return this.id;
    }

    public Login getLogin() {
        return this.login;
    }

    public String getName() {
        return this.name;
    }

    public List<Participant> getParticipants() {
        return this.participants;
    }

    public Address getPermamentAddress() {
        return this.permamentAddress;
    }

    public Address getResidenceAddress() {
        return this.residenceAddress;
    }

    public List<Teacher> getTeachers() {
        return this.teachers;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public void setPermamentAddress(Address permamentAddress) {
        this.permamentAddress = permamentAddress;
    }

    public void setResidenceAddress(Address residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "User [id=" + this.id + ", name=" + this.name
                + ", permamentAddress=" + this.permamentAddress
                + ", residenceAddress=" + this.residenceAddress + ", teachers="
                + this.teachers + ", participants=" + this.participants + "]";
    }

    public User update(User newUser) {
        if (newUser.id != null && !newUser.id.equals(this.id)) {
            this.id = newUser.id;
        }
        // TODO: to nie tak powinno dzia³aæ
        if (newUser.login != null && !newUser.login.equals(this.login)) {
            this.login = newUser.login;
        }
        if (newUser.name != null && !newUser.name.equals(this.name)) {
            this.name = newUser.name;
        }
        // TODO: to nie tak powinno dzia³aæ
        if (newUser.participants != null
                && !newUser.participants.equals(this.participants)) {
            this.participants = newUser.participants;
        }
        // TODO: to nie tak powinno dzia³aæ
        if (newUser.permamentAddress != null
                && !newUser.permamentAddress.equals(this.permamentAddress)) {
            this.permamentAddress = newUser.permamentAddress;
        }
        // TODO: to nie tak powinno dzia³aæ
        if (newUser.residenceAddress != null
                && !newUser.residenceAddress.equals(this.residenceAddress)) {
            this.residenceAddress = newUser.residenceAddress;
        }
        // TODO: to nie tak powinno dzia³aæ
        if (newUser.teachers != null && !newUser.teachers.equals(this.teachers)) {
            this.teachers = newUser.teachers;
        }

        return this;
    }

    public User updateEssentials(User newUser) {
        if (newUser.id != null && !newUser.id.equals(this.id)) {
            this.id = newUser.id;
        }

        if (newUser.name != null && !newUser.name.equals(this.name)) {
            this.name = newUser.name;
        }

        return this;
    }

}
