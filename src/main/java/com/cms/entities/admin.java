package com.cms.entities;

public class admin {

	private String id;
	private String name;
	private long mobile;
	private String password;
	
	public admin(String id, String name, long mobile, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.password = password;
	}
	public admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
