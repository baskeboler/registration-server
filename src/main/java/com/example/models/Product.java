package com.example.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 06/11/15.
 */
@Entity
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
