package cloudmark.service;

import java.util.List;
import cloudmark.entity.Employee;


public interface EmployeeService {

    public Employee saveEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);

    public List<Employee> findAllEmployees();

    public String deleteEmployee(Integer employeeId);

    public Employee findEmployeeById(Integer employeeId);

    public List<Employee> findByJobsId(Integer id);

}