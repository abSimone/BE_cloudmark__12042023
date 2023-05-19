package cloudmark.service;

import java.util.List;
import java.util.Map;

import cloudmark.entity.Company;


public interface CompanyService {
    
    Company saveCompany(Company company);

    Company updateCompany(Company company);

    Map<Boolean,String> deleteCompany(Integer companyId);

    List<Company> findAll();

    Company findByCustomersId(Integer id);

}
