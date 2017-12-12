package com.lhh.crmsystem.service.impl;

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
}
