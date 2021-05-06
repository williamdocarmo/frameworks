package com.financemanager.portfolioservices.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financemanager.portfolioservices.model.MoneyOwed;

@RestController("moneyowed")
public class MoneyOweController {

	@PutMapping
	public void updateMoneyOwed(MoneyOwed moneyOwed) {

	}

	@GetMapping
	public List<MoneyOwed> getMoneyOweds() {
		return null;
	}

}
