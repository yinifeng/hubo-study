package com.hubo.ws.student.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hubo.ws.student.Student;
import com.hubo.ws.student.StudentWS;

public class StudentWSImpl implements StudentWS {

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println(student);
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		return new Student(id, "tom", 56);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();
		Student stu1 = new Student(1, "tom", 85.2);
		Student stu2 = new Student(2, "jack", 90.6);
		Student stu3 = new Student(3, "marry", 95);
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);

		return list;
	}

	@Override
	public Map<String, Student> getNo() {
		// TODO Auto-generated method stub
		Map<String, Student> map = new HashMap<String, Student>();
		Student stu1 = new Student(1, "tom", 85.2);
		Student stu2 = new Student(2, "jack", 90.6);
		Student stu3 = new Student(3, "marry", 95);
		map.put("1", stu1);
		map.put("2", stu2);
		map.put("3", stu3);
		return map;
	}

}
