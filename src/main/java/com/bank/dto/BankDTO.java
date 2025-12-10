package com.bank.dto;

import lombok.Setter;

@Setter
public class BankDTO {
	private Long accountNumber;

	private String accountHolderName;

	private String branchName;

	private Double balance;

}
