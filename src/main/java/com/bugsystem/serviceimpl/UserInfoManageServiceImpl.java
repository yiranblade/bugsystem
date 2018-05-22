package com.bugsystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugsystem.dao.UserInfoMapper;
import com.bugsystem.dao.UserMapper;
import com.bugsystem.domain.User;
import com.bugsystem.domain.UserInfo;
import com.bugsystem.service.UserInfoManageService;
import com.bugsytem.dto.UserDto;

@Service
public class UserInfoManageServiceImpl implements UserInfoManageService{

	@Autowired
	private UserInfoMapper userInfoDao;
	@Autowired
	private UserMapper userDao;
	
	public boolean addUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		if(userInfoDao.insert(userInfo)!=0){
			return true;
		}
		return false;
	}

	public boolean deleteUserInfoByUserName(String userName) {
		// TODO Auto-generated method stub
		if(userInfoDao.deleteByUserName(userName)!=0){
			return true;
		}
		return false;
	}

	public List<UserDto> getAllUserDto() {
		// TODO Auto-generated method stub
		List<UserInfo> userInfos=userInfoDao.getAllUserInfo();
		List<User> users=userDao.selectAllUser();
		List<UserDto> userDtos=new ArrayList<UserDto>();
		for(int i=0;i<users.size();i++){
			User user=users.get(i);
			for(int j=0;j<userInfos.size();j++){
				UserInfo userInfo=userInfos.get(j);
				if(user.getUserName().equals(userInfo.getUserName())){
					UserDto userDto=new UserDto();
					userDto.setCreateTime(userInfo.getCreateTime());
					userDto.setDepartment(userInfo.getDepartment());
					userDto.setEmail(userInfo.getEmail());
					userDto.setName(userInfo.getName());
					userDto.setRole(user.getRole());
					userDto.setUserId(userInfo.getUserId());
					userDto.setUserName(user.getUserName());
					userDto.setUserPassword(user.getUserPassword());
					userDtos.add(userDto);
				}
			}
		}
		
		return userDtos;
	}

	public boolean deleteUserInfoByUserId(String userName) {
		// TODO Auto-generated method stub
		UserInfo userInfo=userInfoDao.selectByPrimaryKey(userName);
		userInfoDao.deleteByPrimaryKey(userName);
		userDao.deleteByPrimaryKey(userInfo.getUserName());
		return true;
	}

	public UserInfo getUserInfoById(Integer userId) {
		// TODO Auto-generated method stub
		
		return userInfoDao.selectByPrimaryKey(Integer.toString(userId));
	}
	
	
	
}
