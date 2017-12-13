package com.lhh.crmsystem.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lhh.crmsystem.entity.Custom;
import com.lhh.crmsystem.service.ICustomService;

@Controller
@RequestMapping("/custom")
public class CustomController {

	@Autowired
	private ICustomService custService;

	// 查询全部客户的信息
	@SuppressWarnings("unused")
	@RequestMapping("/allInfo")
	public void AllInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 当前页数
		String currentPage = request.getParameter("page");
		// 每页显示的条数
		String pageSize = request.getParameter("rows");
		List<Custom> custList = custService.queryAll();
		for (Custom custom : custList) {
			System.out.println(custom);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", 100);// 总条数
		map.put("rows", custList);// 当前页的数据
		String jsonString = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		response.getWriter().write(jsonString);
	}

	@RequestMapping("/addCustom")
	public String addCustom(Custom custom) {
		// 获取当前的系统时间
		Date date = new Date();
		custom.setCreateDate(date);
		System.out.println(custom);
		custService.insertCustom(custom);
		System.out.println("插入成功！");
		return "/view/frame/cust_add.jsp";
	}
}
