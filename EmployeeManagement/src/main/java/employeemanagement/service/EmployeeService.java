package employeemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import employeemanagement.entity.Employee;
import employeemanagement.exception.EmployeeException;
import employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;
	
	List<Employee> emplist = new ArrayList<Employee>();
	
	public void addEmployee(Employee emp)
	{
		empRepo.save(emp);
	}
	
	
	
	
	public List<Employee> getEmployees()
	{
		emplist= empRepo.findAll();
		return emplist;
	}
	
	public Optional<Employee> getEmployee(int empId) throws EmployeeException 
	{
		Optional<Employee> emp = empRepo.findById(empId);
		if(emp.isPresent())
		{
			return emp;	
		}
		else
		{
			throw new EmployeeException("550", "Employee doesn't exists");
		}
		
		
	}
	
	public void deleteEmployee(int empId)
	{
		empRepo.deleteById(empId);
	}
	
	public void updateEmployeeDetails(Employee emp)
	{
		empRepo.save(emp);
	}
	
}
