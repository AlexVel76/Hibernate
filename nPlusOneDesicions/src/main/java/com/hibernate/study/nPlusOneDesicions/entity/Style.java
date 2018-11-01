package com.hibernate.study.nPlusOneDesicions.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Style extends AbstractEntity {

    private String name;

    @OneToMany
    private List<Product> products;

    public Style() {
    }

    public Style(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Style setName(String name) {
        this.name = name;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Style setProducts(List<Product> products) {
        this.products = products;
        return this;
    }
}
