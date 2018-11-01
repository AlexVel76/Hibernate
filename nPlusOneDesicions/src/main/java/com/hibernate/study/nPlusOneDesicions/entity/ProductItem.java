package com.hibernate.study.nPlusOneDesicions.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductItem extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    private Double cost;

    public ProductItem(Product product, Double cost) {
        this.product = product;
        this.cost = cost;
    }

    public Product getProduct() {
        return product;
    }

    public ProductItem setProduct(Product product) {
        this.product = product;
        return this;
    }

    public Double getCost() {
        return cost;
    }

    public ProductItem setCost(Double cost) {
        this.cost = cost;
        return this;
    }
}
