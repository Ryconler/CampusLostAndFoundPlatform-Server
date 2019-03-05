package com.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.ArticleDao;
import com.dao.UserDao;
import com.entity.Article;
import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport{
	private List<Object> jdata;
	private Integer aid;
	private String type;
	private Integer state;
	private String title;
	private String articleType;
	private String school;
	private String address;
	private String contactName;
	private String contactTel;
	private Integer viewNum;
	private String date;
	private String contactQq;
	private String imageUrl;
	private String detail;
	private String money;
	private String username;
	private String difDate;
	private String searchContent;
	
	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public String getDifDate() {
		return difDate;
	}

	public void setDifDate(String difDate) {
		this.difDate = difDate;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Object> getJdata() {
		return jdata;
	}

	public void setJdata(List<Object> jdata) {
		this.jdata = jdata;
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public Integer getViewNum() {
		return viewNum;
	}

	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContactQq() {
		return contactQq;
	}

	public void setContactQq(String contactQq) {
		this.contactQq = contactQq;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}
	
	
	public String setHasFound(){
		ArticleDao dao=new ArticleDao();
		jdata=new ArrayList<Object>();
		Map<String,Object> jMap= new HashMap<String, Object>();
		
		int result=dao.setHasFound(getAid());
		if(result==1){
			jMap.put("result", true);
		}
		else{
			jMap.put("result", false);
		}
		jdata.add(jMap);
		return SUCCESS;
	}
	
	public String articleDetail(){
		ArticleDao dao=new ArticleDao();
		jdata=new ArrayList<Object>();
		
		jdata=dao.articleDetail(getAid());
		return SUCCESS;

	}
	public String listArticleBySearch(){
		ArticleDao dao=new ArticleDao();
		jdata=new ArrayList<Object>();
		Map<String,Object> jMap= new HashMap<String, Object>();
		jdata=dao.listArticleBySearch(getSearchContent());
		
		return SUCCESS;
	}
	public String listArticle(){
		ArticleDao dao=new ArticleDao();
		jdata=new ArrayList<Object>();
		Map<String,Object> jMap= new HashMap<String, Object>();
		if(getArticleType().equals("全部")){
			jdata=dao.listArticle(getSchool(),Integer.parseInt(getType()),getDifDate());
		}
		else{
			jdata=dao.listArticleByArticleType(getSchool(),getArticleType()
					,Integer.parseInt(getType()),getDifDate());
		}
		
		return SUCCESS;
	}
	public String listMyArticle(){
		ArticleDao dao=new ArticleDao();
		jdata=new ArrayList<Object>();
		Map<String,Object> jMap= new HashMap<String, Object>();
		
		jdata=dao.listMyArticle(getUsername(),Integer.parseInt(getType()));
		
		return SUCCESS;
	}
	
	public String addArticle(){
		jdata=new ArrayList<Object>();
		Map<String,Object> jMap= new HashMap<String, Object>();
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		ArticleDao dao=new ArticleDao();
		Article lost=new Article();
		UserDao udao=new UserDao();
		
		User user=new User();
		user=udao.searchUserByUsername(getUsername());
		
//		user=(User)session.get("user");
		//session中没有user（没有登陆）安卓端不可用
		
		lost.setUser(user);
		lost.setType(Integer.parseInt(getType()));	//0表示失物招领，1表示寻物启事
		lost.setState(0);	//0表示失物尚未被找回，1反之
		lost.setTitle(getTitle());
		lost.setArticleType(getArticleType());
		lost.setSchool(getSchool());
		lost.setAddress(getAddress());
		lost.setContactName(getContactName());
		lost.setContactTel(getContactTel());
		lost.setViewNum(0);		//初始浏览次数均为0
		//获取当前系统时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		lost.setDate(date);
		lost.setContactQq(getContactQq());
		lost.setImageUrl(getImageUrl());
		lost.setDetail(getDetail());
//		发布失物招领不应该填写酬金
		lost.setMoney(Integer.parseInt(getMoney()));
		
		int result=dao.addArticle(lost);
		if(result==1)
			jMap.put("result", true);
		else {
			//添加失物失败的判断标识
			jMap.put("result", false);
		}

		jdata.add(jMap);
		return SUCCESS;
	}

	

	
	
}
