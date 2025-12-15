package com.bank.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BankDTO {
	
	private String accountHolderName;

	private String branchName;

	private Double balance;

}
