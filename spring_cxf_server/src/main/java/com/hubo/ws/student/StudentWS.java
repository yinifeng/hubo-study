package com.hubo.ws.student;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface StudentWS {
	@WebMethod
	void saveStudent(Student student);

	@WebMethod
	Student getById(int id);

	@WebMethod
	List<Student> findAll();

	@WebMethod
	Map<String, Student> getNo();

}
