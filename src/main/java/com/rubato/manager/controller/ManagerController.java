package com.rubato.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManagerController {
	
	// 관리자 메인페이지 화면 (managerMain.jsp) 보이게 하는 메소드
	@RequestMapping(value = "/manager/mainView", method = RequestMethod.GET)
	public String mainView() {
		return "manager/managerMain";
	}
	
	

}
