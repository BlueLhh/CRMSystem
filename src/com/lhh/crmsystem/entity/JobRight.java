package com.lhh.crmsystem.entity;

/**
 * 职位权限对照表
 * 
 * @author 46512
 *
 */
public class JobRight {
	private int id;// 序号
	private JobInfo jobInfoId;// 职位编号
	private Rights rightsId;// 权利编号

	public JobRight() {
		super();
	}

	public JobRight(int id, JobInfo jobInfoId, Rights rightsId) {
		super();
		this.id = id;
		this.jobInfoId = jobInfoId;
		this.rightsId = rightsId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JobInfo getJobInfoId() {
		return jobInfoId;
	}

	public void setJobInfoId(JobInfo jobInfoId) {
		this.jobInfoId = jobInfoId;
	}

	public Rights getRightsId() {
		return rightsId;
	}

	public void setRightsId(Rights rightsId) {
		this.rightsId = rightsId;
	}

	@Override
	public String toString() {
		return "JobRight [id=" + id + ", jobInfoId=" + jobInfoId + ", rightsId=" + rightsId + "]";
	}

}
