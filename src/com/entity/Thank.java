package com.entity;

/**
 * Thank entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Thank implements java.io.Serializable {

	// Fields

	private Integer tid;
	private User userByRuid;
	private User userBySuid;
	private Article article;
	private String content;
	private String date;

	// Constructors

	/** default constructor */
	public Thank() {
	}

	/** full constructor */
	public Thank(User userByRuid, User userBySuid, Article article,
			String content, String date) {
		this.userByRuid = userByRuid;
		this.userBySuid = userBySuid;
		this.article = article;
		this.content = content;
		this.date = date;
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public User getUserByRuid() {
		return this.userByRuid;
	}

	public void setUserByRuid(User userByRuid) {
		this.userByRuid = userByRuid;
	}

	public User getUserBySuid() {
		return this.userBySuid;
	}

	public void setUserBySuid(User userBySuid) {
		this.userBySuid = userBySuid;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}