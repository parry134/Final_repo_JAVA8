package com.example.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Account;
import com.example.repository.AccountRepository;

@Service("txrService")
public class TxrServiceImpl implements TxrService {

	private static Logger logger = Logger.getLogger("bank");

	@Autowired
	@Qualifier("jpa")
	private AccountRepository accountRepository;

	public TxrServiceImpl() {
		logger.info("TxrServiceImpl instance created");
	}

	@Transactional
	@Override
	public boolean txr(double amount, String fromAccNum, String toAccNum) {
		logger.info("Txr-begin");
		// load account(s)
		Account fromAccount = accountRepository.loadAccount(fromAccNum);
		Account toAccount = accountRepository.loadAccount(toAccNum);
		// debit & credit
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);
		// update account(s)
		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);
		logger.info("Txr-success");
		return true;
	}

}
