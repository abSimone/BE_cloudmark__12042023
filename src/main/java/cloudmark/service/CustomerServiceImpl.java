package cloudmark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloudmark.entity.Customer;
import cloudmark.exception.IncorrectServiceException;
import cloudmark.exception.RecordNotFoundException;
import cloudmark.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

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
            return customerRepository.save(customer);
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
            return customerRepository.save(customer);
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