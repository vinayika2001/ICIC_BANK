package com.bank.service.impl;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.BankEntity;
import com.bank.repository.BankRepository;
import com.bank.service.BankService;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public BankEntity addAccount(BankEntity bank) {
        return bankRepository.save(bank);
    }

    @Override
    public BankEntity getAccount(Long accountNumber) {
        return bankRepository.findById(accountNumber).orElse(null);
    }

    public List getAllAccounts1() {
        return (List) bankRepository.findAll();
    }

    @Override
    public void deleteAccount(Long accountNumber) {
        bankRepository.deleteById(accountNumber);
    }

	@Override
	public List getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankEntity getAccount(long accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(long accountNumber) {
		// TODO Auto-generated method stub
		
	}
}