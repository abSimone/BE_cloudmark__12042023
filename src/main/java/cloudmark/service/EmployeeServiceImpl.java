package cloudmark.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cloudmark.exception.InvalidRequestException;
import cloudmark.exception.RecordNotFoundException;
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
    public Employee saveEmployee(Employee employee) {
        if (employee != null) {
            // caso in cui viene passato id
            if (employee.getId() != null) {
                throw new InvalidRequestException(
                        "tried to create record",
                        employee.getLastName(),
                        "Id given"
                );
            } else {
                Employee insertedEmployee = employeeRepository.save(employee);

                for (Job job : employee.getJobs()) {
                    job.getEmployees().add(insertedEmployee);
                    jobRepository.save(job);
                }

                return insertedEmployee;

            }
        } else {
            throw new IllegalArgumentException("Employee cannot be null");
        }

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (employee.getId() == null) {
            throw new InvalidRequestException(
                    "tried to update record",
                    employee.getLastName(),
                    "Id not given"
            );
        }
        if (employeeRepository.existsById(employee.getId())) {
            return employeeRepository.save(employee);
        } else {
            throw new RecordNotFoundException(
                    "tried to update a non existing record",
                    employee.getLastName(),
                    "record not found"
            );
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
                deletionMap.put(true, "deleteEmployee success");

            } catch (IllegalArgumentException e) {
                deletionMap.put(false, "deleteEmployee error");
                e.printStackTrace();
            }

        } else {
            throw new RecordNotFoundException(
                    "tried to delete a non existing record",
                    Integer.toString(employeeId),
                    "record not found"
            );
        }

        return deletionMap;
    }

    @Override
    public Employee findEmployeeById(Integer employeeId) {
        if (!employeeRepository.existsById(employeeId))
            throw new RecordNotFoundException(
                    "tried to retrieve a non existing record",
                    Integer.toString(employeeId),
                    "record not found"
            );
        else {
            return employeeRepository.findById(employeeId).get();
        }
    }

    @Override
    public List<Employee> findByJobsId(Integer id) {
        if (!jobRepository.existsById(id))
            throw new RecordNotFoundException(
                    "tried to retrieve a non existing record",
                    Integer.toString(id),
                    "record not found"
            );
        return employeeRepository.findByJobsId(id);
    }

}