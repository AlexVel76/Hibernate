package com.hibernate.study.nPlusOneDesicions.service;

import com.hibernate.study.nPlusOneDesicions.dao.ProductDao;
import com.hibernate.study.nPlusOneDesicions.dao.ProductItemDao;
import com.hibernate.study.nPlusOneDesicions.dao.StyleDao;
import com.hibernate.study.nPlusOneDesicions.entity.Product;
import com.hibernate.study.nPlusOneDesicions.entity.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GetterDataServiceImpl implements GetterDataService {

    @Autowired
    private StyleDao styleDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductItemDao productItemDao;

    @Override
    @Transactional
    public void loadTestData() {
        Style style = styleDao.findById(2l).get();
        List<Product> products = style.getProducts();
        products.stream().forEach(p -> System.out.println(p.getName()));
    }
}
