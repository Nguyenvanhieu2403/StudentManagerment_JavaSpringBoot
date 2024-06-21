package com.example.ManagementTeacher.entity;

import java.sql.Date;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
@Access(value = AccessType.FIELD)
public class Subjects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "idteacher", nullable = false)
	private Long idteacher;
	
	
	
	@ManyToOne
    @JoinColumn(name = "idteacher" , insertable = false, updatable = false)
    private Teacher teacher;
	
	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		Id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	

	public Long getIdTeacher() {
		return idteacher;
	}



	public void setIdTeacher(Long idTeacher) {
		this.idteacher = idTeacher;
	}
	
	



	public Teacher getTeacher() {
		return teacher;
	}



	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	



	public Long getIdteacher() {
		return idteacher;
	}



	public void setIdteacher(Long idteacher) {
		this.idteacher = idteacher;
	}



	public Subjects(Long id, String name, Teacher teacher, Long idteacher) {
		super();
		Id = id;
		this.name = name;
		this.teacher = teacher;
		this.idteacher = idteacher;
	}



	public Subjects() {
	}
	
	
}
