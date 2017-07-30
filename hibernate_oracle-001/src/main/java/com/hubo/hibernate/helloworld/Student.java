package com.hubo.hibernate.helloworld;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3704667781513133105L;
	private Integer id;
	private String name;
	private Timestamp birth;
	private Time time;
	private Date crtDate;
	 
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, Timestamp birth) {
		super();
		this.name = name;
		this.birth = birth;
	}
	public Student(Integer id, String name, Timestamp birth) {
		super();
		this.id = id;
		this.name = name;
		this.birth = birth;
	}
	
	public Student(String name, Timestamp birth, Time time, Date crtDate) {
		super();
		this.name = name;
		this.birth = birth;
		this.time = time;
		this.crtDate = crtDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Timestamp birth) {
		this.birth = birth;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Date getCrtDate() {
		return crtDate;
	}
	public void setCrtDate(Date crtDate) {
		this.crtDate = crtDate;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birth=" + birth
				+ "]";
	}
	
	
	
	
}
