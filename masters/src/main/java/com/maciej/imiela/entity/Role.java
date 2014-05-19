package com.maciej.imiela.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<Login> users;

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
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        if (this.users == null) {
            if (other.users != null) {
                return false;
            }
        } else if (!this.users.equals(other.users)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Login> getUsers() {
        return this.users;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result
                + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result
                + ((this.users == null) ? 0 : this.users.hashCode());
        return result;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(List<Login> users) {
        this.users = users;
    }

    public Role update(Role newRole) {
        if (newRole.id != null && !newRole.id.equals(this.id)) {
            this.id = newRole.id;
        }
        if (newRole.name != null && !newRole.name.equals(this.name)) {
            this.name = newRole.name;
        }
        // TODO: to nie tak powinno dzia�a�
        if (newRole.users != null && !newRole.users.equals(this.users)) {
            this.users = newRole.users;
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
