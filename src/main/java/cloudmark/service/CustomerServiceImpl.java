package cloudmark.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloudmark.entity.Customer;
import cloudmark.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
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
            deleteMap.put(false, "customer not exist");
        }

        return deleteMap;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    
    
}
