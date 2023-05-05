package com.bugtracking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "buginfo")
public class BugInfoEntity {

	@Id
	@Column(name = "bug_id", length=10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bug_id;

	@Column(name = "bug_title", length=20)
	@NotEmpty(message = "The Bug Title cannot be empty")
	@NotBlank(message = "The Bug Title cannot be null or whitespace")
	private String bug_title;

	@Column(name = "bug_description", length=20)
	@NotEmpty(message = "The Bug Description cannot be empty")
	@NotBlank(message = "The Bug Desription cannot be null or whitespace")
	private String bug_desc;

	@Column(name = "bug_type", length=20)
	@NotEmpty(message = "The Bug Type cannot be empty")
	@NotBlank(message = "The Bug Type cannot be null or whitespace")
	private String bug_type;

	@Column(name = "bug_priority", length=20)
	@NotEmpty(message = "The priority column cannot be empty")
	private String bug_priority;

	@Column(name = "bug_fix_progress", length=20)
//	@NotEmpty(message = "The progress report cannot be empty")
	private int bug_fix_progress;

	@Column(name="ename", length=20)
	@NotEmpty(message="Employee Name cannot be empty")
	@NotBlank(message="The Employee Name cannot be null or whitespace")
	private String bug_assignee;
	
	@Column(name="eemail", length=20)
	@NotEmpty(message="Employee Name cannot be empty")
	@NotBlank(message="The Employee Name cannot be null or whitespace")
	private String bug_assigneemail;

	@Column(name = "bug_fix_status", length=20)
	@NotEmpty(message = "The Status of bug cannot be empty")
	@NotBlank(message = "The Status of the bug cannot be null or whitespace")
	private String bug_status;

	@Column(name = "bug_report_date", length=20)
	private String start_date;

	@Column(name = "bug_closing_date", length=20)
	private String end_date;

	@Column(name = "pname", length=20)
	@NotEmpty(message = "Project Name cannot be empty")
	@NotBlank(message = "The Project Name cannot be null or whitespace")
	private String project_name;
	
	@Column(name = "pid", length=20)
//	@NotEmpty(message = "Project Name cannot be empty")
//	@NotBlank(message = "The Project Name cannot be null or whitespace")
	private long project_id;

	public int getBug_id() {
		return bug_id;
	}

	public void setBug_id(int bug_id) {
		this.bug_id = bug_id;
	}

	public String getBug_title() {
		return bug_title;
	}

	public void setBug_title(String bug_title) {
		this.bug_title = bug_title;
	}

	public String getBug_desc() {
		return bug_desc;
	}

	public void setBug_desc(String bug_desc) {
		this.bug_desc = bug_desc;
	}

	public String getBug_type() {
		return bug_type;
	}

	public void setBug_type(String bug_type) {
		this.bug_type = bug_type;
	}

	public String getBug_priority() {
		return bug_priority;
	}

	public void setBug_priority(String bug_priority) {
		this.bug_priority = bug_priority;
	}

	public int getBug_fix_progress() {
		return bug_fix_progress;
	}

	public void setBug_fix_progress(int bug_fix_progress) {
		this.bug_fix_progress = bug_fix_progress;
	}

	public String getBug_status() {
		return bug_status;
	}

	public void setBug_status(String bug_status) {
		this.bug_status = bug_status;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getBug_assignee() {
		return bug_assignee;
	}

	public void setBug_assignee(String bug_assignee) {
		this.bug_assignee = bug_assignee;
	}


	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public long getProject_id() {
		return project_id;
	}

	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}

	public BugInfoEntity() {

	}

	public String getBug_assigneemail() {
		return bug_assigneemail;
	}

	public void setBug_assigneemail(String bug_assigneemail) {
		this.bug_assigneemail = bug_assigneemail;
	}

	@Override
	public String toString() {
		return "BugInfoEntity [bug_id=" + bug_id + ", bug_title=" + bug_title + ", bug_desc=" + bug_desc + ", bug_type="
				+ bug_type + ", bug_priority=" + bug_priority + ", bug_fix_progress=" + bug_fix_progress
				+ ", bug_assignee=" + bug_assignee + ", bug_assigneemail=" + bug_assigneemail + ", bug_status="
				+ bug_status + ", start_date=" + start_date + ", end_date=" + end_date + ", project_name="
				+ project_name + ", project_id=" + project_id + "]";
	}

	public BugInfoEntity(int bug_id,
			@NotEmpty(message = "The Bug Title cannot be empty") @NotBlank(message = "The Bug Title cannot be null or whitespace") String bug_title,
			@NotEmpty(message = "The Bug Description cannot be empty") @NotBlank(message = "The Bug Desription cannot be null or whitespace") String bug_desc,
			@NotEmpty(message = "The Bug Type cannot be empty") @NotBlank(message = "The Bug Type cannot be null or whitespace") String bug_type,
			@NotEmpty(message = "The priority column cannot be empty") String bug_priority,
			@NotEmpty(message = "The progress report cannot be empty") int bug_fix_progress,
			@NotEmpty(message = "Employee Name cannot be empty") @NotBlank(message = "The Employee Name cannot be null or whitespace") String bug_assignee,
			@NotEmpty(message = "Employee Name cannot be empty") @NotBlank(message = "The Employee Name cannot be null or whitespace") String bug_assigneemail,
			@NotEmpty(message = "The Status of bug cannot be empty") @NotBlank(message = "The Status of the bug cannot be null or whitespace") String bug_status,
			String start_date, String end_date,
			@NotEmpty(message = "Project Name cannot be empty") @NotBlank(message = "The Project Name cannot be null or whitespace") String project_name,
			@NotEmpty(message = "Project Name cannot be empty") @NotBlank(message = "The Project Name cannot be null or whitespace") long project_id) {
		super();
		this.bug_id = bug_id;
		this.bug_title = bug_title;
		this.bug_desc = bug_desc;
		this.bug_type = bug_type;
		this.bug_priority = bug_priority;
		this.bug_fix_progress = bug_fix_progress;
		this.bug_assignee = bug_assignee;
		this.bug_assigneemail = bug_assigneemail;
		this.bug_status = bug_status;
		this.start_date = start_date;
		this.end_date = end_date;
		this.project_name = project_name;
		this.project_id = project_id;
	}
	
	

}
