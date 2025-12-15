package com.bank.service;

import java.util.List;

import com.bank.dto.BankDTO;
import com.bank.model.BankEntity;

/*
 * BankService
 *
 * This interface defines all business-level operations
 * related to Bank Accounts.
 *
 * It acts as a contract between the Controller layer
 * and the Service Implementation layer.
 *
 * Actual business logic will be implemented in the
 * corresponding implementation class (e.g. BankServiceImpl).
 */
public interface BankService {

    /*
     * Creates a new bank account.
     *
     * Input data is received in the form of BankDTO
     * from the Controller layer.
     *
     * @param bank BankDTO containing account details
     * @return String message indicating operation status
     */
    String addAccount(BankDTO bank);

    /*
     * Retrieves bank account details using account number.
     *
     * @param accountNumber Unique identifier of the bank account
     * @return BankEntity containing persisted account data
     */
    BankEntity getAccount(Long accountNumber);

    /*
     * Retrieves all bank account records from the system.
     *
     * @return List of BankEntity objects
     */
    List<BankEntity> getAllAccounts();

    /*
     * Deletes an existing bank account based on account number.
     *
     * @param accountNumber Account number to be deleted
     */
    void deleteAccount(Long accountNumber);

    /*
     * Updates the branch name for a specific bank account.
     *
     * @param accountNumber Account number to be updated
     * @param branchName New branch name to be assigned
     */
    void updateAccount(Long accountNumber, String branchName);

}
