package org.jsp.student_crud.repository;

import java.util.List;

import org.jsp.student_crud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{
List<Student> findByName(String name);
	Student findByMobile(long mobile);
//	Student findbyPercentage(double percentage);
//	Student findbyStandard(int standard);
	@Query("select x from Student x where percentage>=60 and percentage<=85")
	List<Student> findFirstclass();
Object save (Integer id);
}
