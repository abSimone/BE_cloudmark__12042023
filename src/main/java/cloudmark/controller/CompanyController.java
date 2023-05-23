package cloudmark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cloudmark.entity.Company;
import cloudmark.service.CompanyService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("api/company")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Company saveCompany(@Valid @RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Company updateCompany(@Valid @RequestBody Company company) {
        return companyService.updateCompany(company);
    }

    @DeleteMapping("/id/{companyId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteActor(@PathVariable Integer companyId) {
        return companyService.deleteCompany(companyId);
    }

    @GetMapping("/")
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @GetMapping("/customer-id/{customerId}")
    public Company findByCustomersId(@PathVariable Integer customerId){
        return companyService.findByCustomersId(customerId);
    }

}
