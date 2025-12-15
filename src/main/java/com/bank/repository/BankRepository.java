package com.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.BankEntity;

public interface BankRepository extends JpaRepository<BankEntity, Long> {

    Optional<BankEntity> findByAccountNumber(Long accountNumber);

    void deleteByAccountNumber(Long accountNumber);

	boolean existsByAccountNumber(Long accountNumber);
}
