package com.ericsson.mdc.dblink.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMDC_RES_CURRENT_ACTIVITY")
public class ResourceCurrentActivity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SERIAL", insertable = true, nullable = false, updatable = false, unique = true)
	private int serial;
	@Column(name = "SIGNUM", insertable = true, length = 7, nullable = false, unique = false, updatable = false)
	private String signum;
	@Column(name = "RESOURCE_NAME", insertable = true, length = 255, nullable = true, unique = false, updatable = true)
	private String resourceName;
	@Column(name = "CURRENT_PROJECT", insertable = true, nullable = false, unique = false, updatable = true)
	private String currentProject;
	@Column(name = "CURRENT_MILESTONE", insertable = true, nullable = true, unique = false, updatable = true)
	private String currentMilestone;
	@Column(name = "CURRENT_ACTIVITIES", insertable = true, nullable = true, unique = false, updatable = true)
	private String currentActivities;
	@Column(name = "CHALLENGES_FACED", insertable = true, nullable = true, unique = false, updatable = true)
	private String challengesFaced;
	@Column(name = "STATUS", insertable = true, nullable = true, unique = false, updatable = true)
	private String status = "green";
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TIMESTAMP", insertable = true, nullable = false, unique = false, updatable = false)
	private Date updateTimestamp;
	@Column(name = "DEADLINE", insertable = true, nullable = true, unique = false, updatable = false)
	private Date deadline;

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getSignum() {
		return signum;
	}

	public void setSignum(String signum) {
		this.signum = signum;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(String currentProject) {
		this.currentProject = currentProject;
	}

	public String getCurrentMilestone() {
		return currentMilestone;
	}

	public void setCurrentMilestone(String currentMilestone) {
		this.currentMilestone = currentMilestone;
	}

	public String getChallengesFaced() {
		return challengesFaced;
	}

	public void setChallengesFaced(String challengesFaced) {
		this.challengesFaced = challengesFaced;
	}

	public Date getUpdateTimestamp() {
		return this.updateTimestamp;
	}

	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	public String getCurrentActivities() {
		return currentActivities;
	}

	public void setCurrentActivities(String currentActivities) {
		this.currentActivities = currentActivities;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public ResourceCurrentActivity(String signum, String currentProject, String currentMilestone,
			String challengesFaced, Date updateTimestamp) {
		super();
		this.signum = signum;
		this.currentProject = currentProject;
		this.currentMilestone = currentMilestone;
		this.challengesFaced = challengesFaced;
		this.updateTimestamp = updateTimestamp;
	}

	public ResourceCurrentActivity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ResourceCurrentActivity [serial=" + serial + ", signum=" + signum + ", resourceName=" + resourceName
				+ ", currentProject=" + currentProject + ", currentMilestone=" + currentMilestone
				+ ", currentActivities=" + currentActivities + ", challengesFaced=" + challengesFaced + ", status="
				+ status + ", updateTimestamp=" + updateTimestamp + ", deadline=" + deadline + "]";
	}

}
