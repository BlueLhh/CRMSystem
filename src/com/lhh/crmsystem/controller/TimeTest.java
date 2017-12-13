package com.lhh.crmsystem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// 1513100808000
		Date date = new Date();
		System.out.println("当前的系统时间为：" + date);
		// 转成字符串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		System.out.println("当前的系统时间为：" + time);
		Long longTime = date.getTime();
		System.out.println("------------->" + longTime);
		Date ss = new Date(longTime);
		System.out.println("ssssssssssssss:"+ss.toString());
		// 将时间戳转成Date型
		long lt = new Long("1513100808000");
		Date lastTime = new Date(lt);
		System.out.println(lastTime.getYear()+1900);
		System.out.println(lastTime.getMonth()+1);
		System.out.println(lastTime.getDate());
		System.out.println(lastTime.getHours());
		System.out.println(lastTime.getMinutes());
		System.out.println(lastTime.getSeconds());
		System.out.println((lastTime.getYear()+1900)+"-"+(lastTime.getMonth()+1)+"-"+lastTime.getDate());
		String str = sdf.format(lastTime);
		System.out.println("---------->" + str);

	}
}
