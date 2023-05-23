package cloudmark.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloudmark.entity.Company;
import cloudmark.entity.Customer;
import cloudmark.exception.IncorrectServiceException;
import cloudmark.exception.RecordNotFoundException;
import cloudmark.repository.CompanyRepository;
import cloudmark.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        //gestione caso in cui viene passato id 
        if(customer.getId()!=null){
            throw new IncorrectServiceException(
                "tried to create record",
                "id",
                "Id given");
        }
        else{
            Customer insertedCustomer = customerRepository.save(customer);

            Set<Customer> oldCustomers=new HashSet<Customer>();

            System.out.println(customer.getCompanies());

            for (Company company : customer.getCompanies()) {
                
                //per ogni company prende i customers già esistenti
                oldCustomers=companyRepository.findById(company.getId()).get().getCustomers();
                //aggiunge il customer attuale
                oldCustomers.add(insertedCustomer);
                //assegna a company i customer vecchi + quello nuovo
                company.setCustomers(oldCustomers);

                companyRepository.save(company);
            }
            

            return insertedCustomer;
        }
    } 

    @Override
    public Customer updateCustomer(Customer customer) {
        if(customer.getId()==null){
            throw new IncorrectServiceException(
                "tried to update record",
                "id",
                "Id not given");
        }
        if (customerRepository.existsById(customer.getId())) {
            Customer updatedCustomer=customerRepository.save(customer);

            Set<Customer> oldCustomers=new HashSet<Customer>();

            System.out.println(customer.getCompanies());

            for (Company company : customer.getCompanies()) {
                
                //per ogni company prende i customers già esistenti
                oldCustomers=companyRepository.findById(company.getId()).get().getCustomers();
                //aggiunge il customer attuale
                oldCustomers.add(updatedCustomer);
                //assegna a company i customer vecchi + quello nuovo
                company.setCustomers(oldCustomers);

                companyRepository.save(company);
            }
            return updatedCustomer;
        }
        else {
            throw new RecordNotFoundException(
                "tried to update a non existing record",
                customer.getCustomerName(), 
                "record not found"
            );
        }
    }

    @Override
    public String deleteCustomer(int id) {
        if (customerRepository.existsById(id)) {
            for(Company company: customerRepository.findById(id).get().getCompanies()){
                Set<Customer> oldCustomers=new HashSet<Customer>();
                oldCustomers=company.getCustomers();
                Customer customer=customerRepository.findById(id).get();
                oldCustomers.remove(customer);

                company.setCustomers(oldCustomers);
            }
            customerRepository.deleteById(id);
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
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByCustomerName(String customerName) {
        return customerRepository.findByCustomerName(customerName);
    }

    @Override
    public Customer findByVatNumber(String vatNumber) {
        return customerRepository.findByVatNumber(vatNumber);
    }

    @Override
    public Customer findById(Integer id) {
        if(customerRepository.existsById(id)){
            return customerRepository.findById(id).get();
        }
        else{
            throw new RecordNotFoundException(
                    "tried to retrieve a non existing record",
                    Integer.toString(id),
                    "record not found"
            );
        }
    }
   
}