package com.hibernate.study.nPlusOneDesicions.service;

public interface GetterDataService {
    void loadTestData();

    void callInNewTransaction();

    void loadTestDataWithoutTransactions();
}
