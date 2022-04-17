package com.abbei.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")

public class Users {
    
   public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long userId;
    
   @Column(nullable = false, unique = true, length = 45)
   private String userCode;
    
   
   @Column(nullable = false, length = 64)
   private String userName;
   
   @Column(nullable = false, length = 64)
   private String password;
    
   @Column(name = "first_name", nullable = false, length = 20)
   private String firstName;
    
   @Column(name = "last_name", nullable = false, length = 20)
   private String lastName;
}
