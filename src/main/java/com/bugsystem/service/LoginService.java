package com.bugsystem.service;

import com.bugsytem.dto.UserDto;

public interface LoginService {
	public UserDto login(String username,String password);
	

}
