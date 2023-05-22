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
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {

        return employeeService.saveEmployee(employee); // INSERT

    }

    @PutMapping("/")
    public Employee updateEmployee(@Valid @RequestBody Employee employee) {

        return employeeService.updateEmployee(employee); // UPDATE
    }

    @GetMapping("/")
    public List<Employee> findAllEmployees() {

        return employeeService.findAllEmployees();
    }

    @DeleteMapping("/id/{employeeId}")
    public Map<Boolean, String> deleteEmployee(@PathVariable Integer employeeId) {

        return employeeService.deleteEmployee(employeeId);
    }

    @GetMapping("/id/{employeeId}")
    public Employee findEmployeeById(@PathVariable Integer employeeId) {

        return employeeService.findEmployeeById(employeeId);

    }

    @GetMapping("/job-id/{jobsId}")
    public List<Employee> findEmployeeByJobsId(@PathVariable Integer jobsId) {

        return employeeService.findByJobsId(jobsId);

    }

}