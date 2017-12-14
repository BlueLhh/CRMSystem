package com.lhh.crmsystem.entity;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 权限表
 * 
 * @author 46512
 *
 */
public class Rights {
	private int rid;// 权限编号
	private String rightName;// 权限名称
	private String rightType;// 权限级别
	private String url;// 选项卡URL值
	private Rights pid;// 类别编号

	// 多个职位人员可以拥有同一个权限
	@JSONField(serialize = false)
	private List<JobRight> jobrList;
	@JSONField(serialize = false)
	private List<Rights> rigList;

	public Rights() {
		super();
	}

	public Rights(int rid, String rightName, String rightType, String url, Rights pid) {
		super();
		this.rid = rid;
		this.rightName = rightName;
		this.rightType = rightType;
		this.url = url;
		this.pid = pid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public String getRightType() {
		return rightType;
	}

	public void setRightType(String rightType) {
		this.rightType = rightType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Rights getPid() {
		return pid;
	}

	public void setPid(Rights pid) {
		this.pid = pid;
	}

	public List<JobRight> getJobrList() {
		return jobrList;
	}

	public void setJobrList(List<JobRight> jobrList) {
		this.jobrList = jobrList;
	}

	public List<Rights> getRigList() {
		return rigList;
	}

	public void setRigList(List<Rights> rigList) {
		this.rigList = rigList;
	}

	@Override
	public String toString() {
		return "Rights [rid=" + rid + ", rightName=" + rightName + ", rightType=" + rightType + ", url=" + url + "]";
	}
}
