package cloudmark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloudmark.entity.Customer;
import cloudmark.service.CustomerService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public Customer saveCustomer(@Valid @RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/")
    public Customer updateCustomer(@Valid @RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/id/{customerId}")
    public String deleteCustomer(@PathVariable Integer customerId){
        return customerService.deleteCustomer(customerId);
    }

    @GetMapping("/")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/customer-name/{customerName}")
    public Customer findByCustomerName(@PathVariable String customerName){
        return customerService.findByCustomerName(customerName);
    }

    
    @GetMapping("/vat-number/{vatNumber}")
    public Customer findByVatNumber(@PathVariable String vatNumber){
        return customerService.findByVatNumber(vatNumber);
    }

    @GetMapping("/id/{id}")
    public Customer findById(@PathVariable Integer id){
        return customerService.findById(id);
    }
    

}
