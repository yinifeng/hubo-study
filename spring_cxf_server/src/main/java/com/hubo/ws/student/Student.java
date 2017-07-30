package com.hubo.ws.student;

public class Student {
	private int id;
	private String name;
	private double score;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, double score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score
				+ "]";
	}
	
}
