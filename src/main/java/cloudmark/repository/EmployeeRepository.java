package cloudmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloudmark.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
}




