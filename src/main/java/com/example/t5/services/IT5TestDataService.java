package com.example.t5.services;

import com.example.mongo.model.TestData;

public interface IT5TestDataService {

	TestData getTestDataByUuid(final String uuid);

	void saveTestDataByUuid(final TestData testData);

}
