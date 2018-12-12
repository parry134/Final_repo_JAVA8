package com.example.repository;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.example.model.Account;

public class JpaAccountRepository implements AccountRepository {

	private static Logger logger = Logger.getLogger("bank");
	
	
	private EntityManager em;

	public JpaAccountRepository(EntityManager em) {
		logger.info("JpaAccountRepository instance created");
		this.em=em;
	}

	public Account loadAccount(String num) {
		// ..
		logger.info("loading account " + num);
		return em.find(Account.class, num);
	}

	public void updateAccount(Account account) {
		logger.info("updating account");
		// ..
		em.merge(account);
	}

}
