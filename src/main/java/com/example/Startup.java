package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.mongo.model.TestData;
import com.example.mongo.repo.TestDataRepository;

@Component
public class Startup {
	@Autowired
	private TestDataRepository testDataRepository;
	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		final TestData testDataExisting = testDataRepository.findByUuid(TestData.TEST_UUID);
		if (testDataExisting != null) {
			testDataRepository.deleteAll();
		}
		final TestData testData = new TestData();
		testData.setUuid(TestData.TEST_UUID);
		testData.setValue("1");
		testDataRepository.save(testData);
	}
}
