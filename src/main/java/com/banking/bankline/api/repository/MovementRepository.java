package com.banking.bankline.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.bankline.api.model.Movement;

public interface MovementRepository extends JpaRepository<Movement, Integer> {

	public List<Movement> findByIdConta(Integer idConta);
}
