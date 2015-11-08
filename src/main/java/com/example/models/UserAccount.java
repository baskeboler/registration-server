package com.example.models;

import org.springframework.core.style.ToStringCreator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 06/11/15.
 */
@Entity
public class UserAccount implements Serializable {
    @Id
    private String id;

    @Column(unique = true)
    private String email;
    @Column
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", id)
                .append("email", email)
                .append("name", name)
                .toString();
    }
}
