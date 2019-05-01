package com.peopleconnect.CollaborationBackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int jobid;
	
	@Column(nullable=false)
	private String jobprofile;
	
	@Column(nullable=false)
	private String jobdesc;
	
	@Column(nullable=false)
	private Date postdate;
	
	@Column(nullable=false)
	private String qualification;
	
	@Column(nullable=false)
	private String status;

	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public String getJobprofile() {
		return jobprofile;
	}

	public void setJobprofile(String jobprofile) {
		this.jobprofile = jobprofile;
	}

	public String getJobdesc() {
		return jobdesc;
	}

	public void setJobdesc(String jobdesc) {
		this.jobdesc = jobdesc;
	}

	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
