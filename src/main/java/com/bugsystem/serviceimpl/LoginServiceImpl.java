package com.bugsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugsystem.dao.UserInfoMapper;
import com.bugsystem.dao.UserMapper;
import com.bugsystem.domain.User;
import com.bugsystem.domain.UserInfo;
import com.bugsystem.service.LoginService;
import com.bugsytem.dto.UserDto;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserMapper userDao;
	
	@Autowired
	private UserInfoMapper userInfoDao;
	
	public UserDto login(String username, String password) {
		// TODO Auto-generated method stub
		UserDto userDto=new UserDto();
		User user=userDao.LoginService(username, password);
		UserInfo userInfo=null;
		if(user!=null){
			userInfo=userInfoDao.selectByUserName(user.getUserName());
			userDto.setUserName(user.getUserName());
			userDto.setRole(user.getRole());
			userDto.setDepartment(userInfo.getDepartment());
			userDto.setEmail(userInfo.getEmail());
			userDto.setName(userInfo.getName());
			userDto.setCreateTime(userInfo.getCreateTime());
			userDto.setUserId(userInfo.getUserId());
			return userDto;
		}else{
			return null;
		}
		
		
	}
	
	

}
