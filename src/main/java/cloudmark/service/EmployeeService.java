package cloudmark.service;

import java.util.List;
import java.util.Map;

import cloudmark.entity.Employee;

public interface EmployeeService {

    public Employee saveOrUpdateEmployee(Employee employee);
    public List<Employee> findAllEmployees();
    public Map<Boolean, String> deleteEmployee(Integer employeeId);
    public Employee findEmployeeById(Integer employeeId);
    
    
}