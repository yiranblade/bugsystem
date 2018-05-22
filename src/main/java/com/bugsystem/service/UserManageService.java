package com.bugsystem.service;

import java.util.List;

import com.bugsystem.domain.User;

public interface UserManageService {
	public boolean addUser(User user);
	public boolean deleteUserByUserName(String username);
	public List<User> getAllUser();

}
