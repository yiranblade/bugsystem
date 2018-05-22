package com.bugsystem.service;

import java.util.List;

import com.bugsystem.domain.Bug_user;

public interface ArrangeBugService {
	public boolean arrangeBugByUserName(Integer bugId,Integer userId);
	public List<Bug_user> getAllArrange();
	

}
