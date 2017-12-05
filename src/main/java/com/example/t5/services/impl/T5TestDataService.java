package com.example.t5.services.impl;

import org.apache.tapestry5.ioc.annotations.Inject;

import com.example.mongo.model.TestData;
import com.example.mongo.repo.TestDataRepository;
import com.example.t5.services.IT5TestDataService;

public class T5TestDataService implements IT5TestDataService {

	@Inject
	private TestDataRepository testDataRepository;

	@Override
	public TestData getTestDataByUuid(final String uuid) {
		return testDataRepository.findByUuid(uuid);
	}

	@Override
	public void saveTestDataByUuid(final TestData testData) {
		testDataRepository.save(testData);
	}
}
