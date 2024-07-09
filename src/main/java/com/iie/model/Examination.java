package com.iie.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Examination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String applicationNumber;
	private String course;
	private String stream;
	private Date examDate;

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

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	@Override
	public String toString() {
		return "Examination [id=" + id + ", name=" + name + ", applicationNumber=" + applicationNumber + ", course="
				+ course + ", stream=" + stream + ", examDate=" + examDate + "]";
	}

	public Examination(Long id, String name, String applicationNumber, String course, String stream, Date examDate) {
		super();
		this.id = id;
		this.name = name;
		this.applicationNumber = applicationNumber;
		this.course = course;
		this.stream = stream;
		this.examDate = examDate;
	}

	public Examination() {

	}

}