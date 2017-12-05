package com.example.persistence.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.persistence.model.PUserAccount;

public interface PUserAccountRepository extends CrudRepository<PUserAccount, Long> {

	public PUserAccount findByFirstName(String firstName);

	public List<PUserAccount> findByLastName(String lastName);

}
