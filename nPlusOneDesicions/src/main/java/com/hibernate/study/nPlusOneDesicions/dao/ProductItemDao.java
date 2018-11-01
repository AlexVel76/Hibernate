package com.hibernate.study.nPlusOneDesicions.dao;

import com.hibernate.study.nPlusOneDesicions.entity.ProductItem;
import org.springframework.data.repository.CrudRepository;

public interface ProductItemDao extends CrudRepository<ProductItem, Long> {
}
