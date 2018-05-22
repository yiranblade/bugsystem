package com.bugsystem.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bugsystem.domain.Document;
import com.bugsystem.util.ResultInfo;

@RestController
public class UploadController extends BaseController{
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public ResultInfo upLoadDocument(@RequestParam("files") MultipartFile[] files,@RequestParam("projectId")Integer projectId){
		ResultInfo resultInfo=new ResultInfo();
		if(files!=null&&projectId!=null){
			List<Document> documents=new ArrayList<Document>();
			try{
			
				String temp=null;
				String fileName=null;
				for(int i=0;i<files.length;i++){
					fileName=new String(files[i].getOriginalFilename().getBytes("ISO-8859-1"), "UTF-8"); 
					Document document=new Document();
					temp=UploadController.class.getResource("/").getPath()+fileName;
					FileUtils.writeByteArrayToFile(new File(temp), files[i].getBytes());
					document.setProjectId(projectId);
					document.setDocumUrl(temp);
					document.setDocumType(files[i].getContentType());
					documents.add(document);
			
				}
				documentManageService.upLoadFiles(documents);
			}catch(IOException e){
				e.printStackTrace();
			}
			resultInfo.setCode(200);
			resultInfo.setData("上传成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}

}
