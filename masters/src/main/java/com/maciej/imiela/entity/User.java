package com.maciej.imiela.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {

    @Id
    @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "address_per", nullable = false)
    private Address permamentAddress;

    @OneToOne(optional = true)
    @JoinColumn(name = "address_res", nullable = true)
    private Address residenceAddress;

    @OneToMany(mappedBy = "user")
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "user")
    private List<Participant> participants;

    // @OneToOne(mappedBy = "user")
    // private Login login;

    public Integer getId() {
        return this.id;
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

    public void setId(Integer id) {
        this.id = id;
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

}
