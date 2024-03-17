package com.StudentMangmentSystem.Service.Imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.StudentMangmentSystem.Entity.Student;
import com.StudentMangmentSystem.Repository.StudentRepository;
import com.StudentMangmentSystem.Service.StudentService;

@Service
public class StudentServiceImpl  implements StudentService{

	private StudentRepository studentRepository;
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	//To get all the list of students
	public List<Student> getAllStudents() 
	{
		List<Student> allStudent=studentRepository.findAll();
		return allStudent;
	}
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	@Override
	public Student getStudentByID(Long id) {
		
		return studentRepository.findById(id).get();
	}
	@Override
	public Student updateStudet(Student student) {
	
		return studentRepository.save(student);
	}
	@Override
	public void removeStudent(long id) {
		studentRepository.deleteById(id);
		
	}

}
