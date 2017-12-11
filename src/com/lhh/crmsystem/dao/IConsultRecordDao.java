package com.lhh.crmsystem.dao;

import java.util.List;

import com.lhh.crmsystem.entity.ConsultRecord;

public interface IConsultRecordDao {

	/**
	 * 增
	 * 
	 * @param consultRecord
	 * @return
	 */
	public int insert(ConsultRecord consultRecord);

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
	 * @param consultRecord
	 * @return
	 */
	public ConsultRecord updateByObj(ConsultRecord consultRecord);

	/**
	 * 查
	 * 
	 * @param id
	 * @return
	 */
	public ConsultRecord queryById(Integer id);

	/**
	 * 查询全部的信息
	 * 
	 * @return
	 */
	public List<ConsultRecord> queryByAll();
}
