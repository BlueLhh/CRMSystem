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
	@RequestMapping("/allInfo")
	public void allInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 当前页数
		String currentPage = request.getParameter("page");
		// 每页显示的条数
		String pageSize = request.getParameter("rows");

		int max = Integer.valueOf(currentPage) * Integer.valueOf(pageSize);
		int min = (Integer.valueOf(currentPage) - 1) * Integer.valueOf(pageSize) + 1;

		// 获取总条数
		int rows = empService.queryByCount();
		List<Employee> empList = empService.queryByPage(rows, min, max);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", rows);// 总条数
		map.put("rows", empList);// 当前页的数据
		String jsonString = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		response.getWriter().write(jsonString);
	}

	// 查询全部管理员
	@SuppressWarnings("unused")
	// @RequestMapping("/allAdmin")
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", 100);// 总条数
		map.put("rows", empList);// 当前页的数据
		String jsonString = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		response.getWriter().write(jsonString);
	}

	// 查询销售人员
	// @RequestMapping("/sale")
	public void sale(Employee employee, HttpServletResponse response) throws IOException {
		// 查询销售员工
		int jobId = 9;
		JobInfo job = jobService.queryJobInfo(jobId);
		employee.setJobInfoId(job);
		List<Employee> empList = empService.queryManyByObj(employee);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", 100);// 总条数
		map.put("rows", empList);// 当前页的数据
		String jsonString = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		response.getWriter().write(jsonString);
	}

	// 查询所有的咨询员工
	// @RequestMapping("/consult")
	public void consult(Employee employee, HttpServletResponse response) throws IOException {
		int jobId = 3;
		JobInfo job = jobService.queryJobInfo(jobId);
		employee.setJobInfoId(job);
		List<Employee> empList = empService.queryManyByObj(employee);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", 100);// 总条数
		map.put("rows", empList);// 当前页的数据
		String jsonString = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		response.getWriter().write(jsonString);
	}

	// 条件查询
	@RequestMapping("/findEmp")
	public void tesfindEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 获取从页面上穿过来的职位ID
		Integer jobId = Integer.valueOf(request.getParameter("jobId"));
		// 获取当前页数
		Integer page = Integer.valueOf(request.getParameter("page"));
		// 每页显示的条数
		Integer rows = Integer.valueOf(request.getParameter("rows"));

		// 用Map保存条件
		Map<String, Object> condition = new HashMap<String, Object>();
		// 判断当位置ID不为空的时候，就添加进map 不为空则按照职位ID查询相关员工
		// 否则设置为0 即为查询全部的员工
		if (jobId != null && !"".equals(jobId)) {
			condition.put("jobId", jobId);
		} else {
			condition.put("jobId", 0);
		}
		// 把起始页和最后一页的条件存到map中
		condition.put("start", (page - 1) * rows + 1);
		condition.put("end", rows * page);

		// 通过条件查询员工
		List<Employee> empList = empService.page(condition);
		// 通过条件查询满足该条件的员工总数
		int count = empService.count(condition);
		// 存入map通过JSON传到jsp页面
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", empList);

		String empJSON = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		response.getWriter().write(empJSON);
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
			employee.setPass("123");
			employee.setId(id);
			empService.updateEmployeeByObj(employee);

			String username = employee.getUsername();
			String phoneNo = employee.getPhoneNo();
			Resetpass resetpass = new Resetpass();
			resetpass.setUsername(username);
			resetpass.setPhoneNo(phoneNo);
			resetService.insert(resetpass);
			return "/view/frame/reset_pass.jsp";
		}
	}

	// 删除员工
	@RequestMapping("/deleteEmp")
	public String deleteEmp(HttpServletRequest request) {
		// 从页面上获取的员工ID
		// int empId = Integer.parseInt(request.getParameter("empId"));
		int id = (int) request.getSession().getAttribute("empId");
		String op = request.getParameter("op");
		if (op.equals("deleteAdmin")) {
			empService.deleteEmployee(id);
			System.out.println("删除的是管理员！");
			return "/view/frame/admin_delete.jsp";
		} else {
			// 更新员工的状态
			String stuts = "0";
			empService.updateByIdAndStuts(stuts, id);
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