package com.bugsystem.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bugsystem.domain.Document;
import com.bugsystem.util.ResultInfo;
import com.bugsytem.dto.DownloadRecord;

@RestController
public class DownloadController extends BaseController{
	@RequestMapping(value="/download/{documId}",method=RequestMethod.GET)
	public ResultInfo download(@PathVariable("documId")Integer documId) 
			throws Exception {
				ResultInfo resultInfo=new ResultInfo();
			    //声明本次下载状态的记录对象
				Document document=documentManageService.getDocumentById(documId);
				String[] fileNames=document.getDocumUrl().split("/");
				int count=fileNames.length-1;
				String fileName=fileNames[count];
				String filePath=document.getDocumUrl();
			    DownloadRecord downloadRecord = new DownloadRecord(fileName, filePath, request);
			    //设置响应头和客户端保存文件名
			    response.setCharacterEncoding("utf-8");
			    response.setContentType("multipart/form-data");
			    response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
			    //用于记录以完成的下载的数据量，单位是byte
			    long downloadedLength = 0l;
			    try {
			        //打开本地文件流
			        InputStream inputStream = new FileInputStream(filePath);
			        //激活下载操作
			        OutputStream os = response.getOutputStream();

			        //循环写入输出流
			        byte[] b = new byte[2048];
			        int length;
			        while ((length = inputStream.read(b)) > 0) {
			            os.write(b, 0, length);
			            downloadedLength += b.length;
			        }

			        // 这里主要关闭。
			        os.close();
			        inputStream.close();
			    } catch (Exception e){
			        downloadRecord.setStatus(DownloadRecord.STATUS_ERROR);
			        throw e;
			    }
			    downloadRecord.setStatus(DownloadRecord.STATUS_SUCCESS);
			    downloadRecord.setEndTime(new Timestamp(System.currentTimeMillis()));
			    downloadRecord.setLength(downloadedLength);
			    //存储记录
			    resultInfo.setCode(200);
			    resultInfo.setData(downloadRecord);
			    return resultInfo;
			}

}
