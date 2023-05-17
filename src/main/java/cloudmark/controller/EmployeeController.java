package cloudmark.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloudmark.entity.Employee;
import cloudmark.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

   
    @PostMapping("/")
    public Employee saveEmployee(@RequestBody Employee employee) {

        return employeeService.saveOrUpdateEmployee(employee); // INSERT

    }

    @PutMapping("/")
    public Employee updateCompany(@RequestBody Employee employee) {
        return employeeService.saveOrUpdateEmployee(employee);
    }

    @GetMapping("/")
    public List<Employee> findAllCompanies() {

        return employeeService.findAllEmployees();
    }

    @DeleteMapping("/{employeeId}")
    public Map<Boolean, String> removeCompany(@PathVariable Integer employeeId) {

        return employeeService.deleteEmployee(employeeId);
    }

    @GetMapping("/vat-number/{employeeId}")
	public Employee findCompanyByVatNumber(@PathVariable Integer employeeId) {
		
		return employeeService.findEmployeeById(employeeId);
		
	}
}