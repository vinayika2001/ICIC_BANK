package com.bank.model;

import com.bank.dto.BankDTO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "bank_record")
@NoArgsConstructor
public class BankEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private Long accountNumber;
	private String accountHolderName;
	private String branchName;
	private Double balance;

	public BankEntity(BankDTO bank) {
		this.accountHolderName = bank.getAccountHolderName();
		this.branchName = bank.getBranchName();
		this.balance = bank.getBalance();
	}
}
