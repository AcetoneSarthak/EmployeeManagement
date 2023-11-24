package employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import employeemanagement.entity.Employee;
import employeemanagement.exception.EmployeeException;
import employeemanagement.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empservice;
	
	@PostMapping("/addEmployee")
	public void addEmployee(@RequestBody Employee emp)
	{
		empservice.addEmployee(emp);
	}
	
	@PostMapping("/addEmployees")
	public void addEmployee(@RequestBody List<Employee> emplist)
	{
		for(Employee emp: emplist)
		{
			empservice.addEmployee(emp);
		}
		
	}
	

	@GetMapping("/getEmployees")
	public List<Employee> getEmployees()
	{
		
	    return empservice.getEmployees();
	}
	
	
	@GetMapping("/getEmployee/{empId}")
	public Optional<Employee> getEmployee(@PathVariable("empId") int empId) throws EmployeeException 
	{
			return empservice.getEmployee(empId);
		
	}
	
	@GetMapping("/deleteEmployee/{empId}")
	public void deleteEmployee(@PathVariable("empId") int empId)
	{
		empservice.deleteEmployee(empId);
	}
	
	@PostMapping("/updateEmployeeDetails")
	public void updateEmployeeDetails(@RequestBody Employee emp)
	{
		empservice.updateEmployeeDetails(emp);
	}
}
