package com.lhh.crmsystem.dao;

import java.util.List;

import com.lhh.crmsystem.entity.Department;

public interface IDepartmentDao {
	/**
	 * 插入一条部门信息
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
	 * 更新一条部门信息
	 * 
	 * @param department
	 * @return
	 */
	public Department updateByObj(Department department);

	/**
	 * 查询一条部门信息
	 * 
	 * @param id
	 * @return
	 */
	public Department queryById(Integer id);

	/**
	 * 查询全部部门信息
	 * 
	 * @return
	 */
	public List<Department> queryByAll();
}
