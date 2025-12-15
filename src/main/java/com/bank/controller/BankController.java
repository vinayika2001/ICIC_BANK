package com.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bank.dto.BankDTO;
import com.bank.model.BankEntity;
import com.bank.service.BankService;

/**
 * REST Controller for handling Bank related operations.
 * 
 * This controller exposes APIs to create, retrieve, update,
 * and delete bank account details.
 * 
 * Base URL: /bank
 *
 * @author Vinayika
 */
@RestController
@RequestMapping("/bank")
public class BankController {

    private static final Logger logger = LoggerFactory.getLogger(BankController.class);

    @Autowired
    private BankService bankService;

    /**
     * Creates a new bank account.
     *
     * @param bank the bank account details received in request body
     * @return success message after account creation
     */
    @PostMapping("/add")
    public String addAccount(@RequestBody BankDTO bank) {
        return bankService.addAccount(bank);
    }

    /**
     * Fetches a bank account by account number.
     *
     * @param accountNumber the unique account number
     * @return BankEntity containing account details
     */
    @GetMapping("/get/{accountNumber}")
    public BankEntity getAccount(@PathVariable("accountNumber") Long accountNumber) {
        logger.info("Fetching account with accountNumber: {}", accountNumber);
        return bankService.getAccount(accountNumber);
    }

    /**
     * Fetches all bank accounts.
     *
     * @return list of all BankEntity records
     */
    @GetMapping("/get-all")
    public List<BankEntity> getAllAccounts() {
        logger.info("Fetching all bank accounts");
        return (List<BankEntity>) bankService.getAllAccounts();
    }

    /**
     * Deletes a bank account using account number.
     *
     * @param accountNumber the account number to delete
     * @return success message after deletion
     */
    @DeleteMapping("/delete/{accountNumber}")
    public String deleteAccount(@PathVariable("accountNumber") Long accountNumber) {
        logger.info("Deleting account with accountNumber: {}", accountNumber);
        bankService.deleteAccount(accountNumber);
        return "Account deleted successfully!";
    }

    /**
     * Updates branch name for a given account number.
     *
     * @param accountNumber the account number to update
     * @param branchName the new branch name
     * @return success message after update
     */
    @PutMapping("/update/{accountNumber}/{branchName}")
    public String updateBranchName(
            @PathVariable("accountNumber") Long accountNumber,
            @PathVariable("branchName") String branchName) {

        logger.info("Update account with accountNumber: {}", accountNumber);
        bankService.updateAccount(accountNumber, branchName);
        return "Branch name updated successfully";
    }
}
