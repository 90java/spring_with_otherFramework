package com.nojava.domain;

public class Role {
    private User user;

    public Role() {
    }

    public Role(User user) {
        this.user = user;
    }

    public void sayRole() {
        System.out.println("this is Role model");
    }

    public void setUser(User user) {
        this.user = user;
    }
}
