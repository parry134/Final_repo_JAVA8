package com.example.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.model.Account;

@Repository
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository {

	@PersistenceContext
	private EntityManager em;

	public Account loadAccount(String num) {
		// ..
		return em.find(Account.class, num);
	}

	public void updateAccount(Account account) {
		// ..
		em.merge(account);
	}

}
