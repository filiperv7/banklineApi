package com.banking.bankline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.bankline.api.dto.NewMovement;
import com.banking.bankline.api.dto.service.MovementService;
import com.banking.bankline.api.model.Movement;
import com.banking.bankline.api.repository.MovementRepository;

@RestController
@RequestMapping("/movimentacoes")
public class MovementController {

	@Autowired
	private MovementRepository repository;

	@Autowired
	private MovementService service;

	@GetMapping
	public List<Movement> findAll() {
		return repository.findAll();
	}

	@GetMapping("/{idAccount}")
	public List<Movement> findAll(@PathVariable("idAccount") Integer idConta) {
		return repository.findByIdConta(idConta);
	}

	@PostMapping
	public void save(@RequestBody NewMovement movement) {
		service.save(movement);
	}
}
