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
}
