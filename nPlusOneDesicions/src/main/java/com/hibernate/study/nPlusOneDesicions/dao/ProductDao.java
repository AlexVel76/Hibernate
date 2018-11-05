package com.hibernate.study.nPlusOneDesicions.dao;

import com.hibernate.study.nPlusOneDesicions.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
}
