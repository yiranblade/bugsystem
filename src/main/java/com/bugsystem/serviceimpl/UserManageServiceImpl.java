package com.bugsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugsystem.dao.UserMapper;
import com.bugsystem.domain.User;
import com.bugsystem.service.UserManageService;

@Service
public class UserManageServiceImpl implements UserManageService{

	@Autowired
	private UserMapper userMapper;
	
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		if(userMapper.insert(user)!=0){
			return true;
		}
			
		return false;
	}

	public boolean deleteUserByUserName(String username){
		// TODO Auto-generated method stub
		if(userMapper.deleteByPrimaryKey(username)!=0){
			return true;
		}
		return false;
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> users=userMapper.selectAllUser();
		return users;
	}
	
	

}
