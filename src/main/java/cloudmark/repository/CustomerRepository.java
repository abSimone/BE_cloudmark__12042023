package cloudmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloudmark.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
    
    public Customer findByCustomerName(String customerName);

    public Customer findByVatNumber(String vatNumber);
}
