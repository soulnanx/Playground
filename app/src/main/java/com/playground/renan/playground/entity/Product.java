package com.playground.renan.playground.entity;

import com.playground.renan.playground.singleton.SingletonAdapter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by renan on 2/9/15.
 */
public class Product {
    private long id;
    private String name;
    private String description;
    private double value;

    public static List<Product> getAll() {
        return SingletonAdapter.getInstance().getAdapter().findAll(Product.class);

    }

    public BigDecimal getValue() {
        return new BigDecimal(value , MathContext.DECIMAL64);
    }

    public void setValue(BigDecimal value) {
        this.value = value.doubleValue();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}



