package com.lhh.crmsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lhh.crmsystem.entity.Department;
import com.lhh.crmsystem.entity.Employee;
import com.lhh.crmsystem.entity.JobInfo;
import com.lhh.crmsystem.entity.Resetpass;
import com.lhh.crmsystem.service.IDepartmentService;
import com.lhh.crmsystem.service.IEmployeeService;
import com.lhh.crmsystem.service.IJobInfoService;
import com.lhh.crmsystem.service.IResetpassService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService empService;
	@Autowired
	private IDepartmentService deptService;
	@Autowired
	private IJobInfoService jobService;
	@Autowired
	private IResetpassService resetService;

	// 登录验证
	@RequestMapping("/login")
	public String login(String username, String pass, HttpServletRequest request, HttpServletResponse response) {
		Employee employee = empService.login(username, pass);
		HttpSession session = request.getSession();
		session.setAttribute("employee", employee);
		String job = null;// 获取工作职位
		if (employee != null) {
			job = employee.getJobInfoId().getJob().trim();
			session.setAttribute("job", job);
			List<JobInfo> jobList = jobService.queryAll();
			List<Department> deptList = deptService.queryAll();
			session.setAttribute("jobInfo", jobList);
			session.setAttribute("department", deptList);
			if ("1".equals(employee.getWorkStatu())) {
				// 当登录的是超级管理员的时候，在登录的时候就加载部门和职位的信息
				return "/view/frame/main.jsp";
			} else {
				try {
					PrintWriter out = response.getWriter();
					response.setContentType("text/html;charset=utf-8");
					out.flush();
					out.println("<script>javascript:alert('用户未激活或已离职！');history.back();</script>");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return "/login.jsp";
			}
		} else {
			try {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html;charset=utf-8");
				out.flush();
				out.println("<script>javascript:alert('账号或密码错误！请重新输入！');history.back();</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "/login.jsp";
		}
	}

	// 退出
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {

		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return "/login.jsp";
	}

	// 查询全部信息
	@SuppressWarnings("unused")
	@RequestMapping("/allInfo")
	public void allInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 当前页数
		String currentPage = request.getParameter("page");
		// 每页显示的条数
		String pageSize = request.getParameter("rows");
		List<Employee> empList = empService.queryAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", 100);// 总条数
		map.put("rows", empList);// 当前页的数据
		String jsonString = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		response.getWriter().write(jsonString);
	}

	// 查询全部管理员
	@SuppressWarnings("unused")
	@RequestMapping("/allAdmin")
	public void allAdmin(Employee employee, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 查询管理员
		int jobId = 2;
		JobInfo job = jobService.queryJobInfo(jobId);
		employee.setJobInfoId(job);
		// 当前页数
		String currentPage = request.getParameter("page");
		// 每页显示的条数
		String pageSize = request.getParameter("rows");
		List<Employee> empList = empService.queryManyByObj(employee);
		for (Employee emp : empList) {
			System.out.println(emp);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", 100);// 总条数
		map.put("rows", empList);// 当前页的数据
		String jsonString = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		response.getWriter().write(jsonString);
	}

	// 添加管理员
	@RequestMapping("/adminAdd")
	public String adminAdd(Employee employee) {
		// 查询部门和职位
		JobInfo job = jobService.queryJobInfo(2);
		Department dept = deptService.queryDepartment(1);
		employee.setWorkStatu("1");
		employee.setJobInfoId(job);
		employee.setDepartmentId(dept);
		empService.insertAdmin(employee);
		return "/view/frame/admin_add.jsp";
	}

	// 新增一名普通用户
	@RequestMapping("/empAdd")
	public String empAdd(Employee employee, HttpServletRequest request) {
		// 获取部门ID
		int deptId = Integer.parseInt(request.getParameter("dept"));
		// 获取职位ID
		String jobName = request.getParameter("job").trim();
		// 通过职位去查询一个职位对象
		JobInfo jobInfo = jobService.queryByJob(jobName);
		Department dept = deptService.queryDepartment(deptId);
		employee.setJobInfoId(jobInfo);
		employee.setDepartmentId(dept);
		employee.setWorkStatu("1");
		empService.insertEmployee(employee);
		return "/view/frame/emp_add.jsp";
	}

	// 将一个员工更改为管理员
	@RequestMapping("/updateEmp")
	public String updateEmp(Employee employee, HttpServletRequest request) {

		String op = request.getParameter("op");
		int id = (int) request.getSession().getAttribute("empId");
		// 如果从页面传回来的值是 updateAdmin 则进行管理员的增加 resetPass 则是重置密码
		if (op.equals("updateAdmin")) {
			JobInfo job = jobService.queryJobInfo(2);
			Department dept = deptService.queryDepartment(1);
			employee.setWorkStatu("1");
			employee.setJobInfoId(job);
			employee.setDepartmentId(dept);
			employee.setId(id);
			empService.updateEmployeeByObj(employee);
			return "/view/frame/admin_add.jsp";
		} else {
			// 重置面 op = resetPass //重置密码为初始密码为 123
			String pass = employee.getPass();
			System.out.println("pass++++++++++++++" + pass);
			employee.setPass("123");
			employee.setId(id);
			empService.updateEmployeeByObj(employee);
			System.out.println("重置密码成功！将密码记录在重置表格中！");

			String username = employee.getUsername();
			String phoneNo = employee.getPhoneNo();
			System.out.println(username + "++++++++++++++" + phoneNo);
			Resetpass resetpass = new Resetpass();
			resetpass.setUsername(username);
			resetpass.setPhoneNo(phoneNo);
			resetService.insert(resetpass);
			System.out.println("插入重置密码表成功！");
			return "/view/frame/reset_pass.jsp";
		}
	}

	// 删除员工
	@RequestMapping("/deleteEmp")
	public String deleteEmp(HttpServletRequest request) {
		// 从页面上获取的员工ID
		// int empId = Integer.parseInt(request.getParameter("empId"));
		int id = (int) request.getSession().getAttribute("empId");
		empService.deleteEmployee(id);
		String op = request.getParameter("op");
		if (op.equals("deleteAdmin")) {
			System.out.println("删除的是管理员！");
			return "/view/frame/admin_delete.jsp";
		} else {
			System.out.println("删除的是普通员工！");
			return "/view/frame/emp_delete.jsp";
		}
	}

	// 条件查询员工
	@RequestMapping("/findEmployeeByAjax")
	public void findEmployeeByAjax(Employee employee, String name, HttpServletRequest request,
			HttpServletResponse resp) {
		// 判断 如果是数值型则转成通过ID查询员工，否则通过真实姓名查询\
		String data = name.trim();
		try {
			Integer valueOf = Integer.valueOf(data);
			employee.setId(valueOf);
		} catch (Exception e) {
			employee.setRealname(data);
		}
		Employee emp = new Employee();
		emp = empService.queryOneByObj(employee);
		System.out.println(emp);
		// 如果找不到员工 则弹出提示语 测试失败
		if (emp == null) {
			try {
				PrintWriter out = resp.getWriter();
				resp.setContentType("text/html;charset=utf-8");
				out.flush();
				out.println("<script>javascript:alert('找不到该员工！请重新输入！');history.back();</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// 转成JSON
			String jsonStr = JSON.toJSONString(emp);

			// 保存ID
			HttpSession session = request.getSession(false);
			session.setAttribute("empId", emp.getId());

			try {
				resp.getWriter().write(jsonStr);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}