package com.bugtracking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "projects_info")
public class ProjectEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pid", length = 20)
	private long projId;

	@Column(name = "pname", length = 20)
	@NotEmpty(message = "The Project Name cannot be empty")
	private String projName;

	@Column(name = "ename", length = 20)
	@NotEmpty(message = "The Employee Name cannot be empty")
	private String emp_name;
	
	@Column(name = "eemail", length=30)
	@NotEmpty(message = "The Email cannot be empty")
	private String email;
	

	@Column(name = "pstatus", length = 20)
	@NotEmpty(message = "The Status cannot be empty")
	private String projStatus;

	

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getProjId() {
		return projId;
	}

	public void setProjId(long projId) {
		this.projId = projId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getProjStatus() {
		return projStatus;
	}

	public void setProjStatus(String projStatus) {
		this.projStatus = projStatus;
	}

	public ProjectEntity() {
		super();
	}

	@Override
	public String toString() {
		return "ProjectEntity [projId=" + projId + ", projName=" + projName + ", emp_name=" + emp_name + ", email="
				+ email + ", projStatus=" + projStatus + "]";
	}

	public ProjectEntity(long projId, @NotEmpty(message = "The Project Name cannot be empty") String projName,
			@NotEmpty(message = "The Employee Name cannot be empty") String emp_name,
			@NotEmpty(message = "The Email cannot be empty") String email,
			@NotEmpty(message = "The Status cannot be empty") String projStatus) {
		super();
		this.projId = projId;
		this.projName = projName;
		this.emp_name = emp_name;
		this.email = email;
		this.projStatus = projStatus;
	}

	
	
	

}
