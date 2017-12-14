package com.lhh.crmsystem.test.cust;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lhh.crmsystem.dao.ICustomDao;
import com.lhh.crmsystem.entity.Custom;
import com.lhh.crmsystem.service.ICustomService;
import com.lhh.crmsystem.service.impl.CustomServiceImpl;

public class AddCustTest {
	private static SqlSession session;

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {

		Reader reader = Resources.getResourceAsReader("applicationContext.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(reader);
		session = factory.openSession();

		ICustomDao dao = session.getMapper(ICustomDao.class);
		
		ICustomService custSerice = new CustomServiceImpl();
		Custom custom = new Custom();
		custom.setName("姗姗");
		custom.setEducation("本科");
		custom.setPhoneNo("15296383310");
		custom.setQq(123456789);
		custom.setEmail("123456789@qq.com");
		custom.setCustomStatu("1");
		Date date = new Date();
		custom.setCreateDate(date);
		custom.setInviteName("小花");

		int rows = custSerice.insertCustom(custom);
		System.out.println("成功插入" + rows + "条信息");
	}
}
