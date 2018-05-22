package com.bugsystem.service;

import java.util.List;

import com.bugsystem.domain.UserInfo;
import com.bugsytem.dto.UserDto;

public interface UserInfoManageService {
	
	public boolean addUserInfo(UserInfo userInfo);
	public boolean deleteUserInfoByUserName(String userName);
	public List<UserDto> getAllUserDto();
	public boolean deleteUserInfoByUserId(String userName);
	public UserInfo getUserInfoById(Integer userId);
}
