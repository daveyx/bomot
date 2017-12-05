package com.example.mongo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo.model.UserAccount;

public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

	public UserAccount findByFirstName(String firstName);

	public List<UserAccount> findByLastName(String lastName);

}
