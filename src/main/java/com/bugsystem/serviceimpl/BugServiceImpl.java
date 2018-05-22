package com.bugsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugsystem.dao.BugMapper;
import com.bugsystem.domain.Bug;
import com.bugsystem.service.BugService;

@Service
public class BugServiceImpl implements BugService{

	@Autowired
	private BugMapper bugMapper;
	
	public boolean addBug(Bug bug) {
		// TODO Auto-generated method stub
		if(bugMapper.insert(bug)!=0)
			return true;
		return false;
	}

	public List<Bug> getAllBug() {
		// TODO Auto-generated method stub
		List<Bug> bugs=bugMapper.getAllBug();
		
		return bugs;
	}

	public List<Bug> getBugByUserId(Integer userId) {
		// TODO Auto-generated method stub
		List<Bug> bugs=bugMapper.getBugByUserId(userId);
		return bugs;
	}

	public List<Bug> getBugByProject(Integer projectId) {
		// TODO Auto-generated method stub
		List<Bug> bugs=bugMapper.getBugByProjectId(projectId);
		return bugs;
	}

	public boolean updateBug(Bug bug) {
		// TODO Auto-generated method stub
		if(bugMapper.updateByPrimaryKeySelective(bug)!=0)
			return true;
		return false;
	}
	
		

}
