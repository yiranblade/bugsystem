package com.bugsytem.dto;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年8月24日 下午4:26:23 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class Email {
    private int id;
    private String address;
    private String cc;
    private String subject;
    private String content;
    public int count=0;
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCc() {
        return cc;
    }
    
    public void setCc(String cc) {
        this.cc = cc;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }
   // private MultipartFile[] ;
    
    

}
