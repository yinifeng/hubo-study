package com.hubo.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
	public static void main(String[] args) {
		List<Student> list=new ArrayList<Student>();
		Student s1=new Student("tom", 21);
		Student s2=new Student("tom", 22);
		Student s3=new Student("marry", 22);
		Student s4=new Student("marry", 20);
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		for(Student s:list){
			System.out.println(s);
		}
		System.out.println("-------------------");
		Collections.sort(list, new Comparator<Student>() {

			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				int num=o1.getAge()-o2.getAge();
				int num2=num==0?o1.getName().compareTo(o2.getName()):num;
				return num2;
			}
			
		});
		
		for(Student s:list){
			System.out.println(s);
		}
	}
}
