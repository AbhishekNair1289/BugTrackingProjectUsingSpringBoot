package com.bugtracking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "admininfo")
public class AdminEntity {

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


	public AdminEntity() {
		super();

	}


	@Override
	public String toString() {
		return "AdminEntity [mail=" + mail + ", name=" + name + ", password=" + password + ", contact=" + contact + "]";
	}


	public AdminEntity(@Email @NotEmpty(message = "The Email id cannot be empty") String mail,
			@NotEmpty(message = "The Admin Name cannot be empty") String name,
			@NotEmpty(message = "The password cannot be empty") String password,
			@NotEmpty(message = "The Contact cannot be empty") String contact) {
		super();
		this.mail = mail;
		this.name = name;
		this.password = password;
		this.contact = contact;
	}
	
	

}
