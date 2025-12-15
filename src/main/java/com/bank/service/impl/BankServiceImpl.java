package com.bank.service.impl;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dto.BankDTO;
import com.bank.model.BankEntity;
import com.bank.repository.BankRepository;
import com.bank.service.BankService;

/*
 * BankServiceImpl
 *
 * This class provides the actual business logic implementation
 * for BankService interface.
 *
 * It handles:
 *  - Account creation
 *  - Account retrieval
 *  - Account update
 *  - Account deletion
 *
 * This layer communicates with the Repository layer
 * and is responsible for transactional consistency.
 */
@Service
public class BankServiceImpl implements BankService {

    private static final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);

    // Repository layer dependency for database operations
    @Autowired
    private BankRepository bankRepository;

    /*
     * Creates and persists a new bank account.
     *
     * Steps:
     * 1. Convert BankDTO to BankEntity
     * 2. Generate a unique 15-digit account number
     * 3. Save entity to database
     * 4. Return success message with account number
     */
    @Override
    public String addAccount(BankDTO bank) {

        logger.info("Saving bank details: {}", bank.toString());

        // Convert DTO to Entity
        BankEntity bankEntity = new BankEntity(bank);

        // Generate unique account number
        bankEntity.setAccountNumber(generateUnique15DigitAccountNumber());

        // Persist entity
        bankEntity = bankRepository.save(bankEntity);

        return "Bank account created successfully : " + bankEntity.getAccountNumber();
    }

    /*
     * Fetches a bank account using account number.
     *
     * @param accountNumber unique account identifier
     * @return BankEntity if found, otherwise null
     */
    @Override
    public BankEntity getAccount(Long accountNumber) {

        logger.info("Getting account with accountNumber: {}", accountNumber);

        return bankRepository
                .findByAccountNumber(accountNumber)
                .orElse(null);
    }

    /*
     * Retrieves all bank accounts from the database.
     *
     * @return List of all BankEntity records
     */
    @Override
    public List<BankEntity> getAllAccounts() {

        logger.info("Getting all bank accounts");

        return bankRepository.findAll();
    }

    /*
     * Deletes a bank account based on account number.
     *
     * Transactional ensures atomic delete operation.
     *
     * @param accountNumber account to be deleted
     */
    @Override
    @Transactional
    public void deleteAccount(Long accountNumber) {

        logger.info("Deleting account with accountNumber: {}", accountNumber);

        bankRepository.deleteByAccountNumber(accountNumber);
    }

    /*
     * Generates a unique 15-digit account number.
     *
     * ThreadLocalRandom is used for better performance
     * in multi-threaded environments.
     *
     * Database check ensures uniqueness.
     *
     * @return unique 15-digit account number
     */
    private Long generateUnique15DigitAccountNumber() {

        Long accountNumber;

        do {
            accountNumber = ThreadLocalRandom.current()
                    .nextLong(100000000000000L, 999999999999999L);
        } while (bankRepository.existsByAccountNumber(accountNumber));

        return accountNumber;
    }

    /*
     * Updates branch name for a given account number.
     *
     * Steps:
     * 1. Fetch account from database
     * 2. Throw exception if account not found
     * 3. Update branch name
     * 4. Save updated entity
     *
     * Transactional ensures update consistency.
     *
     * @param accountNumber account to update
     * @param branchName new branch name
     */
    @Override
    @Transactional
    public void updateAccount(Long accountNumber, String branchName) {

        logger.info("Updating branch name for accountNumber: {}", accountNumber);

        BankEntity bankEntity = bankRepository
                .findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException(
                        "Account not found with accountNumber: " + accountNumber));

        // Update branch name
        bankEntity.setBranchName(branchName);

        // Persist updated entity
        bankRepository.save(bankEntity);

        logger.info("Branch name updated successfully for accountNumber: {}", accountNumber);
    }
}
