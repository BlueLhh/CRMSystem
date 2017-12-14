package com.lhh.crmsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhh.crmsystem.dao.IResetpassDao;
import com.lhh.crmsystem.entity.Resetpass;
import com.lhh.crmsystem.service.IResetpassService;

@Service("resetService")
public class ResetpassServiceImpl implements IResetpassService {

	@Autowired
	private IResetpassDao restDao;

	@Override
	public int insert(Resetpass resetpass) {
		int rows = restDao.insert(resetpass);
		return rows;
	}
}
