package com.financemanager.portfolioservices.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financemanager.portfolioservices.model.PhysicalWallet;

@RestController("physicalwallets")
public class PhysicalWalletController {

	@PutMapping
	public void updatePhysicalWalletSavings(PhysicalWallet PhysicalWalletSavings) {

	}

	@GetMapping
	public List<PhysicalWallet> getAllPhysicalWallets() {
		return null;
	}

}
