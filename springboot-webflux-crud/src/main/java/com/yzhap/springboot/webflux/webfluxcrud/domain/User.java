package com.yzhap.springboot.webflux.webfluxcrud.domain;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -1L;

    private String id;

    private String name;

    private String email;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "User [" +
                "id=" + id +
                ", name=" + name +
                ", email=" + email +
                "]";
    }
}
