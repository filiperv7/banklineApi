package com.banking.bankline.api.dto.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.bankline.api.dto.NewMovement;
import com.banking.bankline.api.model.AccountHolder;
import com.banking.bankline.api.model.Movement;
import com.banking.bankline.api.model.MovementType;
import com.banking.bankline.api.repository.AccountHolderRepository;
import com.banking.bankline.api.repository.MovementRepository;

@Service
public class MovementService {

	@Autowired
	private MovementRepository repository;
	
	@Autowired
	private AccountHolderRepository accountHolderRepository;
	public void save(NewMovement newMovement) {
		Movement movement = new Movement();
		
		
		Double value = NewMovement.getValue();
		if(NewMovement.getType() == MovementType.DESPESA)
			value = value * -1;
			
		movement.setDateHour(LocalDateTime.now());
		movement.setDesc(null);; (NewMovement.getDescription());
		movement.setId(NewMovement.getIdAccount());
		movement.setType(NewMovement.getType());
		movement.setValue(value);
		
		AccountHolder accountHolder = accountHolderRepository.findById(newMovement.getIdAccount()).orElse(null);
		if(accountHolder != null) {
			accountHolder.getAccount().setBalance(accountHolder.getAccount().getBalance() + value);
			accountHolderRepository.save(accountHolder);
		}
		
		repository.save(movement);
		
	}
}
