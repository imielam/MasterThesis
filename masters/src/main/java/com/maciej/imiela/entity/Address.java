package com.maciej.imiela.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private Integer id;

    @Column(nullable = false)
    private String street;

    @Column(name = "street_hn", nullable = false)
    private String streetHN;

    @Column(name = "street_an", nullable = true)
    private String streetAN;

    @Column(nullable = false)
    private String city;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    // @OneToMany(mappedBy = "permamentAddress")
    // private List<User> userPermAddress;
    //
    // @OneToMany(mappedBy = "residenceAddress")
    // private List<User> userResAddress;

    public String getCity() {
        return this.city;
    }

    public Integer getId() {
        return this.id;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getStreet() {
        return this.street;
    }

    public String getStreetAN() {
        return this.streetAN;
    }

    public String getStreetHN() {
        return this.streetHN;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // public List<User> getUserPermAddress() {
    // return this.userPermAddress;
    // }
    //
    // public List<User> getUserResAddress() {
    // return this.userResAddress;
    // }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetAN(String streetAN) {
        this.streetAN = streetAN;
    }

    public void setStreetHN(String streetHN) {
        this.streetHN = streetHN;
    }

    @Override
    public String toString() {
        return "Address [id=" + this.id + ", street=" + this.street
                + ", streetHN=" + this.streetHN + ", streetAN=" + this.streetAN
                + ", city=" + this.city + ", postalCode=" + this.postalCode
                + "]";
    }

    // public void setUserPermAddress(List<User> userPermAddress) {
    // this.userPermAddress = userPermAddress;
    // }
    //
    // public void setUserResAddress(List<User> userResAddress) {
    // this.userResAddress = userResAddress;
    // }

}
