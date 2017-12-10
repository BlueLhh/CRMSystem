package com.lhh.crmsystem.entity;

import java.util.Date;
import java.util.List;

/**
 * 客户基础信息表
 * 
 * @author 46512
 *
 */
public class Custom {
	private int id;// 客户编号
	private String name;// 客户名字
	private String education;// 教育水平
	private String phoneNo;// 手机号
	private int qq;// qq
	private String email;// 邮箱
	private String customStatu;// 客户状态
	private Date createDate;// 创建日期
	private String inviteName;// 邀请人姓名

	// 客户可以有多个咨询师
	private List<ConsultRecord> conList;
	// 客户与销售跟踪信息关系 一对多
	private List<CustomInfo> cusList;

	public Custom() {
		super();
	}

	public Custom(int id, String name, String education, String phoneNo, int qq, String email, String customStatu,
			Date createDate, String inviteName) {
		super();
		this.id = id;
		this.name = name;
		this.education = education;
		this.phoneNo = phoneNo;
		this.qq = qq;
		this.email = email;
		this.customStatu = customStatu;
		this.createDate = createDate;
		this.inviteName = inviteName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getQq() {
		return qq;
	}

	public void setQq(int qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomStatu() {
		return customStatu;
	}

	public void setCustomStatu(String customStatu) {
		this.customStatu = customStatu;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getInviteName() {
		return inviteName;
	}

	public void setInviteName(String inviteName) {
		this.inviteName = inviteName;
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
		return "Custom [id=" + id + ", name=" + name + ", education=" + education + ", phoneNo=" + phoneNo + ", qq="
				+ qq + ", email=" + email + ", customStatu=" + customStatu + ", createDate=" + createDate
				+ ", inviteName=" + inviteName + "]";
	}
}
