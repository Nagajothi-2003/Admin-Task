
package com.example.demo.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Userlogin")
public class UserLogin {
	@Id
	@GeneratedValue
	private int id;
	private String email;
	private String password;
	
	@Column(name = "createdAt")
    private Date createdAt;
	public int getId() {
		return id;
	}
	 public UserLogin() {}


	public UserLogin(int id, String email, String password, Date createdAt) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.createdAt = createdAt;
}


	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
}
	

}
