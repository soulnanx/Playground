package com.playground.renan.playground.entity;

import com.playground.renan.playground.singleton.SingletonAdapter;

import java.util.List;

/**
 * Created by renan on 2/13/15.
 */
public class Person {
    private long id;
    private String name;
    private String email;

    public Person(long id) {
        this.id = id;
    }

    public Person() {
    }

    public void save(){
        SingletonAdapter.getInstance().getAdapter().store(this);
    }

    public void remove(){
        SingletonAdapter.getInstance().getAdapter().delete(this);
    }

    public static List<Person> findAll(){
        return SingletonAdapter.getInstance().getAdapter().findAll(Person.class);
    }

    public static List<Person> findAll(Person person){
        return SingletonAdapter.getInstance().getAdapter().findAll(person);
    }

    public static Person find(long id){
        return SingletonAdapter.getInstance().getAdapter().findFirst(new Person(id));
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
