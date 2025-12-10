package com.bank.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BankDTO {
	private Long accountNumber;

	private String accountHolderName;

	private String branchName;

	private Double balance;

}
