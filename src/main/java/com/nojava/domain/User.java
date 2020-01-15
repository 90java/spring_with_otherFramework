package com.nojava.domain;

public class User {
    private Role role;

    public User() {
    }

    public User(Role role) {
        this.role = role;
    }

    public void sayUser(){
        System.out.println("this is user model");
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
