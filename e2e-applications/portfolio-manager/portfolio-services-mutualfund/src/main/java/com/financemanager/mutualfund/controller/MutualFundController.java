package com.financemanager.mutualfund.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financemanager.mutualfund.model.MutualFund;

@RequestMapping("mutualfunds")
public class MutualFundController {
	
	@PostMapping
	public void addMutualFundInvestments(MutualFund fund) {
		
	}
	
	@GetMapping
	public List<MutualFund> getMutualFundInvestments(MutualFund fund) {
		return null;
	}

}
