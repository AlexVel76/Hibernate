package com.hibernate.study.nPlusOneDesicions.dao;

import com.hibernate.study.nPlusOneDesicions.entity.Product;
import com.hibernate.study.nPlusOneDesicions.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {

    @Query("select p from Product p ")
    List<Product> findByStyleName(String styleName);

}
