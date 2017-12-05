package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.mongo.model.UserAccount;
import com.example.mongo.repo.UserAccountRepository;
import com.example.persistence.model.PUserAccount;
import com.example.persistence.repo.PUserAccountRepository;

@Component
public class Startup {
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Autowired
	private PUserAccountRepository pUserAccountRepository;
	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
	    System.out.println("hello world, I have just started up");
	    for (final UserAccount userAccount : userAccountRepository.findAll()) {
	    	System.out.println(userAccount);
	    }
	    System.out.println("--------------------------------");
	    for (final PUserAccount userAccount : pUserAccountRepository.findAll()) {
	    	System.out.println(userAccount);
	    }
	}
}
