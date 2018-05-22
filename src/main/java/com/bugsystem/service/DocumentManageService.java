package com.bugsystem.service;

import java.util.List;

import com.bugsystem.domain.Document;

public interface DocumentManageService {
	public boolean upLoadFiles(List<Document> documents);
	public List<Document> getAllDocuments();
	public List<Document> getDocumentByProjectId(Integer id);
	public Document getDocumentById(Integer documId);
	

}
