package cloudmark.service;

import java.util.Map;
import java.util.List;



import cloudmark.entity.Customer;

public interface CustomerService {

    public Customer saveCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public Map<Boolean,String> deleteCustomer(int id);

    public List<Customer> findAll();
    
}
