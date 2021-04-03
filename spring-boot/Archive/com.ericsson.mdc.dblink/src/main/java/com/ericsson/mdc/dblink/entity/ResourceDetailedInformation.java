package com.ericsson.mdc.dblink.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ericsson.mdc.dblink.utils.BooleanToStringConverter;

@Entity
@Table(name = "EMDC_RESOURCE_DETAILS")
public class ResourceDetailedInformation implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "SIGNUM", insertable = true, length = 7, nullable = false, unique = false, updatable = false)
	private String signum;
	@Column(name = "STATUS", insertable = true, nullable = false, unique = false, updatable = true)
	private String status;
	@Column(name = "BILLABLE", length = 1, insertable = true, nullable = false, unique = false, updatable = true)
	@Convert(converter = BooleanToStringConverter.class)
	private boolean billable;
	@Column(name = "DEPLOYABLE", length = 1, insertable = true, nullable = false, unique = false, updatable = true)
	@Convert(converter = BooleanToStringConverter.class)
	private boolean deployable;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "JOINING_DATE", insertable = true, nullable = false, unique = false, updatable = true)
	private Date joiningDate;
	@Column(name = "LOCATION", insertable = true, nullable = false, unique = false, updatable = true)
	private String location;
	@Column(name = "POSITION", insertable = true, nullable = false, unique = false, updatable = true)
	private String position;
	@Column(name = "LINE_MANAGER", length = 7, insertable = true, nullable = false, unique = false, updatable = true)
	private String lineManager;
	@Column(name = "JOB_STAGE", insertable = true, nullable = false, unique = false, updatable = true)
	private String jobStage;
	@Column(name = "JOB_ROLE", insertable = true, nullable = false, unique = false, updatable = true)
	private String jobRole;
	@Column(name = "RNAM_CORE_FLEX_POOL", length = 1, insertable = true, nullable = false, unique = false, updatable = true)
	@Convert(converter = BooleanToStringConverter.class)
	private boolean rnamCoreFlexPool;
	@Column(name = "CD_CORE_FLEX_POOL", length = 1, insertable = true, nullable = false, unique = false, updatable = true)
	@Convert(converter = BooleanToStringConverter.class)
	private boolean cdCoreFlexPool;
	@Column(name = "LOAN_RESOURCE", length = 1, insertable = true, nullable = false, unique = false, updatable = true)
	@Convert(converter = BooleanToStringConverter.class)
	private boolean loanResource;
	@Column(name = "SKILLSET", insertable = true, nullable = false, unique = false, updatable = true)
	private String skillset;
	@Column(name = "PROJECT_STATUS", insertable = true, nullable = false, unique = false, updatable = true)
	private String projectStatus;
	@Column(name = "REGION", length = 4, insertable = true, nullable = false, unique = false, updatable = true)
	private String region;
	@Column(name = "CURRENT_PROJECT", insertable = true, nullable = false, unique = false, updatable = true)
	private String currentProject;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ROLL_OFF_DATE", insertable = true, nullable = true, unique = false, updatable = true)
	private Date rolloffDate;
	@Column(name = "NEXT_PROJECT", insertable = true, nullable = false, unique = false, updatable = true)
	private String nextProject;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPECTED_STARTDATE", insertable = true, nullable = true, unique = false, updatable = true)
	private Date expectedStartdate;
	@Column(name = "RESIGNED_MOBILITY", length = 1, insertable = true, nullable = false, unique = false, updatable = true)
	@Convert(converter = BooleanToStringConverter.class)
	private boolean resignedOrMobility;
	@Column(name = "FULLY_OCCUPIED", length = 1, insertable = true, nullable = false, unique = false, updatable = true)
	@Convert(converter = BooleanToStringConverter.class)
	private boolean fullyOccupied;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TIMESTAMP", insertable = true, nullable = false, unique = false, updatable = true)
	private Date updateTimestamp;

	public String getSignum() {
		return signum;
	}

	public void setSignum(String signum) {
		this.signum = signum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isBillable() {
		return billable;
	}

	public void setBillable(boolean billable) {
		this.billable = billable;
	}

	public boolean isDeployable() {
		return deployable;
	}

	public void setDeployable(boolean deployable) {
		this.deployable = deployable;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLineManager() {
		return lineManager;
	}

	public void setLineManager(String lineManager) {
		this.lineManager = lineManager;
	}

	public String getJobStage() {
		return jobStage;
	}

	public void setJobStage(String jobStage) {
		this.jobStage = jobStage;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public boolean isRnamCoreFlexPool() {
		return rnamCoreFlexPool;
	}

	public void setRnamCoreFlexPool(boolean rnamCoreFlexPool) {
		this.rnamCoreFlexPool = rnamCoreFlexPool;
	}

	public boolean isCdCoreFlexPool() {
		return cdCoreFlexPool;
	}

	public void setCdCoreFlexPool(boolean cdCoreFlexPool) {
		this.cdCoreFlexPool = cdCoreFlexPool;
	}

	public boolean isLoanResource() {
		return loanResource;
	}

	public void setLoanResource(boolean loanResource) {
		this.loanResource = loanResource;
	}

	public String getSkillset() {
		return skillset;
	}

	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(String currentProject) {
		this.currentProject = currentProject;
	}

	public Date getRolloffDate() {
		return rolloffDate;
	}

	public void setRolloffDate(Date rolloffDate) {
		this.rolloffDate = rolloffDate;
	}

	public String getNextProject() {
		return nextProject;
	}

	public void setNextProject(String nextProject) {
		this.nextProject = nextProject;
	}

	public Date getExpectedStartdate() {
		return expectedStartdate;
	}

	public void setExpectedStartdate(Date expectedStartdate) {
		this.expectedStartdate = expectedStartdate;
	}

	public boolean isResignedOrMobility() {
		return resignedOrMobility;
	}

	public void setResignedOrMobility(boolean resignedOrMobility) {
		this.resignedOrMobility = resignedOrMobility;
	}

	public boolean isFullyOccupied() {
		return fullyOccupied;
	}

	public void setFullyOccupied(boolean fullyOccupied) {
		this.fullyOccupied = fullyOccupied;
	}

	public Date getUpdateTimestamp() {
		return this.updateTimestamp;
	}

	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	public ResourceDetailedInformation(String signum, String status, boolean billable, boolean deployable,
			Date joiningDate, String location, String position, String lineManager, String jobStage, String jobRole,
			boolean rnamCoreFlexPool, boolean cdCoreFlexPool, boolean loanResource, String skillset,
			String projectStatus, String region, String currentProject, Date rolloffDate, String nextProject,
			Date expectedStartdate, boolean resignedOrMobility, boolean fullyOccupied, Date updateTimestamp) {
		super();
		this.signum = signum;
		this.status = status;
		this.billable = billable;
		this.deployable = deployable;
		this.joiningDate = joiningDate;
		this.location = location;
		this.position = position;
		this.lineManager = lineManager;
		this.jobStage = jobStage;
		this.jobRole = jobRole;
		this.rnamCoreFlexPool = rnamCoreFlexPool;
		this.cdCoreFlexPool = cdCoreFlexPool;
		this.loanResource = loanResource;
		this.skillset = skillset;
		this.projectStatus = projectStatus;
		this.region = region;
		this.currentProject = currentProject;
		this.rolloffDate = rolloffDate;
		this.nextProject = nextProject;
		this.expectedStartdate = expectedStartdate;
		this.resignedOrMobility = resignedOrMobility;
		this.fullyOccupied = fullyOccupied;
		this.updateTimestamp = updateTimestamp;
	}

	public ResourceDetailedInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ResourceDetailedInformation [signum=" + signum + ", status=" + status + ", Billable=" + billable
				+ ", deployable=" + deployable + ", joiningDate=" + joiningDate + ", location=" + location
				+ ", position=" + position + ", lineManager=" + lineManager + ", jobStage=" + jobStage + ", jobRole="
				+ jobRole + ", rnamCoreFlexPool=" + rnamCoreFlexPool + ", cdCoreFlexPool=" + cdCoreFlexPool
				+ ", loanResource=" + loanResource + ", skillset=" + skillset + ", projectStatus=" + projectStatus
				+ ", region=" + region + ", currentProject=" + currentProject + ", rolloffDate=" + rolloffDate
				+ ", nextProject=" + nextProject + ", expectedStartdate=" + expectedStartdate + ", resignedOrMobility="
				+ resignedOrMobility + ", fullyOccupied=" + fullyOccupied + ", updateTimestamp=" + updateTimestamp
				+ "]";
	}

}
