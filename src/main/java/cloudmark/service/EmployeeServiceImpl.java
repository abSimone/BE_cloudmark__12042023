package cloudmark.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloudmark.entity.Employee;
import cloudmark.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveOrUpdateEmployee(Employee employee) {
        return employeeRepository.save(employee);
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

  


}