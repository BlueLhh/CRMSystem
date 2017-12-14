package com.lhh.crmsystem.service;

import java.util.List;

import com.lhh.crmsystem.entity.Rights;

public interface IRightsService {

	public Rights queryById(Integer id);

	public List<Rights> queryAll();
}
