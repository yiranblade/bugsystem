package com.bugsystem.serviceimpl;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bugsytem.dto.Email;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年8月24日 下午5:11:48 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
@Service
public class ApplicationMailer {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TaskExecutor taskExecutor;
    private static int flag=0;
    
    private static BlockingQueue<Email> calls = new LinkedBlockingQueue<Email>(500);
    
    
    private  void sendMailBySynchronizationMode(Email email) throws MessagingException,IOException{
        Session session=Session.getDefaultInstance(new Properties());
        MimeMessage mime=new MimeMessage(session);
        MimeMessageHelper helper=new MimeMessageHelper(mime,true,"utf-8");
        helper.setFrom("291305029@qq.com");
        helper.setTo(InternetAddress.parse(email.getAddress()));
        helper.setReplyTo("291305029@qq.com");
        helper.setSubject(email.getSubject());
        helper.setText("text/html",email.getContent());
        mailSender.send(mime);
    }
    public void readSend(Email email){
        if(email!=null){
            try{
                calls.put(email);
                if(!calls.isEmpty()){
                    if(flag==0){
                        sendMailByAsynchronousMode();
                     }
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    private void  sendMailByAsynchronousMode(){
            taskExecutor.execute(new Runnable() {
            
            
                public void run() {
                    // TODO Auto-generated method stub
                    flag=1;
                   
                    while(!calls.isEmpty()){
                        Email em=null;
                        
                        try{
                            em=calls.take();
                            sendMailBySynchronizationMode(em);
                           
                        }catch(Exception e){
                            
                            try {
                                if(em.count<=4){
                                   em.count++;
                                   calls.put(em);
                                }else{
                                }
                            } catch (InterruptedException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                        }
                    }
                    flag=0;
                    
                }
            });
        
    }
}
