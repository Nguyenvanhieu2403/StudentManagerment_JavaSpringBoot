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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
@Access(value = AccessType.FIELD)
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "name", nullable = true)
	private String name;
	@Column(name = "Dob", nullable = false)
	private Date Dob;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "gender", nullable = true)
	private String gender;
	@Column(name = "Address", nullable = false)
	private String Address;
	@Column(name = "idclass", nullable = false)
	public Long idclass;
	@Column(name = "idteacher", nullable = false)
	public Long idteacher;
	
	@ManyToOne
    @JoinColumn(name = "idclass" , insertable = false, updatable = false)
	private Classes studentClass;
	
	@ManyToOne
    @JoinColumn(name = "idteacher" , insertable = false, updatable = false)
    private Teacher teacher;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return Dob;
	}

	public void setDob(Date dob) {
		Dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Long getIdclass() {
		return idclass;
	}

	public void setIdclass(Long idclass) {
		this.idclass = idclass;
	}

	public Long getIdteacher() {
		return idteacher;
	}

	public void setIdteacher(Long idteacher) {
		this.idteacher = idteacher;
	}

	public Classes getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(Classes studentClass) {
		this.studentClass = studentClass;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student(Long id, String name, Date dob, String phone, String gender, String address, Long idclass,
			Long idteacher, Classes studentClass, Teacher teacher) {
		super();
		this.Id = id;
		this.name = name;
		this.Dob = dob;
		this.phone = phone;
		this.gender = gender;
		this.Address = address;
		this.idclass = idclass;
		this.idteacher = idteacher;
		this.studentClass = studentClass;
		this.teacher = teacher;
	}

	public Student() {
		
	}
	
}
