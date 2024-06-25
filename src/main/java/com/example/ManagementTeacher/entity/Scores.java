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
@Table(name = "scores")
@Access(value = AccessType.FIELD)

public class Scores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "idstudent", nullable = false)
	private Long idstudent;
	@Column(name = "idsubject", nullable = false)
	private Long idsubject;
	@Column(name = "attendancescore", nullable = false)
	private Float attendancescore;
	@Column(name = "midtermscore", nullable = false)
	private Float midtermscore;
	@Column(name = "finalscore", nullable = false)
	private Float finalscore;
	@Column(name = "averagescore", nullable = false)
	private Float averagescore;
	@Column(name = "term", nullable = false)
	private Long term;
	@Column(name = "idteacher", nullable = false)
	private Long idteacher;
	
	@ManyToOne
    @JoinColumn(name = "idteacher" , insertable = false, updatable = false)
    private Teacher teacher;
	
	@ManyToOne
    @JoinColumn(name = "idsubject" , insertable = false, updatable = false)
    private Subjects subject;
	
	@ManyToOne
    @JoinColumn(name = "idstudent" , insertable = false, updatable = false)
    private Student student;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getIdstudent() {
		return idstudent;
	}

	public void setIdstudent(Long idstudent) {
		this.idstudent = idstudent;
	}

	public Long getIdsubject() {
		return idsubject;
	}

	public void setIdsubject(Long idsubject) {
		this.idsubject = idsubject;
	}

	public Float getAttendancescore() {
		return attendancescore;
	}

	public void setAttendancescore(Float attendancescore) {
		this.attendancescore = attendancescore;
	}

	public Float getMidtermscore() {
		return midtermscore;
	}

	public void setMidtermscore(Float midtermscore) {
		this.midtermscore = midtermscore;
	}

	public Float getFinalscore() {
		return finalscore;
	}

	public void setFinalscore(Float finalscore) {
		this.finalscore = finalscore;
	}

	public Float getAveragescore() {
		return averagescore;
	}

	public void setAveragescore(Float averagescore) {
		this.averagescore = averagescore;
	}

	public Long getTerm() {
		return term;
	}

	public void setTerm(Long term) {
		this.term = term;
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

	public Subjects getSubject() {
		return subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Scores(Long id, Long idstudent, Long idsubject, Float attendancescore, Float midtermscore, Float finalscore,
			Float averagescore, Long term, Long idteacher, Teacher teacher, Subjects subject, Student student) {
		super();
		Id = id;
		this.idstudent = idstudent;
		this.idsubject = idsubject;
		this.attendancescore = attendancescore;
		this.midtermscore = midtermscore;
		this.finalscore = finalscore;
		this.averagescore = averagescore;
		this.term = term;
		this.idteacher = idteacher;
		this.teacher = teacher;
		this.subject = subject;
		this.student = student;
	}

	public Scores() {
		
	}
	
}
