package com.banking.bankline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.bankline.api.dto.NewAccountHolder;
import com.banking.bankline.api.dto.service.AccountHolderService;
import com.banking.bankline.api.model.AccountHolder;
import com.banking.bankline.api.repository.AccountHolderRepository;

@RestController
@RequestMapping("/accountHolder")
public class AccountHolderController {
	@Autowired
	private AccountHolderRepository repository;
	
	@Autowired
	private AccountHolderService service;
	
	@GetMapping
	public List<AccountHolder> findAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody NewAccountHolder accountHolder) {
		service.save(accountHolder);
	}
}
