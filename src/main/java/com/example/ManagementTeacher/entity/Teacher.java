package com.example.ManagementTeacher.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "teachers")
@Access(value = AccessType.FIELD)
public class Teacher {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getOnboard() {
		return onboard;
	}
	public void setOnboard(Date onboard) {
		this.onboard = onboard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPasswordhas() {
		return passwordhas;
	}
	public void setPasswordhas(String passwordhas) {
		this.passwordhas = passwordhas;
	}
	public int getRole() {
		return Role;
	}
	public void setRole(int role) {
		Role = role;
	}
//	public String getCreateBy() {
//		return CreateBy;
//	}
//	public void setCreateBy(String createBy) {
//		CreateBy = createBy;
//	}
//	public Date getCreateDate() {
//		return CreateDate;
//	}
//	public void setCreateDate(Date createDate) {
//		CreateDate = createDate;
//	}
//	public String getModifyBy() {
//		return ModifyBy;
//	}
//	public void setModifyBy(String modifyBy) {
//		ModifyBy = modifyBy;
//	}
//	public Date getModifyDate() {
//		return ModifyDate;
//	}
//	public void setModifyDate(Date modifyDate) {
//		ModifyDate = modifyDate;
//	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = true)
	private String name;
	@Column(name = "onboard", nullable = false)
	private Date onboard;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "passwordhas", nullable = false)
	private String passwordhas;
	@Column(name = "Role", nullable = false)
	public int Role;
	
	@OneToMany(mappedBy = "teacher")
    private List<Subjects> subjects;
	
//	@Column(name = "CreateBy", nullable = false)
//	public String CreateBy;
//	@Column(name = "CreateDate", nullable = false)
//	private Date CreateDate;
//	@Column(name = "ModifyBy", nullable = false)
//	public String ModifyBy;
//	@Column(name = "ModifyDate", nullable = false)
//	private Date ModifyDate;
	public Teacher() {
	}
	public Teacher(Long id, String name, Date onboard, String email, String phone, String passwordhas, int role) {
		super();
		this.id = id;
		this.name = name;
		this.onboard = onboard;
		this.email = email;
		this.phone = phone;
		this.passwordhas = passwordhas;
	}
	
}
