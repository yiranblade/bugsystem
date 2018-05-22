package com.bugsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bugsystem.domain.Document;
import com.bugsystem.util.ResultInfo;

@RestController
public class DocumentController extends BaseController{
	@RequestMapping(value="/document",method=RequestMethod.GET)
	public ResultInfo getAllDocuments(){
		ResultInfo resultInfo=new ResultInfo();
		List<Document> documents=null;
		documents=documentManageService.getAllDocuments();
		if(documents!=null){
			resultInfo.setCode(200);
			resultInfo.setData(documents);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	@RequestMapping(value="/document/{projectId}",method=RequestMethod.GET)
	public ResultInfo getDocumentByProject(@PathVariable("projectId")Integer projectId){
		ResultInfo resultInfo=new ResultInfo();
		if(projectId!=null){
			List<Document> documents=null;
			documents=documentManageService.getDocumentByProjectId(projectId);
			resultInfo.setCode(200);
			resultInfo.setData(documents);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
}
