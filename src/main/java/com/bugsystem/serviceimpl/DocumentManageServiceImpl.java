package com.bugsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugsystem.dao.DocumentMapper;
import com.bugsystem.domain.Document;
import com.bugsystem.service.DocumentManageService;

@Service
public class DocumentManageServiceImpl implements DocumentManageService{

	@Autowired
	private DocumentMapper documentDao; 
	
	public boolean upLoadFiles(List<Document> documents) {
		// TODO Auto-generated method stub
		for(int i=0;i<documents.size();i++){
			documentDao.insertSelective(documents.get(i));
		}
		return true;
	}

	public List<Document> getAllDocuments() {
		// TODO Auto-generated method stub
		List<Document> documents=documentDao.getAllDocuments();
		return documents;
	}

	public List<Document> getDocumentByProjectId(Integer id) {
		// TODO Auto-generated method stub
		List<Document> documents=documentDao.getDocumentByProjectId(id);
		return documents;
	}

	public Document getDocumentById(Integer documId) {
		// TODO Auto-generated method stub
		Document document=null;
		if((document=documentDao.selectByPrimaryKey(documId))!=null)
			return document;
		return document;
	}
	
	
	
	

}
