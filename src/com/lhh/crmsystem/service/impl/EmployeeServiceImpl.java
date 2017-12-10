package com.lhh.crmsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhh.crmsystem.dao.IEmployeeDao;
import com.lhh.crmsystem.entity.Employee;
import com.lhh.crmsystem.service.IEmployeeService;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao empDao;

	@Override
	public Employee login(String username, String pass) {
		Employee employee = empDao.queryByUsernameAndPass(username, pass);
		return employee;
	}
}
