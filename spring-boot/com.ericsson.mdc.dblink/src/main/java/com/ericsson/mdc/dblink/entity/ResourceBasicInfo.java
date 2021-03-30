package com.ericsson.mdc.dblink.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMDC_RES_BASIC_INFORMATION")
public class ResourceBasicInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "SIGNUM", length=7, nullable = false, unique = true, updatable = false, insertable = true)
	private String signum;
	@Column(name = "PERSON_NO", length = 8, nullable = false, unique = true, updatable = true, insertable = true)
	private String personNo;
	@Column(name = "RESOURCE_NAME", nullable = false, unique = false, updatable = true, insertable = true)
	private String resourceName;
	@Column(name = "EMAIL_ID", nullable = false, unique = true, updatable = true, insertable = true)
	private String emailId;
	@Column(name = "PHONE_NO", nullable = false, unique = true, updatable = true, insertable = true)
	private String phoneNo;
	@Column(name = "CURRENT_PROJECT", nullable = false, unique = false, updatable = true, insertable = true)
	private String currentProject;
	@Column(name = "BASE_LOCATION", nullable = false, unique = false, updatable = true, insertable = true)
	private String location;

	public String getSignum() {
		return signum;
	}

	public void setSignum(String signum) {
		this.signum = signum;
	}

	public String getPersonNo() {
		return personNo;
	}

	public void setPersonNo(String personNo) {
		this.personNo = personNo;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(String currentProject) {
		this.currentProject = currentProject;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ResourceBasicInfo(String signum, String personNo, String resourceName, String emailId, String phoneNo,
			String currentProject, String location) {
		super();
		this.signum = signum;
		this.personNo = personNo;
		this.resourceName = resourceName;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.currentProject = currentProject;
		this.location = location;
	}

	public ResourceBasicInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ResourceBasicInfo [signum=" + signum + ", personNo=" + personNo + ", resourceName=" + resourceName
				+ ", emailId=" + emailId + ", phoneNo=" + phoneNo + ", currentProject=" + currentProject + ", location="
				+ location + "]";
	}

}
