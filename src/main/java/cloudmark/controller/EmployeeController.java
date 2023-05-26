package cloudmark.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import cloudmark.util.CsvFileGenerator;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CsvFileGenerator csvGenerator;

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
    public String deleteEmployee(@PathVariable Integer employeeId) {

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

    @GetMapping("/csv")
    public void getEmployeesCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.addHeader("Content-Disposition", "attachment; filename=\"employees.csv\"");
        csvGenerator.writeEmployeeToCsv(findAllEmployees(), response.getWriter());
    }

}