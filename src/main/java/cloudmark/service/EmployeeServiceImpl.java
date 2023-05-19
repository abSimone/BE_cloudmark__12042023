package cloudmark.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloudmark.entity.Employee;
import cloudmark.entity.Job;
import cloudmark.repository.EmployeeRepository;
import cloudmark.repository.JobRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JobRepository jobRepository;

    /*
     * abbiamo definito che non è possibile inserire employee
     * con associate commesse che non esistono sul db
     */
    @Override
    public Employee saveOrUpdateEmployee(Employee employee) {
        if (employee != null) {
            Employee insertedEmployee = employeeRepository.save(employee);

            for (Job job : employee.getJobs()) {
                job.getEmployees().add(insertedEmployee);
                jobRepository.save(job);
            }

            return insertedEmployee;
        } else {
            // questa risposta sarebbe da gestire
            throw new IllegalArgumentException("Employee cannot be null");
        }

    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Map<Boolean, String> deleteEmployee(Integer employeeId) {

        Map<Boolean, String> deletionMap = new HashMap<>();

        if (employeeRepository.existsById(employeeId)) {

            try {
                employeeRepository.deleteById(employeeId);
                deletionMap.put(true, "cancellazione effettuata");

            } catch (IllegalArgumentException e) {
                deletionMap.put(false, "cancellazione non effettuata");
                e.printStackTrace();
            }

        } else {
            deletionMap.put(false, "employeeId non esistente nel database");
        }

        return deletionMap;
    }

    @Override
    public Employee findEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public List<Employee> findByJobsId(Integer id) {
        return employeeRepository.findByJobsId(id);
    }

}