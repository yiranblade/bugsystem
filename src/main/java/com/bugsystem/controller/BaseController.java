package com.bugsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bugsystem.service.ArrangeBugService;
import com.bugsystem.service.BugService;
import com.bugsystem.service.DocumentManageService;
import com.bugsystem.service.LoginService;
import com.bugsystem.service.ProjectManageService;
import com.bugsystem.service.UserInfoManageService;
import com.bugsystem.service.UserManageService;

public class BaseController {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	
	@Autowired
	protected ArrangeBugService arrangeBugService;
	@Autowired
	protected BugService bugService;
	@Autowired
	protected DocumentManageService documentManageService;
	@Autowired
	protected LoginService loginService;
	@Autowired
	protected ProjectManageService projectManageService;
	@Autowired
	protected UserInfoManageService userInfoManageService;
	@Autowired
	protected UserManageService userManageService;
	
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		this.request = request;
		this.response = response;
		this.session = request.getSession();
			
	}

}
