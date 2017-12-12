package com.lhh.crmsystem.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 销售客户跟踪信息表
 * 
 * @author 46512
 *
 */
public class CustomInfo {
	private int id;// 序号
	@JSONField(serialize = false)
	private Custom customId;// 客户编号
	@JSONField(serialize = false)
	private Employee followManId;// 跟单人编号
	private String statu;// 跟单状态
	private Date startDate;// 开始日期
	private Date lastFollowDate;// 最后联系日期
	private Date planDate;// 计划联系日期
	private String mark;// 备注

	public CustomInfo() {
		super();
	}

	public CustomInfo(int id, Custom customId, Employee followManId, String statu, Date startDate, Date lastFollowDate,
			Date planDate, String mark) {
		super();
		this.id = id;
		this.customId = customId;
		this.followManId = followManId;
		this.statu = statu;
		this.startDate = startDate;
		this.lastFollowDate = lastFollowDate;
		this.planDate = planDate;
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Custom getCustomId() {
		return customId;
	}

	public void setCustomId(Custom customId) {
		this.customId = customId;
	}

	public Employee getFollowManId() {
		return followManId;
	}

	public void setFollowManId(Employee followManId) {
		this.followManId = followManId;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getLastFollowDate() {
		return lastFollowDate;
	}

	public void setLastFollowDate(Date lastFollowDate) {
		this.lastFollowDate = lastFollowDate;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "CustomInfo [id=" + id + ", customId=" + customId + ", followManId=" + followManId + ", statu=" + statu
				+ ", startDate=" + startDate + ", lastFollowDate=" + lastFollowDate + ", planDate=" + planDate
				+ ", mark=" + mark + "]";
	}

}
