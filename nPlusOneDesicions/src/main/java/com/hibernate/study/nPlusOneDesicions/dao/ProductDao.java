package com.hibernate.study.nPlusOneDesicions.dao;

import com.hibernate.study.nPlusOneDesicions.entity.Product;
import com.hibernate.study.nPlusOneDesicions.entity.Style;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {

    @Query("SELECT DISTINCT p FROM Product p JOIN FETCH p.style b")
    List<Product> findWithFetchQuery();

    @EntityGraph(attributePaths = "style")
    @Query("SELECT DISTINCT p FROM Product p")
    List<Product> findWithEntityGraph();
}
