package com.maciej.imiela.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.maciej.imiela.annotation.UniqueRoleName;

@Entity
public class Role {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy",
    // strategy = "hilo")
    // @GeneratedValue(generator = "hilo-strategy")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Pattern(regexp = "ROLE_[A-Z]+", message = "Field must correspondt to the pattern: ROLE_XXXX")
    @NotNull
    @UniqueRoleName(message = "Such Role already exists!")
    @Column(unique = true, nullable = false)
    private String name = "ROLE_USER";

    @OneToMany(mappedBy = "role")
    private List<Login> logins;

    public Role() {
        super();
        this.logins = new LinkedList<Login>();
        this.name = "ROLE_GUEST";
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
        Role other = (Role) obj;
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

    public List<Login> getLogins() {
        return this.logins;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogins(List<Login> users) {
        this.logins = users;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role update(Role newRole) {
        if (newRole.id != null && !newRole.id.equals(this.id)) {
            this.id = newRole.id;
        }
        if (newRole.name != null && !newRole.name.equals(this.name)) {
            this.name = newRole.name;
        }
        // TODO: to nie tak powinno dzia³aæ
        if (newRole.logins != null && !newRole.logins.equals(this.logins)) {
            this.logins = newRole.logins;
        }
        return this;
    }

    public Role updateEssentials(Role newRole) {
        if (newRole.id != null && !newRole.id.equals(this.id)) {
            this.id = newRole.id;
        }
        if (newRole.name != null && !newRole.name.equals(this.name)) {
            this.name = newRole.name;
        }
        return this;
    }
}
