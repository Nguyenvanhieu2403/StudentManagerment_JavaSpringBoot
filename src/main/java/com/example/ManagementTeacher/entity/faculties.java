package com.example.ManagementTeacher.entity;

import java.sql.Date;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "faculties")
@Access(value = AccessType.FIELD)
public class faculties {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "Name", nullable = false)
	private String Name;
//	@Column(name = "CreateBy", nullable = false)
//	public String CreateBy;
//	@Column(name = "CreateDate", nullable = false)
//	private Date CreateDate;
//	@Column(name = "ModifyBy", nullable = false)
//	public String ModifyBy;
//	@Column(name = "ModifyDate", nullable = false)
//	private Date ModifyDate;
	
	public faculties(Long id, String name) {
		super();
		Id = id;
		Name = name;
	}
	
	
	
	public faculties() {
	}



	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
	
	
}
