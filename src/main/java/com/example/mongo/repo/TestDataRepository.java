package com.example.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo.model.TestData;

public interface TestDataRepository extends MongoRepository<TestData, String> {

	public TestData findByUuid(final String uuid);

}
