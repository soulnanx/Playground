package com.playground.renan.playground.entity;

import com.playground.renan.playground.singleton.SingletonAdapter;

/**
 * Created by renan on 2/13/15.
 */
public class Person {
    private long id;
    private String name;
    private String email;

    public void save(){
        SingletonAdapter.getInstance().getAdapter().store(this);
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
