package com.jiyun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true, length=20, nullable=false)
	private String userId;
	
	@Column(length=20, nullable=false)
	private String password;
	
	@Column(length=20, nullable=false)
	private String name;
	
	@Column(length=30)
	private String email;
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		//sysout으로 user 객체를 찍게되면 자동적으로 toString 메소드가 호출이 된다.
		return "UserController [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email
				+ "]";
	}
	public boolean matchPassword(String password) {
		// TODO Auto-generated method stub
		return password.equals(this.password);
	}
	
}
