package com.bank.service;

import org.hibernate.mapping.List;

import com.bank.model.BankEntity;

public interface BankService {

    BankEntity addAccount(BankEntity bank);

    BankEntity getAccount(Long accountNumber);

    List getAllAccounts();

    void deleteAccount(Long accountNumber);

	BankEntity getAccount(long accountNumber);

	void deleteAccount(long accountNumber);
}