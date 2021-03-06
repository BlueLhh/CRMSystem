package com.lhh.crmsystem.dao;

import java.util.List;
import java.util.Map;

import com.lhh.crmsystem.entity.Employee;

public interface IEmployeeDao {
	/**
	 * 插入一个员工
	 * 
	 * @param employee
	 * @return
	 */
	public int insert(Employee employee);

	/**
	 * 删除一个员工
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id);

	/**
	 * 更改员工信息
	 * 
	 * @param employee
	 * @return
	 */
	public int update(Employee employee);

	/**
	 * 动态更新员工信息
	 * 
	 * @param employee
	 * @return
	 */
	public int updateByObj(Employee employee);

	public int updateByIdAndStuts(String stuts, Integer id);

	/******* 查询 ********/
	/**
	 * 通过id查询返回一个员工信息
	 * 
	 * @param id
	 * @return
	 */
	public Employee queryById(Integer id);

	/**
	 * 通过用户账号和密码查询用户信息 用于登录
	 * 
	 * @param username
	 * @param pass
	 * @return
	 */
	public Employee queryByUsernameAndPass(String username, String pass);

	/**
	 * 动态查询
	 * 
	 * @param employee
	 * @return
	 */
	public Employee queryOneByObj(Employee employee);

	public List<Employee> queryManyByObj(Employee employee);

	/**
	 * 查询员工的全部信息
	 * 
	 * @return
	 */
	public List<Employee> queryByAll();

	/**
	 * 获取总数据条数
	 * 
	 * @return
	 */
	public int queryByCount();

	/**
	 * 分页查询
	 * 
	 * @param count
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Employee> queryByPage(int count, int page, int pageSize);

	/**
	 * 查询员工总数，根据条件来查询
	 * 
	 * @param condition
	 * @return
	 */
	public int count(Map<String, Object> condition);

	/**
	 * 查询分页 condition中分别传入职位ID，当前页码，每页显示行数
	 * 
	 * @param condition
	 * @return
	 */
	public List<Employee> findByPage(Map<String, Object> condition);

}
