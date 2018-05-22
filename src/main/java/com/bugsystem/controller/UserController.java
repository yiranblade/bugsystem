package com.bugsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bugsystem.domain.User;
import com.bugsystem.domain.UserInfo;
import com.bugsystem.util.ResultInfo;
import com.bugsytem.dto.UserDto;

@RestController
public class UserController extends BaseController{
	
	@RequestMapping(value="/user",method=RequestMethod.POST,consumes="application/json")
	public ResultInfo addUser(@RequestBody UserDto userDto){
		ResultInfo resultInfo=new ResultInfo();
		if(userDto!=null){
			User user=new User();
			user.setRole(userDto.getRole());
			user.setUserPassword(userDto.getUserPassword());
			user.setUserName(userDto.getUserName());
			UserInfo userInfo=new UserInfo();
			userInfo.setDepartment(userDto.getDepartment());
			userInfo.setEmail(userDto.getEmail());
			userInfo.setName(userDto.getName());
			userInfo.setUserName(userDto.getUserName());
			userManageService.addUser(user);
			userInfoManageService.addUserInfo(userInfo);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResultInfo login(@RequestParam("userName")String userName,@RequestParam("password")String password){
		ResultInfo resultInfo=new ResultInfo();
		if(userName!=null&&password!=null){
			UserDto userDto=null;
			if((userDto=loginService.login(userName, password))!=null){
				//session.setAttribute("user", user.getUserName()+user.getRole());
				resultInfo.setCode(200);
				resultInfo.setData(userDto);
			}
		}
		return resultInfo;
	}

	@RequestMapping(value="/user",method=RequestMethod.GET)
	public ResultInfo getAllUser(){
		ResultInfo resultInfo=new ResultInfo();
		List<UserDto> users=null;
     	users=userInfoManageService.getAllUserDto();
		if(users!=null){
			resultInfo.setCode(200);
			resultInfo.setData(users);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求错误");
		}
		return resultInfo;
			
	}
	@RequestMapping(value="/user/{userName}",method=RequestMethod.DELETE)
	public ResultInfo deleteUserByUserName(@PathVariable("userName")String userName){
		ResultInfo resultInfo=new ResultInfo();
		if(userName!=null){
			userInfoManageService.deleteUserInfoByUserName(userName);
			resultInfo.setCode(200);
			resultInfo.setData("删除成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	
}
