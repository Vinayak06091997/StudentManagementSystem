package com.StudentMangmentSystem.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.StudentMangmentSystem.Entity.Student;
import com.StudentMangmentSystem.Service.StudentService;

@org.springframework.stereotype.Controller
public class StudentController {
	
	private StudentService studentService; 
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}


	@GetMapping("/students")
	public String listOfStudent(Model model)
	{
		model.addAttribute("student", studentService.getAllStudents());
		return "studentlList";
	}
	
	@GetMapping("/students/new")
	public  String CreateStudentForm(Model model)
	{
		Student student =new Student();
		model.addAttribute("student",student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudnet(@ModelAttribute("student") Student student)
	{
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable long id,Model model)
	{
		model.addAttribute("student" ,studentService.getStudentByID(id) );
		return "edit_student";
	}
	
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model)
	{
		//get student 
		Student  existingStudent=studentService.getStudentByID(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		
		// save
		studentService.saveStudent(existingStudent);
		return "redirect:/students";
	}
	
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable long id)
	{
		studentService.removeStudent(id);
		return "redirect:/students";
	}

}
