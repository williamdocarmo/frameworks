package com.financemanager.portfolioservices.model;

public class MoneyOwed {

	enum OWE_TYPE {
		LENT, BORROWED
	}

	private String involvedPerson;

	private int amountInvolved;

	private OWE_TYPE oweType;
	
	private String comments;

}
