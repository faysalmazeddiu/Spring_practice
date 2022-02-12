package com.sazedexpress.smh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sazedexpress.smh.model.Employee;
import com.sazedexpress.smh.services.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService emplService;
	@GetMapping("/employeeEntryPage")
	public String employeeEntryPage(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "employee-entry";
	}
	
	@PostMapping("/insertEmployee")
	public String insertEmployee(Employee employee,Model model) {
		String message="";
		if (employee.getEmp_id()==0) {
			message=emplService.saveEmployee(employee);
		}else {
			message=emplService.updateEmployee(employee);
		}
		model.addAttribute("message", message);
		return "redirect:/allEmployee";
		
	}
	
	@GetMapping("/allEmployee")
	public String allEmployee(Model model) {
		List<Employee> employeeList=emplService.employeesList();
		model.addAttribute("employeeList", employeeList);
		return "employee-list";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("empId") int empId,Model model) {
		String message=emplService.deleteEmployeeById(empId);
		List<Employee> employeeList=emplService.employeesList();
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("message",message);
		return "employee-list";
	}
	
	@GetMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("empId") int empId,Model model) {
		Employee employee=emplService.employeeInfoById(empId);
		model.addAttribute("employee", employee);
		//return "redirect:/employeeEntryPage";
		return "employee-entry";
	}

}
