package com.lhh.crmsystem.entity;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 员工表
 * 
 * @author 46512
 *
 */
public class Employee {
	private int id;// 员工编号
	private String username;// 用户名 邮箱作为用户名
	private String pass;// 密码
	private String nickname;// 昵称
	private String realname;// 真实姓名
	private JobInfo jobInfoId;// 职位编号
	private Department departmentId;// 部门编号
	private String phoneNo;// 手机号码
	private String officeTel;// 办公号码
	private String workStatu;// 员工在职状态

	// 一个员工可以对多个客户进行跟踪 与跟踪单有一对多关系
	@JSONField(serialize = false)
	private List<ConsultRecord> conList;
	// 一个员工可以对多个客户进行跟踪 与销售单有一对多关系
	@JSONField(serialize = false)
	private List<CustomInfo> cusList;

	public Employee() {
		super();
	}

	public Employee(int id, String username, String pass, String nickname, String realname, JobInfo jobInfoId,
			Department departmentId, String phoneNo, String officeTel, String workStatu) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
		this.nickname = nickname;
		this.realname = realname;
		this.jobInfoId = jobInfoId;
		this.departmentId = departmentId;
		this.phoneNo = phoneNo;
		this.officeTel = officeTel;
		this.workStatu = workStatu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public JobInfo getJobInfoId() {
		return jobInfoId;
	}

	public void setJobInfoId(JobInfo jobInfoId) {
		this.jobInfoId = jobInfoId;
	}

	public Department getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getOfficeTel() {
		return officeTel;
	}

	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}

	public String getWorkStatu() {
		return workStatu;
	}

	public void setWorkStatu(String workStatu) {
		this.workStatu = workStatu;
	}

	public List<ConsultRecord> getConList() {
		return conList;
	}

	public void setConList(List<ConsultRecord> conList) {
		this.conList = conList;
	}

	public List<CustomInfo> getCusList() {
		return cusList;
	}

	public void setCusList(List<CustomInfo> cusList) {
		this.cusList = cusList;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", pass=" + pass + ", nickname=" + nickname
				+ ", realname=" + realname + ", jobInfoId=" + jobInfoId.getJob() + ", departmentId="
				+ departmentId.getDname() + ", phoneNo=" + phoneNo + ", officeTel=" + officeTel + ", workStatu="
				+ workStatu + "]";
	}
}
