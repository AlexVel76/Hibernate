package com.hibernate.study.nPlusOneDesicions.service;

import com.hibernate.study.nPlusOneDesicions.dao.ProductDao;
import com.hibernate.study.nPlusOneDesicions.dao.ProductItemDao;
import com.hibernate.study.nPlusOneDesicions.dao.StyleDao;
import com.hibernate.study.nPlusOneDesicions.entity.Product;
import com.hibernate.study.nPlusOneDesicions.entity.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
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
    @Autowired
    private GetterDataService self;

    @Override
    @Transactional
    public void loadTestData() {
        List<Product> products;
        System.out.println("--------------1--------------");
//        Style style = styleDao.findById(2l).get();
//        products = style.getProducts();
//        products.stream().forEach(p -> System.out.println(p.getName()));

        System.out.println("--------------2--------------");
        products = productDao.findAll();
        products.stream().forEach(p -> {
            System.out.println(p.getName() + " : " + p.getStyle().getName());
        });

        System.out.println("--------------3--------------(in same transaction)");
        products = productDao.findAll();
        products.stream().forEach(p -> {
            System.out.println(p.getName() + " : " + p.getStyle().getName());
        });

        //------------4------------
        self.callInNewTransaction();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void callInNewTransaction()
    {
        List<Product> products;

        System.out.println("--------------4--------------in NEW transaction");
        products = productDao.findAll();
        products.stream().forEach(p -> {
            System.out.println(p.getName() + " : " + p.getStyle().getName());
        });
    }

    @Override
    public void loadTestDataWithoutTransactions() {
        List<Product> products;

        System.out.println("--------------5--------------(without wrapped transaction AND use JOIN FETCH)");
        products = productDao.findWithFetchQuery();
        products.stream().forEach(p -> {
            System.out.println(p.getName() + " : " + p.getStyle().getName());
        });

        System.out.println("--------------6--------------without wrapped transaction AND use Dynamic Entity Graph");
        products = productDao.findWithEntityGraph();
        products.stream().forEach(p -> {
            System.out.println(p.getName() + " : " + p.getStyle().getName());
        });
    }


}
