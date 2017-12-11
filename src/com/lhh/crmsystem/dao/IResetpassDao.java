package com.lhh.crmsystem.dao;

import java.util.List;

import com.lhh.crmsystem.entity.Resetpass;

public interface IResetpassDao {
	/**
	 * 增
	 * 
	 * @param customInfo
	 * @return
	 */
	public int insert(Resetpass resetpass);

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
	public Resetpass updateByObj(Resetpass resetpass);

	/**
	 * 查
	 * 
	 * @param id
	 * @return
	 */
	public Resetpass queryById(Integer id);

	/**
	 * 查询全部的信息
	 * 
	 * @return
	 */
	public List<Resetpass> queryByAll();
}
