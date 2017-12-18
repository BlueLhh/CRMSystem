package com.lhh.crmsystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lhh.crmsystem.entity.Custom;
import com.lhh.crmsystem.service.ICustomService;
import com.lhh.crmsystem.uitls.ExcelException;
import com.lhh.crmsystem.uitls.ExcelUtil;
import com.lhh.crmsystem.uitls.LeadToExcel;

@Controller
@RequestMapping("/custom")
public class CustomController {

	@Autowired
	private ICustomService custService;

	// 查询全部客户的信息
	@RequestMapping("/allInfo")
	public void AllInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 当前页数
		String currentPage = request.getParameter("page");
		// 每页显示的条数
		String pageSize = request.getParameter("rows");

		int max = Integer.valueOf(currentPage) * Integer.valueOf(pageSize);
		int min = (Integer.valueOf(currentPage) - 1) * Integer.valueOf(pageSize) + 1;

		int total = custService.queryByCount();

		List<Custom> custList = custService.queryByPage(total, min, max);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);// 总条数
		map.put("rows", custList);// 当前页的数据
		String jsonString = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		response.getWriter().write(jsonString);
	}

	@RequestMapping("/addCustom")
	public String addCustom(Custom custom) {
		// 获取当前的系统时间
		Date date = new Date();
		custom.setCreateDate(date);
		custService.insertCustom(custom);
		return "/view/frame/cust_add.jsp";
	}

	// 在表格上更新客户信息 通过ID进行更新
	@RequestMapping("/updateById")
	public String updateOneCustom(Custom custom, HttpServletRequest request) {
		// 由于时间不能被封装进实体类中，需要分开获取，重新set进客户实体中
		// 因为时间不能由String强转而成（时间戳），故需要将String强转成Long
		Long time = Long.valueOf(request.getParameter("date"));
		// 新建一个时间对象，将Long型强转
		Date date = new Date(time);
		// 将强转的时间set进客户
		custom.setCreateDate(date);
		// 更新客户信息
		custService.updateOneCustom(custom);
		return "/view/frame/cust_update.jsp";
	}

	@RequestMapping("/exportToExcel")
	public String exportToExcel(HttpServletResponse response, @RequestParam(value = "page") String page,
			@RequestParam(value = "rows") String rows) {

		// JSONObject json = new JSONObject();
		LeadToExcel leadToExcel = new LeadToExcel();
		// excel表格的表头，map getLeadToFiledPublicQuestionBank
		LinkedHashMap<String, String> fieldMap = leadToExcel.getLeadToFiledPublicQuestionBank();
		// 表格的名称
		String sheetName = "客户信息表";

		// 要导出的数据 (,)
		ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) custService
				.getCustomInfo((Integer.parseInt(page) - 1) * Integer.parseInt(rows), Integer.parseInt(rows));

		// for (Custom custom : list) {
		// System.out.println(custom);
		// }

		// for (Map<String, Object> map : list) {
		// Set<Entry<String, Object>> entrySet = map.entrySet();
		// for (Entry<String, Object> entry : entrySet) {
		// System.out.println(entry.getKey() + "----------" + entry.getValue());
		// }
		// }

		// 导出
		if (list == null || list.size() == 0) {
			System.out.println("找不到数据！");
		} else {
			// 将list集合转化为excle
			try {
				ExcelUtil.listToExcel(list, fieldMap, sheetName, response);
			} catch (ExcelException e) {
				e.printStackTrace();
			}
		}
		return "/view/frame/cust_export.jsp";
	}
}
