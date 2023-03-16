package org.jsp.student_crud.service;


import java.util.List;

import org.jsp.student_crud.Helper.ResponseStructure;
import org.jsp.student_crud.dao.Studentdao;
import org.jsp.student_crud.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class Student_service {
	@Autowired
	Studentdao dao;
	

	public ResponseStructure<Student> saveStudent(Student student) {
		student.setPercentage((student.getEnglish_marks()+student.getHindi_marks()+student.getMaths_marks())/3);
		ResponseStructure<Student> structure= new ResponseStructure<Student>();
		structure.setMessage("Data save successfully");
		structure.setData(dao.saveStudent(student));
		structure.setCode(HttpStatus.CREATED.value());
		
			return structure;
			
	}
	public ResponseStructure<List<Student>> saveStudents(List<Student>students){
		for(Student student:students) {
			student.setPercentage((student.getEnglish_marks()+student.getHindi_marks()+student.getMaths_marks())/3);
		}
			ResponseStructure<List<Student>> structure=new ResponseStructure<>();
			structure.setMessage("Data Saved Successfully");
			structure.setData((List<Student>) dao.saveStudent(students));
			structure.setCode(HttpStatus.CREATED.value());
	
		return structure;
		}
		
	public ResponseStructure<Student> findbyId (int id) { 
		Student student =dao.findById(id);
		ResponseStructure<Student> structure=new ResponseStructure<Student>();
		
		if(student==null)
		{
			structure.setMessage("Data not found");
			structure.setData(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		else {
			structure.setMessage("data found");
			structure .setData(student);
			structure.setCode(HttpStatus.FOUND.value());
		}
			return structure;
		}
	
	public ResponseStructure<List<Student>>findbyname(String name) {
		List<Student> list=dao.findByname(name);
		ResponseStructure<List<Student>> structure=new ResponseStructure<List<Student>>();
		if(list.isEmpty()) {
			structure.setMessage("Data not found");
			structure.setData(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		else {
			structure.setMessage("Data found");
			structure.setData(list);
			structure.setCode(HttpStatus.FOUND.value());
		}
		return structure;
	}
	public ResponseStructure<Student> findbymobile(long mobile) {
		Student student =dao.findByMobile(mobile);
		ResponseStructure<Student> structure=new ResponseStructure<Student>();
		
		if(student==null)
		{
			structure.setMessage("Data not found");
			structure.setData(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		else {
			structure.setMessage("data found");
			structure .setData(student);
			structure.setCode(HttpStatus.FOUND.value());
		}
			return structure;
	}

	public ResponseStructure<List<Student>> findAll() {
		List<Student> list=dao.findAll();
		ResponseStructure<List<Student>> structure=new ResponseStructure<List<Student>>();
		if(list.isEmpty()) {
			structure.setMessage("Data not found");
			structure.setData(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		else {
			structure.setMessage("Data found");
			structure.setData(list);
			structure.setCode(HttpStatus.FOUND.value());
		}
		return structure;	
	}
	public ResponseStructure<List<Student>> findFirstclass() {
		List<Student> list=dao.findAll();
		ResponseStructure<List<Student>> structure=new ResponseStructure<List<Student>>();
		if(list.isEmpty()) {
			structure.setMessage("Data not found");
			structure.setData(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		else {
			structure.setMessage("Data found");
			structure.setData(list);
			structure.setCode(HttpStatus.FOUND.value());
		}
		return structure;	
	}
	public ResponseStructure<Student> deleteById(int id) {
		Student student =dao.findById(id);
		ResponseStructure<Student> structure=new ResponseStructure<Student>();
		
		if(student==null)
		{
			structure.setMessage("Data not found");
			structure.setData(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		else {
			dao.deleteById(id);
			structure.setMessage("Data Deleted Successfully");
			structure .setData(student);
			structure.setCode(HttpStatus.OK.value());
		}
			return structure;
		}
	public ResponseStructure<Student> UpdateStudent(Student student) {
		student.setPercentage((student.getEnglish_marks()+student.getHindi_marks()+student.getMaths_marks())/3);
		ResponseStructure<Student> structure= new ResponseStructure<Student>();
		structure.setMessage("Data updated successfully");
		structure.setData(dao.saveStudent(student));
		structure.setCode(HttpStatus.ACCEPTED.value());
		
			return structure;
	}
	

	
	
	
	}
	

	
	
	
	

