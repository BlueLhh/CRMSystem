package com.lhh.crmsystem.entity;

/**
 * 重置密码记录表
 * 
 * @author 46512
 *
 */
public class Resetpass {
	private int id;// 序号
	private String username;// 用户名
	private String phoneNo;// 手机号

	public Resetpass() {
		super();
	}

	public Resetpass(int id, String username, String phoneNo) {
		super();
		this.id = id;
		this.username = username;
		this.phoneNo = phoneNo;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Resetpass [id=" + id + ", username=" + username + ", phoneNo=" + phoneNo + "]";
	}
}
