package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	@GeneratedValue
	@Column(name = "ACCOUNT_ID")
	private int accountId;

	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;

	@ManyToOne
	@JoinColumn(name= "USER_ID")
	@NotFound(action = NotFoundAction.IGNORE)
	private UserDetails userDetails;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Account(String accountNumber, UserDetails userDetails) {
		super();
		this.accountNumber = accountNumber;
		this.userDetails = userDetails;
	}

	public Account() {
		super();
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", userDetails=" + userDetails
				+ "]";
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

}
