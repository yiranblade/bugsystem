package com.bugsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugsystem.dao.Bug_userMapper;
import com.bugsystem.domain.Bug_user;
import com.bugsystem.domain.UserInfo;
import com.bugsystem.service.ArrangeBugService;
import com.bugsystem.service.UserInfoManageService;
import com.bugsytem.dto.Email;

@Service
public class ArrangeBugServiceImpl implements ArrangeBugService{

	@Autowired
	private Bug_userMapper bug_userDao;
	
	@Autowired
	private UserInfoManageService userInfoDao;
	
	@Autowired
	private ApplicationMailer mailSender;
	
	public boolean arrangeBugByUserName(Integer bugId, Integer userId) {
		// TODO Auto-generated method stub
		Bug_user bugUser=new Bug_user();
		bugUser.setBugId(bugId);
		bugUser.setUserId(userId);
		if(bug_userDao.insertSelective(bugUser)!=0){
			sendEmailByUserId(userId);
			return true;
		}
		return false;
	}

	public List<Bug_user> getAllArrange() {
		// TODO Auto-generated method stub
		List<Bug_user> bugUser=bug_userDao.selectAll();
		if(bugUser!=null){
			return bugUser;
		}
		return null;
	}
	private String sendEmailByUserId(Integer id) {
	        // TODO Auto-generated method stub
	        UserInfo userInfo=new UserInfo();
	        
	        Email email=new Email();
	        userInfo=userInfoDao.getUserInfoById(id);
	        if(userInfo!=null){
	            String emailContents=userInfo.getName()+",您被分配了新的bug，请登录系统查看详情!";
	            email.setId(id);
	            email.setAddress(userInfo.getEmail());
	            email.setContent(emailContents);
	            email.setSubject("缺陷管理系统");
	            return SendEmailMessage(email);
	        }
	        return null;
	    }


	   private String SendEmailMessage(Email email){
	        
	        if(mailSender!=null){
	            mailSender.readSend(email);
	        }else{
	            return "邮件发送失败";
	        }
	        
	       
	        return "邮件发送成功";    
	            
	         
	    }
	

}
