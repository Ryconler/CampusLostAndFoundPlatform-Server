package com.entity;

import java.util.HashSet;


/**
 * Article entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Article implements java.io.Serializable {

	// Fields

	private Integer aid;
	private User user;
	private Integer state;
	private Integer type;
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
	private Integer money;
//	private Set collects = new HashSet(0);

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(User user, Integer state, Integer type, String title,
			String articleType, String school, String address,
			String contactName, String contactTel, Integer viewNum, String date) {
		this.user = user;
		this.state = state;
		this.type = type;
		this.title = title;
		this.articleType = articleType;
		this.school = school;
		this.address = address;
		this.contactName = contactName;
		this.contactTel = contactTel;
		this.viewNum = viewNum;
		this.date = date;
	}

	/** full constructor */
	public Article(User user, Integer state, Integer type, String title,
			String articleType, String school, String address,
			String contactName, String contactTel, Integer viewNum,
			String date, String contactQq, String imageUrl, String detail,
			Integer money) {
		this.user = user;
		this.state = state;
		this.type = type;
		this.title = title;
		this.articleType = articleType;
		this.school = school;
		this.address = address;
		this.contactName = contactName;
		this.contactTel = contactTel;
		this.viewNum = viewNum;
		this.date = date;
		this.contactQq = contactQq;
		this.imageUrl = imageUrl;
		this.detail = detail;
		this.money = money;
		
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticleType() {
		return this.articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTel() {
		return this.contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public Integer getViewNum() {
		return this.viewNum;
	}

	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContactQq() {
		return this.contactQq;
	}

	public void setContactQq(String contactQq) {
		this.contactQq = contactQq;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getMoney() {
		return this.money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

//	public Set getCollects() {
//		return this.collects;
//	}
//
//	public void setCollects(Set collects) {
//		this.collects = collects;
//	}

}