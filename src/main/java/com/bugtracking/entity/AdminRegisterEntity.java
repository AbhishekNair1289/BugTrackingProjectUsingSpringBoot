package com.bugtracking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "admin_register_info")
public class AdminRegisterEntity {

	@Id
	@Column(name = "admin_email", length=20)
	@Email
	@NotEmpty(message = "The Email id cannot be empty")
	private String mail;
	
	
	@Column(name = "admin_name", length=20)
	@NotEmpty(message = "The Admin Name cannot be empty")
	private String name;
	
	@Column(name = "admin_password", length=20)
	@NotEmpty(message = "The password cannot be empty")
	private String password;
	
	@Column(name = "admin_contact", length=15)
	@NotEmpty(message = "The Contact cannot be empty")
	private String contact;

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}



}
