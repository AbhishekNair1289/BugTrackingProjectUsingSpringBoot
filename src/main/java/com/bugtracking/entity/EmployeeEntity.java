package com.bugtracking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "emp_info")
public class EmployeeEntity {


	@Column(name = "ename", length=20)
	@NotEmpty(message = "The Employee Name cannot be empty")
	private String empNname;

	@Id
	@Column(name = "eemail", length=30)
	@NotEmpty(message = "The Email cannot be empty")
	private String email;
	
	@Column(name = "epass", length=20)
	@NotEmpty(message = "The password cannot be empty")
	private String epassword;

	@Column(name = "econ", length=10)
	@NotEmpty(message = "The Contact cannot be empty")
	private String empContact;

    @Column(name = "pid")
//	@NotEmpty(message = "The project Id cannot be empty")
    private Long projectId;

    @Column(name = "pname", length=20)
	@NotEmpty(message = "The project name cannot be empty")
	private String project_name;
    
	// Constructors, getters and setters



	public String getEmpNname() {
		return empNname;
	}

	public void setEmpNname(String empNname) {
		this.empNname = empNname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpContact() {
		return empContact;
	}

	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}

	public String getEpassword() {
		return epassword;
	}

	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}

	
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public EmployeeEntity() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeeEntity [empNname=" + empNname + ", email=" + email + ", epassword=" + epassword
				+ ", empContact=" + empContact + ", projectId=" + projectId + ", project_name=" + project_name + "]";
	}

	public EmployeeEntity(@NotEmpty(message = "The Employee Name cannot be empty") String empNname,
			@NotEmpty(message = "The Email cannot be empty") String email,
			@NotEmpty(message = "The password cannot be empty") String epassword,
			@NotEmpty(message = "The Contact cannot be empty") String empContact,
			@NotEmpty(message = "The project Id cannot be empty") Long projectId,
			@NotEmpty(message = "The project name cannot be empty") String project_name) {
		super();
		this.empNname = empNname;
		this.email = email;
		this.epassword = epassword;
		this.empContact = empContact;
		this.projectId = projectId;
		this.project_name = project_name;
	}

	
}