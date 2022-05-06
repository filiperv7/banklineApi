package com.banking.bankline.api.dto.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.bankline.api.dto.NewAccountHolder;
import com.banking.bankline.api.model.Account;
import com.banking.bankline.api.model.AccountHolder;
import com.banking.bankline.api.repository.AccountHolderRepository;

@Service
public class AccountHolderService {
	
	@Autowired
	private AccountHolderRepository repository;
	public void save(NewAccountHolder newAccountHolder) {
		AccountHolder accountHolder = new AccountHolder();	
		accountHolder.setCpf(newAccountHolder.getCpf());
		accountHolder.setName(newAccountHolder.getName());
		
		Account account = new Account();
		account.setBalance(0.0);
		account.setNumber(new Date().getTime());
		
		accountHolder.setAccount(account);		
		repository.save(accountHolder);
		
	}
}
