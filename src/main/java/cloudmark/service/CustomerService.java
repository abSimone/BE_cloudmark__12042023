package cloudmark.service;

import java.util.List;



import cloudmark.entity.Customer;

public interface CustomerService {

    public Customer saveCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public String deleteCustomer(int id);

    public List<Customer> findAll();

    public Customer findByCustomerName(String customerName);

    public Customer findByVatNumber(String vatNumber);

    public Customer findById(Integer id);
    
}
