package com.lhh.crmsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public int insertEmployee(Employee employee) {
		int rows = empDao.insert(employee);
		return rows;
	}

	@Override
	public int deleteEmployee(Integer id) {
		int rows = empDao.deleteById(id);
		return rows;
	}

	@Override
	public int updateEmployee(Employee employee) {
		int rows = empDao.update(employee);
		return rows;
	}

	@Override
	public int updateEmployeeByObj(Employee employee) {
		int rows = empDao.updateByObj(employee);
		return rows;
	}

	@Override
	public Employee queryEmployee(Integer id) {
		Employee employee = empDao.queryById(id);
		return employee;
	}

	@Override
	public List<Employee> queryAll() {
		List<Employee> list = new ArrayList<Employee>();
		list = empDao.queryByAll();
		return list;
	}

	@Override
	public int insertAdmin(Employee employee) {
		int rows = empDao.insert(employee);
		return rows;
	}

	@Override
	public Employee queryOneByObj(Employee employee) {
		Employee emp;
		emp = empDao.queryOneByObj(employee);
		return emp;
	}

	@Override
	public List<Employee> queryManyByObj(Employee employee) {
		List<Employee> list = new ArrayList<Employee>();
		list = empDao.queryManyByObj(employee);
		return list;
	}
}
