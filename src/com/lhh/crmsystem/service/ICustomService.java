package com.lhh.crmsystem.service;

import java.util.List;
import java.util.Map;

import com.lhh.crmsystem.entity.Custom;

public interface ICustomService {

	public int insertCustom(Custom custom);

	List<Custom> queryAll();

	public int queryByCount();

	public List<Custom> queryByPage(int total, int min, int max);

	public List<Map<String,Object>> getCustomInfo(int min, int max);

	public int updateOneCustom(Custom custom);

}
