package org.jsp.student_crud.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Studentdao {
	@Autowired
	StudentRepository repository;
	
	public Student saveStudent(Student student) {
		return repository.save(student);
	}
		public List<Student> saveStudent(List<Student> students) {
			return repository.saveAll(students);
	}
		public Student findById(int id) {
			Optional<Student> op=repository.findById(id);
			if(op.isPresent()) {
				return op.get();
			}else
				return null;
		}
		public List<Student> findByname(String name) {
			return repository.findByName(name);
			
		}
		public Student findByMobile(long mobile) {
			
			return repository.findByMobile(mobile);
		}
//		public Student findByPercentage(double percentage) {
//			return repository.findbyPercentage(percentage);
//		}
//		public Student findByStandard(int standard) {
//			
//			return repository.findbyStandard(standard);
//		}
		public List<Student> findAll() {
			
			return repository.findAll();
		}
		public List<Student>findFirstClass(){
			return repository.findFirstclass();
		}
		public void deleteById(int id) {
			repository.deleteById(id);
			
		}
		
	
	
		
	}
