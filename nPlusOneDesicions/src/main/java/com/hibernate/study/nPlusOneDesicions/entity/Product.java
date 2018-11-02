package com.hibernate.study.nPlusOneDesicions.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Product extends AbstractEntity {

    private String name;
    @ManyToOne
    @JoinColumn(name = "style_id", referencedColumnName = "id")
    private Style style;

    @OneToMany(mappedBy = "product")
    private List<ProductItem> productItems;

    public Product(String name, Style style) {
        this.name = name;
        this.style = style;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Style getStyle() {
        return style;
    }

    public Product setStyle(Style style) {
        this.style = style;
        return this;
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public Product setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
        return this;
    }
}
