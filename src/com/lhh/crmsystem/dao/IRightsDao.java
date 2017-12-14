package com.lhh.crmsystem.dao;

import java.util.List;

import com.lhh.crmsystem.entity.Rights;

public interface IRightsDao {
	/**
	 * 增
	 * 
	 * @param customInfo
	 * @return
	 */
	public int insert(Rights rights);

	/**
	 * 删
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id);

	/**
	 * 改
	 * 
	 * @param customInfo
	 * @return
	 */
	public Rights updateByObj(Rights rights);

	/**
	 * 查
	 * 
	 * @param id
	 * @return
	 */
	public Rights queryById(Integer id);

	/**
	 * 查询全部的信息
	 * 
	 * @return
	 */
	public List<Rights> queryByAll();

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
	public List<Rights> queryByPage(int count, int page, int pageSize);

}
