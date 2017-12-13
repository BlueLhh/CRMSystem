package com.lhh.crmsystem.service;

import java.util.List;

import com.lhh.crmsystem.entity.JobInfo;

public interface IJobInfoService {

	public int insertJobInfo(JobInfo jobInfo);

	public JobInfo queryJobInfo(Integer id);

	public List<JobInfo> queryAll();

}
