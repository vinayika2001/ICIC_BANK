package com.bank.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.BankEntity;
import com.bank.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/add")
    public BankEntity addAccount(@RequestBody BankEntity bank) {
        return bankService.addAccount(bank);
    }

    @GetMapping("/get/{accountNumber}")
    public BankEntity getAccount(@PathVariable Long accountNumber) {
        return bankService.getAccount(accountNumber);
    }

    @GetMapping("/get-all")
    public List getAllAccounts() {
        return bankService.getAllAccounts();
    }

    @DeleteMapping("/delete/{accountNumber}")
    public String deleteAccount(@PathVariable Long accountNumber) {
        bankService.deleteAccount(accountNumber);
        return "Account deleted successfully!";
    }
}    	