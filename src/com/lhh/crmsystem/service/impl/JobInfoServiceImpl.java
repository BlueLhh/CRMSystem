package com.lhh.crmsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhh.crmsystem.dao.IJobInfoDao;
import com.lhh.crmsystem.entity.JobInfo;
import com.lhh.crmsystem.service.IJobInfoService;

@Service("jobService")
public class JobInfoServiceImpl implements IJobInfoService {

	@Autowired
	private IJobInfoDao jobDao;

	@Override
	public JobInfo queryJobInfo(Integer id) {
		JobInfo jobInfo = jobDao.queryById(id);
		return jobInfo;
	}

	@Override
	public List<JobInfo> queryAll() {
		List<JobInfo> list = new ArrayList<JobInfo>();
		list = jobDao.queryByAll();
		return list;
	}

	@Override
	public int insertJobInfo(JobInfo jobInfo) {
		int rows = jobDao.insert(jobInfo);
		return rows;
	}

	@Override
	public JobInfo queryJobInfo(Integer jobId, Integer deptId) {
		JobInfo info;
		info = jobDao.queryByIdAndDeptId(jobId, deptId);
		return info;
	}

	@Override
	public List<JobInfo> queryByDept(Integer id) {
		List<JobInfo> list = new ArrayList<JobInfo>();
		list = jobDao.queryByDept(id);
		return list;
	}

	@Override
	public JobInfo queryByJob(String job) {
		JobInfo info;
		info = jobDao.queryByJob(job);
		return info;
	}
}
