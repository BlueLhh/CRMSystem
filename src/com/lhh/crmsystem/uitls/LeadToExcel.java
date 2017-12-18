package com.lhh.crmsystem.uitls;

import java.util.LinkedHashMap;

public class LeadToExcel {
	public LinkedHashMap<String, String> getLeadToFiledPublicQuestionBank() {
		
		LinkedHashMap<String, String> superCustMap = new LinkedHashMap<String, String>();
		superCustMap.put("id", "客户编号");
		superCustMap.put("name", "客户姓名");
		superCustMap.put("education", "教育水平");
		superCustMap.put("phoneNo", "手机号");
		superCustMap.put("qq", "QQ");
		superCustMap.put("email", "邮箱");
		superCustMap.put("customStatu", "客户状态");
		superCustMap.put("createDate", "创建日期");
		superCustMap.put("inviteName", "邀请人姓名");
		
		return superCustMap;
	}
}
