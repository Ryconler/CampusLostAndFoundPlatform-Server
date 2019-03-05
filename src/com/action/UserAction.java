package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.UserDao;
import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private List<Object> jdata;
	private String username;
	private String password;
	private String school;
	private String tel;
	private String qq;
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
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

	public List<Object> getJdata() {
		return jdata;
	}

	public void setJdata(List<Object> jdata) {
		this.jdata = jdata;
	}

	
	//登陆
	public String login(){
		jdata=new ArrayList<Object>();
		Map<String,Object> jMap= new HashMap<String, Object>();
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user=new User();
		user.setUsername(getUsername());
		user.setPassword(getPassword());
		UserDao dao=new UserDao();
		user=dao.search(user);	//搜索制定user
		if(user!=null){
			//搜索成功，有这个用户
			jMap.put("result", true);
			jMap.put("uid", user.getUid());
			jMap.put("school", user.getSchool());
			jMap.put("tel", user.getTel());
			jMap.put("qq", user.getQq());
			session.put("user",user);//用户信息保存在session中
		}
		else {
			//搜索失败，没这个用户
			jMap.put("result",false);
		}
		jdata.add(jMap);
		return SUCCESS;
	}
	
	public String register(){
		jdata=new ArrayList<Object>();
		Map<String,Object> jMap= new HashMap<String, Object>();
		
		User user=new User();
		user.setUsername(getUsername());
		user.setPassword(getPassword());
		user.setSchool(getSchool());
		user.setTel(getTel());
		if(getQq()!=""){
			user.setQq(getQq());
		}
		UserDao dao=new UserDao();
		int result=dao.add(user);
		if(result==1){
			User newuser=new User();
			newuser=dao.searchUserByUsername(user.getUsername());
			jMap.put("uid", newuser.getUid());
			jMap.put("result", true);
		}
		else {
			//添加用户名存在的判断标识
			jMap.put("result", false);
		}
		jdata.add(jMap);
		return SUCCESS;
		
	}
	
}
