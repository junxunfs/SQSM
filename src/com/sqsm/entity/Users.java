package com.sqsm.entity;

public class Users {
	private int userID;
	private String username;
	private String password;
	private String password2;
	private int role;
	private String realname;
	private String sex;
	private int age;
	private String message;
	private String like_food;
	
	
	
	
	@Override
	public String toString() {
		return "Users [userID=" + userID + ", username=" + username
				+ ", password=" + password + ", password2=" + password2
				+ ", role=" + role + ", realname=" + realname + ", sex=" + sex
				+ ", age=" + age + ", message=" + message + ", like_food="
				+ like_food + "]";
	}

	public Users(int userID, String username, String password,
			String password2, int role, String realname, String sex, int age,
			String message, String like_food) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.password2 = password2;
		this.role = role;
		this.realname = realname;
		this.sex = sex;
		this.age = age;
		this.message = message;
		this.like_food = like_food;
	}

	public String getLike_food() {
		return like_food;
	}

	public void setLike_food(String like_food) {
		this.like_food = like_food;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
}
