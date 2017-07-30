package com.hubo.springmvc.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hubo.springmvc.crud.entities.Department;
import com.hubo.springmvc.crud.entities.Employee;


/**
 * 自定义类型转换器 
 * String  --> Employee
 * @author hubo
 *
 */
@Component
public class EmployeeConverter implements Converter<String, Employee>{

	@Override
	public Employee convert(String source) {
		// TODO Auto-generated method stub
		if(source!=null){
			String [] vals=source.split("\\-");
			if(vals!=null && vals.length==4){
				String lastName=vals[0];
				String email=vals[1];
				Integer gender=Integer.parseInt(vals[2]);
				Department department=new Department();
				department.setId(Integer.parseInt(vals[3]));
				Employee employee=new Employee(lastName, email, gender, department);
				System.out.println(source+"<------>"+employee);				
				return employee;
			}	
		}

		return null;
	}

}
