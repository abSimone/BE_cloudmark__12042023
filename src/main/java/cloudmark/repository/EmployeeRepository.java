package cloudmark.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import cloudmark.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

     List<Employee> findByJobsId(Integer id);
    
}




