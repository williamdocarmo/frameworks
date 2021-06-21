package com.financemanager.portfolioservices.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financemanager.portfolioservices.model.BankAccount;

@RestController("savingsaccounts")
public class SavingsAccountController {
	
	@PostMapping
	public void addBankAccount(BankAccount bankAccount) {
		
	}
	
	@PutMapping
	public void updateBankAccountSavings(BankAccount bankAccountSavings) {
		
	}
	
	@GetMapping
	public List<BankAccount> getAllBankAccountDetails() {
		return null;
	}

}
