package com.lhh.crmsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhh.crmsystem.service.IRightsService;


@Controller
@RequestMapping("/rights")
public class RightsController {

	@Autowired
	private IRightsService rigService;
	
}
