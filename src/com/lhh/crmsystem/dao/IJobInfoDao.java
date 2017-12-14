package com.lhh.crmsystem.dao;

import java.util.List;

import com.lhh.crmsystem.entity.JobInfo;

public interface IJobInfoDao {

	/**
	 * 插入一条职位信息
	 * 
	 * @param jobInfo
	 * @return
	 */
	public int insert(JobInfo jobInfo);

	/**
	 * 根据ID来删除一条职位信息
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id);

	/**
	 * 修改职位信息
	 * 
	 * @param jobInfo
	 * @return
	 */
	public JobInfo updateByObj(JobInfo jobInfo);

	/********** 查询 *********/
	/**
	 * 通过ID来查询一条职位信息
	 * 
	 * @param id
	 * @return
	 */
	public JobInfo queryById(Integer id);
	
	public JobInfo queryByJob(String job);

	public List<JobInfo> queryByDept(Integer deptId);

	public JobInfo queryByIdAndDeptId(Integer jobId, Integer deptId);

	/**
	 * 查询全部的信息
	 * 
	 * @return
	 */
	public List<JobInfo> queryByAll();

}
