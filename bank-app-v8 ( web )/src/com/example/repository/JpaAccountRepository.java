package com.example.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.model.Account;

@Repository
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository {

	private static Logger logger = Logger.getLogger("bank");

	@PersistenceContext
	private EntityManager em;

	public JpaAccountRepository() {
		logger.info("JpaAccountRepository instance created");
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
