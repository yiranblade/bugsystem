package com.bugsystem.service;

import java.util.List;

import com.bugsystem.domain.Bug;

public interface BugService {
	public boolean addBug(Bug bug);
	public boolean updateBug(Bug bug);
	public List<Bug> getAllBug();
	public List<Bug> getBugByUserId(Integer userId);
	public List<Bug> getBugByProject(Integer projectId);
	
}
