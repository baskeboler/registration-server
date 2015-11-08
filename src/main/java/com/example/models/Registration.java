package com.example.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 06/11/15.
 */
@Entity
public class Registration implements Serializable{

    @Id
    private String id;

    @Column(unique = true)
    private String key;

    @ManyToOne(optional = false)
    private UserAccount userAccount;

    @ManyToMany
    private List<Product> authorizations;

    @Column
    private long timestamp;

    public List<Product> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(List<Product> authorizations) {
        this.authorizations = authorizations;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
