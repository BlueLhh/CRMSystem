package com.lhh.crmsystem.service;

import java.util.List;

import com.lhh.crmsystem.entity.Department;

public interface IDepartmentService {

	public Department queryDepartment(Integer id);

	public List<Department> queryAll();

}
