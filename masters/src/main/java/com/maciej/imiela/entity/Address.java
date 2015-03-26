package com.maciej.imiela.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Address {

    @Id
    // @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy",
    // strategy = "hilo")
    // @GeneratedValue(generator = "hilo-strategy")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String street;

    @Pattern(regexp = "\\d+\\w?", message = "Field can have at least one number and one or zero character (at the end only)")
    @Column(name = "street_hn", nullable = false)
    private String streetHN;

    @Pattern(regexp = "\\d+\\w?", message = "Field can have at least one number and one or zero character (at the end only)")
    @Column(name = "street_an", nullable = true)
    private String streetAN;

    @Size(min = 3, message = "Must have at least 3 characters!")
    @Column(nullable = false)
    private String city;

    @Pattern(regexp = "\\d\\d-\\d\\d\\d", message = "Field must support pattern: XX-XXX")
    @NotNull
    @Column(name = "postal_code", nullable = false)
    private String postalCode;

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
        Address other = (Address) obj;
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    public Address update(Address newAddress) {
        if (newAddress.id != null && !newAddress.id.equals(this.id)) {
            this.id = newAddress.id;
        }
        if (newAddress.city != null && !newAddress.city.equals(this.city)) {
            this.city = newAddress.city;
        }
        if (newAddress.postalCode != null
                && !newAddress.postalCode.equals(this.postalCode)) {
            this.postalCode = newAddress.postalCode;
        }
        if (newAddress.street != null && !newAddress.street.equals(this.street)) {
            this.street = newAddress.street;
        }
        if (newAddress.streetAN != null
                && !newAddress.streetAN.equals(this.streetAN)) {
            this.streetAN = newAddress.streetAN;
        }
        if (newAddress.streetHN != null
                && !newAddress.streetHN.equals(this.streetHN)) {
            this.streetHN = newAddress.streetHN;
        }
        return this;
    }

}
