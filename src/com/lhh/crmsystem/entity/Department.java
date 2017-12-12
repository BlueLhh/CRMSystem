package com.lhh.crmsystem.entity;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 部门信息表
 * 
 * @author 46512
 *
 */
public class Department {
	private int id;// 部门编号
	private String dname;// 部门名称

	// 一个部门可以有多个员工
	@JSONField(serialize = false)
	private List<Employee> empList;
	// 一个部门可以多个职位
	@JSONField(serialize = false)
	private List<JobInfo> jobList;

	public Department(int id, String dname) {
		super();
		this.id = id;
		this.dname = dname;
	}

	public Department() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	public List<JobInfo> getJobList() {
		return jobList;
	}

	public void setJobList(List<JobInfo> jobList) {
		this.jobList = jobList;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", dname=" + dname + "]";
	}
}
