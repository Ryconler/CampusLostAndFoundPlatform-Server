package com.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.ArticleDao;
import com.dao.ThankDao;
import com.dao.UserDao;
import com.entity.Thank;
import com.opensymphony.xwork2.ActionSupport;

public class ThankAction extends ActionSupport{
	private List<Object> jdata;
	private String aid;
	private String sUid;
	private String rUid;
	private String content;
	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getSUid() {
		return sUid;
	}

	public void setSUid(String uid) {
		sUid = uid;
	}

	public String getRUid() {
		return rUid;
	}

	public void setRUid(String uid) {
		rUid = uid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Object> getJdata() {
		return jdata;
	}

	public void setJdata(List<Object> jdata) {
		this.jdata = jdata;
	}
	
	public String listThankByRUid(){
		jdata=new ArrayList<Object>();
	
		ThankDao dao=new ThankDao();
		jdata=dao.listThankByRUid(Integer.parseInt(getRUid()));
		return SUCCESS;
	}
	
	public String listThank(){
		jdata=new ArrayList<Object>();
	
		ThankDao dao=new ThankDao();
		jdata=dao.listThank();
		return SUCCESS;
	}
	public String addThank(){
		jdata=new ArrayList<Object>();
		Map<String,Object> jMap= new HashMap<String, Object>();
		
		ThankDao tdao=new ThankDao();
		Thank thank=new Thank();
		ArticleDao adao=new ArticleDao();
		UserDao udao=new UserDao();
		
		thank.setArticle(adao.searchArticleByAid(Integer.parseInt(getAid())));
		thank.setContent(getContent());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		thank.setDate(date);
		thank.setUserByRuid(udao.searchUserByUid(Integer.parseInt(getRUid())));
		thank.setUserBySuid(udao.searchUserByUid(Integer.parseInt(getSUid())));
		int result=tdao.addThank(thank);
		if(result==1){
			jMap.put("result", true);
		}
		else{
			jMap.put("result", false);
		}
		jdata.add(jMap);
		return SUCCESS;
	}
}
