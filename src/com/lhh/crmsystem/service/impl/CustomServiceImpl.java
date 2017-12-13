package com.lhh.crmsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhh.crmsystem.dao.ICustomDao;
import com.lhh.crmsystem.entity.Custom;
import com.lhh.crmsystem.service.ICustomService;

@Service("custService")
public class CustomServiceImpl implements ICustomService {

	@Autowired
	private ICustomDao custDao;

	@Override
	public List<Custom> queryAll() {
		List<Custom> cusList = new ArrayList<Custom>();
		cusList = custDao.queryByAll();
		return cusList;
	}

	@Override
	public int insertCustom(Custom custom) {
		System.out.println(custom);
		int rows = custDao.insert(custom);
		System.out.println("rows:" + rows);
		System.out.println("custom:" + custom);
		return rows;
	}

}
