package com.financemanager.portfolioservices.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financemanager.portfolioservices.model.Salary;

@RestController("/salary")
public class SalaryController {

	@PostMapping()
	public void addSalary(Salary salary) {

	}

	@GetMapping("/{year}")
	public List<Salary> getSalaryByYear(@PathVariable("year") int year) {
		return null;
	}

	@GetMapping
	public List<Salary> getAllSalaries() {
		return null;
	}

}
