package com.lhh.crmsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		jobService.insertJobInfo(jobInfo);
		return "/view/frame/job_add.jsp";
	}

	// 通过职位的ID来查询部门
	/*@RequestMapping("/dept")
	@ResponseBody
	public void findDept(JobInfo jobInfo, String name, HttpServletRequest request, HttpServletResponse resp)
			throws IOException {
		// 获取从JSP页面传来的数据
		String data = name.trim();
		// 强转成integer型
		Integer id = Integer.valueOf(data);
		jobInfo = jobService.queryJobInfo(id);
		System.out.println(jobInfo);
		System.out.println(jobInfo.getDepartmentId().getDname());
		String jsonStr = JSON.toJSONString(jobInfo);
		resp.getWriter().write(jsonStr);
	}*/

	// 通过部门来查询职位
	@RequestMapping("/job")
	@ResponseBody
	public List<JobInfo> findJob(String name) {
		// 获取从JSP页面传来的数据
		String data = name.trim();
		// 强转成integer型
		Integer id = Integer.valueOf(data);
		List<JobInfo> jobList = new ArrayList<JobInfo>();
		jobList = jobService.queryByDept(id);
		List<JobInfo> jobs = new ArrayList<JobInfo>();
		for (JobInfo jobInfo : jobList) {
			JobInfo job = new JobInfo();
			job.setJob(jobInfo.getJob());
			jobs.add(job);
		}
		return jobs;
	}
}
