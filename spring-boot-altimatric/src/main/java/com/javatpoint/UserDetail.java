package com.javatpoint;

import java.io.Serializable;

public class UserDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private int id;
	private String title;
	private String body;

	public UserDetail() {

	}

	public UserDetail(int userId, int id, String title, String body) {
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "UserDetail [userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}