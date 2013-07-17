package com.sino.bjcc.discuss.bean; 
import java.util.Date;

import javax.swing.text.AbstractDocument.Content;

public class Artical {
    private long ID;           //id
    private long siteID;       //վ��ID
   /* private String author;     //��������
    private String email;      //����E_mail
    private Date creationDate; //评论时间
    private String content;    //评论者内容
    private String ipAddress;  //IP��ַ
    private int status = 0;    //״̬
    private long articleID;   
    private String discussUser;//评论者
    private long discussUserID;//评论者id
    private Integer grade;//����
*/
    /*public String getDiscussUser() {
		return discussUser;
	}

	public void setDiscussUser(String discussUser) {
		this.discussUser = discussUser;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}*/

	public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

   /* public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
*/
    public long getSiteID() {
        return siteID;
    }

    public void setSiteID(long siteID) {
        this.siteID = siteID;
    }

    /*public long getArticleID() {
        return articleID;
    }

    public void setArticleID(long articleID) {
        this.articleID = articleID;
    }

	public long getDiscussUserID() {
		return discussUserID;
	}

	public void setDiscussUserID(long discussUserID) {
		this.discussUserID = discussUserID;
	}*/
}




