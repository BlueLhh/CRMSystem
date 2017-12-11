package com.lhh.crmsystem.dao;

import java.util.List;

import com.lhh.crmsystem.entity.CustomInfo;

public interface ICustomInfoDao {
	/**
	 * 增
	 * 
	 * @param customInfo
	 * @return
	 */
	public int insert(CustomInfo customInfo);

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
	public CustomInfo updateByObj(CustomInfo customInfo);

	/**
	 * 查
	 * 
	 * @param id
	 * @return
	 */
	public CustomInfo queryById(Integer id);

	/**
	 * 查询全部的信息
	 * 
	 * @return
	 */
	public List<CustomInfo> queryByAll();
}
