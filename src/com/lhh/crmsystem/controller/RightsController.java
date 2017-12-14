package com.lhh.crmsystem.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.lhh.crmsystem.entity.Rights;
import com.lhh.crmsystem.service.IRightsService;

@Controller
@RequestMapping("/rights")
public class RightsController {

	@Autowired
	private IRightsService rigService;

	@RequestMapping("/allInfo")
	public void allInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 当前页数
		String currentPage = request.getParameter("page");//1
		// 每页显示的条数
		String pageSize = request.getParameter("rows");//5

		int max = Integer.valueOf(currentPage) * Integer.valueOf(pageSize);
		int min = (Integer.valueOf(currentPage) - 1) * Integer.valueOf(pageSize) + 1;

		// 获取总条数
		int total = rigService.queryByCount();
		List<Rights> rigList = rigService.queryByPage(total, min, max);
		// List<Rights> rigList = rigService.queryAll();
		// for (Rights rights : rigList) {
		// System.out.println(rights);
		// }
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);// 总条数
		map.put("rows", rigList);// 当前页的数据

		String jsonString = JSON.toJSONString(map);
		response.getWriter().write(jsonString);
	}

}
