package com.example.services.dto;

import java.io.Serializable;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 07/11/15.
 */
public class KeyValidationRequest implements Serializable {
    private String email;
    private String key;

    @Override
    public String toString() {
        return "KeyValidationRequest{" +
                "email='" + email + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

    public KeyValidationRequest(String email, String key) {
        this.email = email;
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeyValidationRequest that = (KeyValidationRequest) o;

        if (!getEmail().equals(that.getEmail())) return false;
        return getKey().equals(that.getKey());

    }

    @Override
    public int hashCode() {
        int result = getEmail().hashCode();
        result = 31 * result + getKey().hashCode();
        return result;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
