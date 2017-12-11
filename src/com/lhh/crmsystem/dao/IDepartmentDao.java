package com.lhh.crmsystem.dao;

import java.util.List;

import com.lhh.crmsystem.entity.Department;

public interface IDepartmentDao {

	/**
	 * 新增一条部门信息
	 * 
	 * @param department
	 * @return
	 */
	public int insert(Department department);

	/**
	 * 删除一条部门信息
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id);

	/**
	 * 修改一条部门信息
	 * 
	 * @param department
	 * @return
	 */
	public Department updateByObj(Department department);

	/**
	 * 根据ID查询一条部门信息
	 * 
	 * @param id
	 * @return
	 */
	public Department queryById(Integer id);

	/**
	 * 查询全部的部门信息
	 * 
	 * @param department
	 * @return
	 */
	public List<Department> queryByAll();

}
