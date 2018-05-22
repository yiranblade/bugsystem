package com.bugsystem.service;

import java.util.List;

import com.bugsystem.domain.Project;

public interface ProjectManageService {
	public boolean addProject(Project project);
	public boolean deleteProjectById(Integer id);
	public boolean updateProject(Project project);
	public List<Project> getAllProject();
	public List<Project> getProjectByCreateUser(String userName);
	
	
}
