package com.hibernate.study.nPlusOneDesicions;

import com.hibernate.study.nPlusOneDesicions.service.GetterDataService;
import com.hibernate.study.nPlusOneDesicions.service.TestDataCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan
public class NPlusOneDesicionsApplication {

	@Autowired
	private TestDataCreatorService testDataCreatorService;

	@Autowired
	private GetterDataService getterDataService;

	public static void main(String[] args) {
		SpringApplication.run(NPlusOneDesicionsApplication.class, args);
	}

	@PostConstruct
	public void manageData()
	{
		testDataCreatorService.createTestData();
		getterDataService.loadTestData();
	}
}
