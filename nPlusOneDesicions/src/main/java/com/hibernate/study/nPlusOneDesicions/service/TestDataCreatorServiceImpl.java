package com.hibernate.study.nPlusOneDesicions.service;

import com.google.common.collect.Lists;
import com.hibernate.study.nPlusOneDesicions.dao.ProductDao;
import com.hibernate.study.nPlusOneDesicions.dao.ProductItemDao;
import com.hibernate.study.nPlusOneDesicions.dao.StyleDao;
import com.hibernate.study.nPlusOneDesicions.entity.Product;
import com.hibernate.study.nPlusOneDesicions.entity.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Component
public class TestDataCreatorServiceImpl implements TestDataCreatorService {

    @Autowired
    private StyleDao styleDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductItemDao productItemDao;

    @Override
    @Transactional
    public void createTestData() {
        createProduct("prod1", 2l);
        createProduct("prod2", 2l);
        createProduct("prod3", 2l);
        createProduct("prod4", 2l);
        createProduct("prod1", 3l);
        createProduct("prod1", 4l);
        createProduct("prod1", 5l);

        Style style = new Style("tt1");
        styleDao.save(style);

        Product product1 = new Product("prod5", style);
        Product product2 = new Product("prod6", style);

        productDao.save(product1);
        productDao.save(product2);

    }

    private Product createProduct(String name, Long styleId) {
        Product product = new Product(name, styleDao.findById(styleId).get());
        productDao.save(product);

        return product;
    }
}
