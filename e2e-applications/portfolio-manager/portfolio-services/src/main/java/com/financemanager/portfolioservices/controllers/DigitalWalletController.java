package com.financemanager.portfolioservices.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financemanager.portfolioservices.model.DigitalWallet;

@RestController("digitalwallets")
public class DigitalWalletController {

	@PutMapping
	public void updateDigitalWalletSavings(DigitalWallet digitalWallet) {

	}

	@GetMapping
	public List<DigitalWallet> getAllDigitalWallets() {
		return null;
	}

}
