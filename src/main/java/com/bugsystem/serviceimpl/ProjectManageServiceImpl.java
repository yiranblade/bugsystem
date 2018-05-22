package com.bugsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugsystem.dao.ProjectMapper;
import com.bugsystem.domain.Project;
import com.bugsystem.service.ProjectManageService;

@Service
public class ProjectManageServiceImpl implements ProjectManageService{

	@Autowired
	private ProjectMapper projectDao;
	
	public boolean addProject(Project project) {
		// TODO Auto-generated method stub
		if(projectDao.insertSelective(project)!=0)
			return true;
		return false;
	}

	public boolean deleteProjectById(Integer id) {
		// TODO Auto-generated method stub
		if(projectDao.deleteByPrimaryKey(id)!=0){
			return true;
		}
		return false;
	}

	public boolean updateProject(Project project) {
		// TODO Auto-generated method stub
		if(projectDao.updateByPrimaryKeySelective(project)!=0)
			return true;
		return false;
	}

	public List<Project> getAllProject() {
		// TODO Auto-generated method stub
		List<Project> projects=projectDao.selectAllProject();
		return projects;
	}

	public List<Project> getProjectByCreateUser(String userName) {
		// TODO Auto-generated method stub
		List<Project> projects=projectDao.selectProjectByUserName(userName);
		return projects;
	}
	
	

}
