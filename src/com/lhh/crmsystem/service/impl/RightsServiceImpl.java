package com.lhh.crmsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhh.crmsystem.dao.IRightsDao;
import com.lhh.crmsystem.entity.Rights;
import com.lhh.crmsystem.service.IRightsService;

@Service("rigService")
public class RightsServiceImpl implements IRightsService {

	@Autowired
	private IRightsDao rigDao;

	@Override
	public List<Rights> queryAll() {
		System.out.println(" +++++queryAll+++++进来了");
		List<Rights> list = new ArrayList<Rights>();
		list = rigDao.queryByAll();
		return list;
	}

	@Override
	public Rights queryById(Integer id) {

		Rights rights;
		rights = rigDao.queryById(id);
		return rights;
	}

}
