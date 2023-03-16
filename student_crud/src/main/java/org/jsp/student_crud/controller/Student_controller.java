package org.jsp.student_crud.controller;

import java.util.List;

import org.jsp.student_crud.Helper.ResponseStructure;
import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.service.Student_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student_controller {
	
	@Autowired
	Student_service service;
	
	@PostMapping("student")
	public ResponseStructure<Student>  saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	@PostMapping("students")
	public ResponseStructure<List<Student>>saveStudent(@RequestBody List<Student> students) {
		return service.saveStudents(students);
	}
//	fetch by id
	@GetMapping("student")
	public  ResponseStructure<Student> findById(@RequestParam int id) {
		return service.findbyId(id);
	}
//	fetch by name
	@GetMapping("studentname")
	public ResponseStructure<List<Student>> findByName(@RequestParam String name) {
		return service.findbyname(name);
	}
//	fetch by mobile
	@GetMapping("studentmobile")
	public ResponseStructure<Student> findByMobile(@RequestParam long mobile) {
		return service.findbymobile(mobile);
	}
////	fetch by percentage
//	@GetMapping("studentpercentage")
//	public ResponseStructure<Student> fetchByPercentage(@RequestParam double Percentage) {
//		return service.fetchbypercentage(Percentage);
//		
//	}
////	fetch by standard
//	@GetMapping("studentpercentage")
//	public ResponseStructure<Student> fetchByStandard(@RequestParam int standard) {
//		return service.fetchbyStandard(standard);
//	}
//	fetch by using id path variable
	@GetMapping("student/{id}")
	public ResponseStructure<Student> fetchbyIdPv(@PathVariable int id) {
		return  service.findbyId(id);
	}
//	fetch all students details (findAll method)
	@GetMapping("students")
	public ResponseStructure<List<Student>> findAll(){
		return service.findAll();
	}
	@GetMapping("students/firstclass")
	public ResponseStructure<List<Student>> findFirstclass(){
		return service.findFirstclass();
	}
	@DeleteMapping("student/{id}")
	public ResponseStructure<Student> deleteByd(@PathVariable int id ){
		return service.deleteById(id);
	}
	@PutMapping("student")
	public ResponseStructure<Student>  UpdateStudent(@RequestBody Student student) {
		return service.UpdateStudent(student);
   }
}
