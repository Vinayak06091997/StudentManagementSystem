package com.StudentMangmentSystem.Service;

import java.util.List;

import com.StudentMangmentSystem.Entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentByID(Long id);
	
	Student updateStudet(Student student);
	
	void removeStudent(long id);

}
