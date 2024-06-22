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
@Table(name = "class")
@Access(value = AccessType.FIELD)
public class Classes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "Name", nullable = false)
	private String Name;
	@Column(name = "idfaculty", nullable = false)
	private Long idfaculty;
	@Column(name = "idteacher", nullable = false)
	private Long idteacher;
	
	@ManyToOne
    @JoinColumn(name = "idteacher" , insertable = false, updatable = false)
    private Teacher teacher;
	
	@ManyToOne
    @JoinColumn(name = "idfaculty" , insertable = false, updatable = false)
    private faculties faculty;
	
	
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


	public Long getIdfaculty() {
		return idfaculty;
	}


	public void setIdfaculty(Long idfaculty) {
		this.idfaculty = idfaculty;
	}


	public Long getIdteacher() {
		return idteacher;
	}


	public void setIdteacher(Long idteacher) {
		this.idteacher = idteacher;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public faculties getFaculty() {
		return faculty;
	}


	public void setFaculty(faculties faculty) {
		this.faculty = faculty;
	}
	
	


	public Classes(Long id, String name, Long idfaculty, Long idteacher, Teacher teacher, faculties faculty) {
		super();
		Id = id;
		Name = name;
		this.idfaculty = idfaculty;
		this.idteacher = idteacher;
		this.teacher = teacher;
		this.faculty = faculty;
	}


	public Classes() {
		
	}
	
}
