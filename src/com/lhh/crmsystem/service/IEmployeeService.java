package com.lhh.crmsystem.service;

import com.lhh.crmsystem.entity.Employee;

public interface IEmployeeService {
	/**
	 * 通过用户账号和密码登录 用户账号为邮箱
	 * 
	 * @param username
	 * @param pass
	 * @return
	 */
	public Employee login(String username, String pass);
}
