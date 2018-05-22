package com.bugsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bugsystem.domain.Project;
import com.bugsystem.util.ResultInfo;

@RestController
public class ProjectController extends BaseController{
	
	@RequestMapping(value="/project",method=RequestMethod.POST,consumes="application/json")
	public ResultInfo addNewProject(@RequestBody Project project){
		ResultInfo resultInfo=new ResultInfo();
		if(project!=null){
			projectManageService.addProject(project);
			resultInfo.setCode(200);
			resultInfo.setData("插入成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求错误");
		}
		return resultInfo;
	}
	@RequestMapping(value="/project/{projectId}",method=RequestMethod.DELETE)
	public ResultInfo deleteProjectById(@PathVariable("projectId")Integer projectId){
		ResultInfo resultInfo=new ResultInfo();
		if(projectId!=0){
			projectManageService.deleteProjectById(projectId);
			resultInfo.setCode(200);
			resultInfo.setData("删除成功");
		}
		else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
			
		return resultInfo;
	}

	@RequestMapping(value="/project",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo updateProject(@RequestBody Project project){
		ResultInfo resultInfo=new ResultInfo();
		if(project!=null){
			projectManageService.updateProject(project);
			resultInfo.setCode(200);
			resultInfo.setData("更新成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求错误");
		}
		return resultInfo;
	}
	@RequestMapping(value="/project",method=RequestMethod.GET)
	public ResultInfo getAllProject(){
		ResultInfo resultInfo=new ResultInfo();
		List<Project> projects=null;
		projects=projectManageService.getAllProject();
		if(projects!=null){
			resultInfo.setCode(200);
			resultInfo.setData(projects);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	
	@RequestMapping(value="/project/{username}",method=RequestMethod.GET)
	public ResultInfo getProjectByUser(@PathVariable("username")String userName){
		ResultInfo resultInfo=new ResultInfo();
		List<Project> projects=null;
		projects=projectManageService.getProjectByCreateUser(userName);
		if(projects!=null){
			resultInfo.setCode(200);
			resultInfo.setData(projects);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
}
