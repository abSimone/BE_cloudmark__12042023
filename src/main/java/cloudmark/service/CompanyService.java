package cloudmark.service;

import java.util.List;

import cloudmark.entity.Company;


public interface CompanyService {
    
    Company saveCompany(Company company);

    Company updateCompany(Company company);

    String deleteCompany(Integer companyId);

    List<Company> findAll();

    Company findByCustomersId(Integer id);

}
