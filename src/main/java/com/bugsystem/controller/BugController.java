package com.bugsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bugsystem.domain.Bug;
import com.bugsystem.domain.Bug_user;
import com.bugsystem.util.ResultInfo;

@RestController
public class BugController extends BaseController{

	@RequestMapping(value="/bug",method=RequestMethod.POST,consumes="application/json")
	public ResultInfo addBug(@RequestBody Bug bug){
		ResultInfo resultInfo=new ResultInfo();
		if(bug!=null){
			bugService.addBug(bug);
			resultInfo.setCode(200);
			resultInfo.setData("增加成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
		
	}
	@RequestMapping(value="/bug",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo updateBug(@RequestBody Bug bug){
		ResultInfo resultInfo=new ResultInfo();
		if(bug!=null){
			bugService.updateBug(bug);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		
		return resultInfo;
	}
	@RequestMapping(value="/bug",method=RequestMethod.GET)
	public ResultInfo getAllBug(){
		ResultInfo resultInfo=new ResultInfo();
		List<Bug> bugs=null;
		if((bugs=bugService.getAllBug())!=null){
			resultInfo.setCode(200);
			resultInfo.setData(bugs);
			
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求错误");
		}
		return resultInfo;
	}
	@RequestMapping(value="/bug/user/{userId}",method=RequestMethod.GET)
	public ResultInfo getBugByUserId(@PathVariable("userId")Integer userId){
		ResultInfo resultInfo=new ResultInfo();
		List<Bug> bugs=bugService.getBugByUserId(userId);
		if(bugs!=null){
			resultInfo.setCode(200);
			resultInfo.setData(bugs);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求错误");
		}
		return resultInfo;
	}
	@RequestMapping(value="/bug/project/{projectId}",method=RequestMethod.GET)
	public ResultInfo getByProjectId(@PathVariable("projectId")Integer projectId){
		ResultInfo resultInfo=new ResultInfo();
		List<Bug> bugs=null;
		bugs=bugService.getBugByProject(projectId);
		if(bugs!=null){
			resultInfo.setCode(200);
			resultInfo.setData(bugs);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求错误");
		}
		
		return resultInfo;
	}
	@RequestMapping(value="/bug/arrange/{bugId}&{userId}",method=RequestMethod.GET)
	public ResultInfo arrangeBug(@PathVariable("bugId")Integer bugId,@PathVariable("userId")Integer userId){
		ResultInfo resultInfo=new ResultInfo();
		if(bugId!=null&&userId!=null){
			if(arrangeBugService.arrangeBugByUserName(bugId, userId)){
				resultInfo.setCode(200);
				resultInfo.setData("请求成功");
			}
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	
	@RequestMapping(value="/bug/arrange/all",method=RequestMethod.GET)
	public ResultInfo getAllArrange(){
		ResultInfo resultInfo=new ResultInfo();
		List<Bug_user> bugUser=null;
		if((bugUser=arrangeBugService.getAllArrange())!=null){
				resultInfo.setCode(200);
				resultInfo.setData(bugUser);
			
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	
}
