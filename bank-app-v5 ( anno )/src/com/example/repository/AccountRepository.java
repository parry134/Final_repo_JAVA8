package com.example.repository;

import com.example.model.Account;

public interface AccountRepository {
	
	public Account loadAccount(String num);
	public void updateAccount(Account account);

}
