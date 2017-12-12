package com.lhh.crmsystem.entity;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 职位信息表
 * 
 * @author 46512
 *
 */
public class JobInfo {
	private int id;// 职位编号
	private String job;// 职位名称
	@JSONField(serialize = false)
	private Department departmentId;// 部门编号

	// 一个职位可以有多名员工
	@JSONField(serialize = false)
	private List<Employee> empList;
	// 一个职位可以有多个权限
	@JSONField(serialize = false)
	private List<JobRight> jobrList;

	public JobInfo(int id, String job, Department departmentId) {
		super();
		this.id = id;
		this.job = job;
		this.departmentId = departmentId;
	}

	public JobInfo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Department getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	public List<JobRight> getJobrList() {
		return jobrList;
	}

	public void setJobrList(List<JobRight> jobrList) {
		this.jobrList = jobrList;
	}

	@Override
	public String toString() {
		return "JobInfo [id=" + id + ", job=" + job + "]";
	}
}
