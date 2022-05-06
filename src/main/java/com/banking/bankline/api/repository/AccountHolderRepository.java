package com.banking.bankline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.bankline.api.model.AccountHolder;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer> {

}
