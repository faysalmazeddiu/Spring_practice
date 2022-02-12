package com.mazedexpress.sm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mazedexpress.sm.DAO.StudentDAO;
import com.mazedexpress.sm.DAO.StudentDAOImpl;
import com.mazedexpress.sm.api.Student;
import com.mazedexpress.sm.api.StudentDTO;
import com.mazedexpress.sm.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	// @RequestMapping(value = "/showStudent",method =RequestMethod.GET)

	@GetMapping("/showStudent")
	public String showStudentList(Model model) {
		List<Student> studentList = studentService.loadStudent();
		model.addAttribute("allStudents", studentList);
		return "student-list";
	}

	@GetMapping("/studentEntryPage")
	public String showStudentEntryPage(Model model) {

		// StudentDTO studentDTO=new StudentDTO();

		Student student = new Student();
		model.addAttribute("student", student);

		return "add-student";
	}

	//@ResponseBody
	//@GetMapping("/save-student")
	@PostMapping("/save-student")
	public String saveStudent(Student student) {

		// write the logic to save into database
		//System.out.println(student);
		// StudentDTO studentDTO=new StudentDTO();
		// model.addAttribute("student", studentDTO);
		if (student.getId()==0) {
			studentService.saveStudent(student);
		}else {
			studentService.updateStudentInfo(student);
		}
		

	    return "redirect:/showStudent";
		
	}
	
	
	 
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id, Model model) {
		Student studentInfo=studentService.getStudentById(id);
		model.addAttribute("student", studentInfo);
		//return "redirect:/studentEntryPage";
		return "add-student";
		
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id) {
		studentService.deleteStudent(id);
		return "redirect:/showStudent";
		
	}
	

	
	/*
	// new way to model binding
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id,@ModelAttribute("student") Student student) {
		Student studentInfo=studentService.getStudentById(id);
		//System.out.println("the user id for updating "+id);
		student.setId(studentInfo.getId());
		student.setNameString(studentInfo.getNameString());
		student.setMobile(studentInfo.getMobile());
		student.setCountry(studentInfo.getCountry());
		
		//System.out.println(studentInfo);
		return "add-student";
	}
	*/

}
