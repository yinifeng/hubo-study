package com.hubo.ws.client;

import java.util.List;

import com.hubo.ws.student.GetNoResponse.Return;
import com.hubo.ws.student.GetNoResponse.Return.Entry;
import com.hubo.ws.student.Student;
import com.hubo.ws.student.impl.StudentWS;
import com.hubo.ws.student.impl.StudentWSImplService;

public class StudentClient {
	public static void main(String[] args) {
		StudentWSImplService factory=new StudentWSImplService();
		StudentWS studentWS = factory.getStudentWSImplPort();
		
		System.out.println(studentWS.getById(11));
		
		studentWS.saveStudent(new Student(55, "hobart", 98));
		System.out.println("=================");
		List<Student> list = studentWS.findAll();
		for(Student s:list){
			System.out.println(s);
		}
		System.out.println("=================");
		//获取Map类型
		Return r = studentWS.getNo();
		List<Entry> entry = r.getEntry();
		for(Entry e:entry){
			System.out.println(e.getKey()+","+e.getValue());
		}
	}
}
