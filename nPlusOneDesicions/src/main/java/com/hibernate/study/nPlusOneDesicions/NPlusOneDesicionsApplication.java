package com.hibernate.study.nPlusOneDesicions;

import com.hibernate.study.nPlusOneDesicions.service.GetterDataService;
import com.hibernate.study.nPlusOneDesicions.service.TestDataCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class NPlusOneDesicionsApplication {

    @Autowired
    private TestDataCreatorService testDataCreatorService;

    @Autowired
    private GetterDataService getterDataService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NPlusOneDesicionsApplication.class, args);

        NPlusOneDesicionsApplication application = context.getBean(NPlusOneDesicionsApplication.class);
        application.testDataCreatorService.createTestData();
        application.getterDataService.loadTestData();
        application.getterDataService.loadTestDataWithoutTransactions();
    }
}
