package cloudmark.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cloudmark.exception.IncorrectServiceException;
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
                throw new IncorrectServiceException(
                        "tried to create record",
                        "id",
                        "Id given"
                );
            } else {
                Employee insertedEmployee = employeeRepository.save(employee);

                // creo una copia della lista degli employees per ciascun job
                Set<Employee> oldEmployees = new HashSet<Employee>();

                for (Job job : employee.getJobs()) {
                    // per ogni job prendo gli employees che già sono assegnati
                    oldEmployees = jobRepository.findById(job.getId()).get().getEmployees();
                    // aggiungo alla lista il nuovo employee
                    oldEmployees.add(insertedEmployee);
                    // setto la lista aggiornata al job
                    job.setEmployees(oldEmployees);
                    // aggiorno il job
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
            throw new IncorrectServiceException(
                    "tried to update record",
                    "id",
                    "Id not given"
            );
        }
        if (employeeRepository.existsById(employee.getId())) {

            Employee updatedEmployee = employeeRepository.save(employee);

            Set<Employee> oldEmployees = new HashSet<Employee>();

            for(Job job : employee.getJobs()) {
                oldEmployees = jobRepository.findById(job.getId()).get().getEmployees();
                oldEmployees.add(updatedEmployee);
                job.setEmployees(oldEmployees);

                jobRepository.save(job);
            }

            return updatedEmployee;


        } else {
            throw new RecordNotFoundException(
                    "tried to update a non existing record",
                    employee.getFirstName() + " " + employee.getLastName(),
                    "record not found"
            );
        }

    }

    @Override
    public String deleteEmployee(Integer employeeId) {

        if (employeeRepository.existsById(employeeId)) {
            // ciclo la lista dei jobs dell'employee da eliminare
            for(Job job : employeeRepository.findById(employeeId).get().getJobs()) {
                // prendo la lista degli employees prensenti per ogni job
                Set<Employee> oldEmployees = job.getEmployees();
                // rimuovo dalla lista l'employee da cancellare
                Employee employee = employeeRepository.findById(employeeId).get();
                oldEmployees.remove(employee);

                // setto la lista aggiornata al job
                job.setEmployees(oldEmployees);

            }
            employeeRepository.deleteById(employeeId);
            return "success";
        }
        else {
            throw new RecordNotFoundException(
                "tried to delete a non existing record",
                "id", "record not found"
            );
        }
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
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