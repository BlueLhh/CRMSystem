package com.lhh.crmsystem.dao;

import java.util.List;

import com.lhh.crmsystem.entity.JobRight;

public interface IJobRightDao {
	/**
	 * 增
	 * 
	 * @param customInfo
	 * @return
	 */
	public int insert(JobRight jobRight);

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
	public JobRight updateByObj(JobRight jobRight);

	/**
	 * 查
	 * 
	 * @param id
	 * @return
	 */
	public JobRight queryById(Integer id);

	/**
	 * 查询全部的信息
	 * 
	 * @return
	 */
	public List<JobRight> queryByAll();
}
