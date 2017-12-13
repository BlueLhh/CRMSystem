package com.lhh.crmsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhh.crmsystem.dao.IDepartmentDao;
import com.lhh.crmsystem.entity.Department;
import com.lhh.crmsystem.service.IDepartmentService;

@Service("deptService")
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private IDepartmentDao deptDao;

	@Override
	public Department queryDepartment(Integer id) {
		Department dept = deptDao.queryById(id);
		return dept;
	}

	@Override
	public List<Department> queryAll() {
		List<Department> list = new ArrayList<Department>();
		list = deptDao.queryByAll();
		return list;
	}
}
