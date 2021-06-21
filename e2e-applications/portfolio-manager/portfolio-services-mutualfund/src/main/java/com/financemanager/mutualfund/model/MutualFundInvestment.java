package com.financemanager.mutualfund.model;

import java.util.Date;

public class MutualFundInvestment {

	private Date investmentDate;

	private float purchasedUnit;

	private float purchaseNAV;

	private float currentNAV;

	private float investedAmount;

	private float currentValuation;

	public MutualFundInvestment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MutualFundInvestment(Date investmentDate, float purchasedUnit, float purchaseNAV, float currentNAV,
			float investedAmount, float currentValuation) {
		super();
		this.investmentDate = investmentDate;
		this.purchasedUnit = purchasedUnit;
		this.purchaseNAV = purchaseNAV;
		this.currentNAV = currentNAV;
		this.investedAmount = investedAmount;
		this.currentValuation = currentValuation;
	}

	public Date getInvestmentDate() {
		return investmentDate;
	}

	public void setInvestmentDate(Date investmentDate) {
		this.investmentDate = investmentDate;
	}

	public float getPurchasedUnit() {
		return purchasedUnit;
	}

	public void setPurchasedUnit(float purchasedUnit) {
		this.purchasedUnit = purchasedUnit;
	}

	public float getPurchaseNAV() {
		return purchaseNAV;
	}

	public void setPurchaseNAV(float purchaseNAV) {
		this.purchaseNAV = purchaseNAV;
	}

	public float getCurrentNAV() {
		return currentNAV;
	}

	public void setCurrentNAV(float currentNAV) {
		this.currentNAV = currentNAV;
	}

	public float getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(float investedAmount) {
		this.investedAmount = investedAmount;
	}

	public float getCurrentValuation() {
		return currentValuation;
	}

	public void setCurrentValuation(float currentValuation) {
		this.currentValuation = currentValuation;
	}

	@Override
	public String toString() {
		return "MutualFundInvestment [investmentDate=" + investmentDate + ", purchasedUnit=" + purchasedUnit
				+ ", purchaseNAV=" + purchaseNAV + ", currentNAV=" + currentNAV + ", investedAmount=" + investedAmount
				+ ", currentValuation=" + currentValuation + "]";
	}

}
