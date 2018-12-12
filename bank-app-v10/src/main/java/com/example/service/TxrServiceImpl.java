package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Account;
import com.example.repository.AccountRepository;

@Service("txrService")
public class TxrServiceImpl implements TxrService {

	@Autowired
	@Qualifier("jpa")
	private AccountRepository accountRepository;

	@Transactional
	@Override
	public boolean txr(double amount, String fromAccNum, String toAccNum) {
		// load account(s)
		Account fromAccount = accountRepository.loadAccount(fromAccNum);
		Account toAccount = accountRepository.loadAccount(toAccNum);
		// debit & credit
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);
		// update account(s)
		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);
		return true;
	}

}
