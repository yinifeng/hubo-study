package com.hubo.jdbc.demo1;

import java.sql.Date;

public class Customers {
	private Integer id;
	private String name;
	private String email;
	private Date birth;
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customers(Integer id, String name, String email, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
	}
	public Customers(String name, String email, Date birth) {
		super();
		this.name = name;
		this.email = email;
		this.birth = birth;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Customers [id=" + id + ", name=" + name + ", email=" + email
				+ ", birth=" + birth + "]\n";
	}
	
	
}
