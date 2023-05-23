package cloudmark.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloudmark.entity.Customer;
import cloudmark.exception.InvalidRequestException;
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
            throw new InvalidRequestException(
                "tried to create record",
                customer.getCustomerName(),
                "Id given");
        }
        else{
            return customerRepository.save(customer);
        }
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if(customer.getId()==null){
            throw new InvalidRequestException(
                "tried to update record",
                customer.getCustomerName(),
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
    public Map<Boolean, String> deleteCustomer(int id) {
        Map<Boolean,String> deleteMap = new HashMap<>();
        if(customerRepository.existsById(id)){
            try{
                customerRepository.deleteById(id);
                deleteMap.put(true, "deleteCustomer success");
            }
            catch(IllegalArgumentException e){
                deleteMap.put(false, "deleteCustomer error");
            }
        }
        else{
            //deleteMap.put(false, "customer not exist");
            throw new RecordNotFoundException(
                "tried to delete a non existing record",
                Integer.toString(id), 
                "record not found"
            );
        }

        return deleteMap;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByCustomerName(String customerName) {
        
        Customer customer= customerRepository.findByCustomerName(customerName);
        if(customer!=null){
            return customer;
        }
        else{
            throw new RecordNotFoundException(
                    "tried to retrieve a non existing record",
                    customerName,
                    "record not found"
            );
        }
    }

    @Override
    public Customer findByVatNumber(String vatNumber) {
        Customer customer= customerRepository.findByVatNumber(vatNumber);
        if(customer!=null){
            return customer;
        }
        else{
            throw new RecordNotFoundException(
                    "tried to retrieve a non existing record",
                    vatNumber,
                    "record not found"
            );
        }
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
