package com.action;

import java.util.ArrayList;
import java.util.List;

import com.dao.ArticleDao;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	private String username;
	private String password;
	private List list;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String loginByAdmin(){
		if(getUsername().equals("admin")&&getPassword().equals("admin")){
			return SUCCESS;
		}
		else{
			return INPUT;
		}
	}
	public String listAllArticle(){//返回所有的图书列表
		
		ArticleDao dao=new ArticleDao();
		list=dao.listAllArticle();
		return SUCCESS;
	}
}
