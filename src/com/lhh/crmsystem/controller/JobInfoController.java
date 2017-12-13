package com.lhh.crmsystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhh.crmsystem.entity.Department;
import com.lhh.crmsystem.entity.JobInfo;
import com.lhh.crmsystem.service.IDepartmentService;
import com.lhh.crmsystem.service.IJobInfoService;

@Controller
@RequestMapping("/jobInfo")
public class JobInfoController {

	@Autowired
	private IJobInfoService jobService;
	@Autowired
	private IDepartmentService deptService;

	@RequestMapping("/addJob")
	public String addJob(JobInfo jobInfo, HttpServletRequest request) {
		int deptId = Integer.parseInt(request.getParameter("dept"));
		Department dept = deptService.queryDepartment(deptId);
		jobInfo.setDepartmentId(dept);
		System.out.println(jobInfo);
		jobService.insertJobInfo(jobInfo);
		System.out.println("插入成功！");
		return "/view/frame/job_add.jsp";
	}
}
