package com.lhh.crmsystem.service;

import java.util.List;

import com.lhh.crmsystem.entity.Rights;

public interface IRightsService {

	public Rights queryById(Integer id);

	public List<Rights> queryAll();

	// c查找总条数
	public int queryByCount();

	// 获取分页数据
	public List<Rights> queryByPage(int total, int min, int max);
}
