package com.financemanager.mutualfund.model;

import java.util.List;

public class MutualFund {

	private String assetManagementCompanyName;

	private String fundName;

	private String fundType;

	private String fundDescription;

	private String folioNumber;

	private List<MutualFundInvestment> mutualFundInvestments;

	public String getAssetManagementCompanyName() {
		return assetManagementCompanyName;
	}

	public void setAssetManagementCompanyName(String assetManagementCompanyName) {
		this.assetManagementCompanyName = assetManagementCompanyName;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getFundType() {
		return fundType;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	public String getFundDescription() {
		return fundDescription;
	}

	public void setFundDescription(String fundDescription) {
		this.fundDescription = fundDescription;
	}

	public String getFolioNumber() {
		return folioNumber;
	}

	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}

	public List<MutualFundInvestment> getMutualFundInvestments() {
		return mutualFundInvestments;
	}

	public void setMutualFundInvestments(List<MutualFundInvestment> mutualFundInvestments) {
		this.mutualFundInvestments = mutualFundInvestments;
	}

	public MutualFund() {
		super();
	}

	public MutualFund(String assetManagementCompanyName, String fundName, String fundType, String fundDescription,
			String folioNumber, List<MutualFundInvestment> mutualFundInvestments) {
		super();
		this.assetManagementCompanyName = assetManagementCompanyName;
		this.fundName = fundName;
		this.fundType = fundType;
		this.fundDescription = fundDescription;
		this.folioNumber = folioNumber;
		this.mutualFundInvestments = mutualFundInvestments;
	}

	@Override
	public String toString() {
		return "MutualFund [assetManagementCompanyName=" + assetManagementCompanyName + ", fundName=" + fundName
				+ ", fundType=" + fundType + ", fundDescription=" + fundDescription + ", folioNumber=" + folioNumber
				+ ", mutualFundInvestments=" + mutualFundInvestments + "]";
	}

}
