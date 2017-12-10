package com.lhh.crmsystem.entity;

import java.util.Date;

/**
 * 咨询师跟单记录表
 * 
 * @author 46512
 *
 */
public class ConsultRecord {
	private int id;
	private Custom customId;// 客户编号
	private Employee consultManId;// 咨询师编号
	private String consultStatu;// 咨询状态
	private Date consultDate;// 咨询日期
	private String result;// 咨询备注

	public ConsultRecord() {
		super();
	}

	public ConsultRecord(int id, Custom customId, Employee consultManId, String consultStatu, Date consultDate,
			String result) {
		super();
		this.id = id;
		this.customId = customId;
		this.consultManId = consultManId;
		this.consultStatu = consultStatu;
		this.consultDate = consultDate;
		this.result = result;
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

	public Employee getConsultManId() {
		return consultManId;
	}

	public void setConsultManId(Employee consultManId) {
		this.consultManId = consultManId;
	}

	public String getConsultStatu() {
		return consultStatu;
	}

	public void setConsultStatu(String consultStatu) {
		this.consultStatu = consultStatu;
	}

	public Date getConsultDate() {
		return consultDate;
	}

	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ConsultRecord [id=" + id + ", customId=" + customId + ", consultManId=" + consultManId
				+ ", consultStatu=" + consultStatu + ", consultDate=" + consultDate + ", result=" + result + "]";
	}
}
