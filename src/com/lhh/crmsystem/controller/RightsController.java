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

	@SuppressWarnings("unused")
	@RequestMapping("/allInfo")
	public void allInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 当前页数
		String currentPage = request.getParameter("page");
		// 每页显示的条数
		String pageSize = request.getParameter("rows");
		List<Rights> rigList = rigService.queryAll();
		for (Rights rights : rigList) {
			System.out.println(rights);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", 100);// 总条数
		map.put("rows", rigList);// 当前页的数据

		String jsonString = JSON.toJSONString(map);
		System.out.println(jsonString);
		response.getWriter().write(jsonString);
	}

}
