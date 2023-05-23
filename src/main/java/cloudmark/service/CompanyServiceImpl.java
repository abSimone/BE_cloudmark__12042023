package cloudmark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloudmark.entity.Company;
import cloudmark.exception.DuplicateRecordException;
import cloudmark.exception.IncorrectServiceException;
import cloudmark.exception.RecordNotFoundException;
import cloudmark.repository.CompanyRepository;


@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company saveCompany(Company company) {

        if (company.getId() != null) {
            throw new IncorrectServiceException(
                "this service cannot be used for update operations",
                "id", "id should be null"
            );
        }

        if (companyRepository.existsCompanyByCompanyName(company.getCompanyName())) {
            throw new DuplicateRecordException(
                "tried to insert an already existing record",
                company.getCompanyName(), "already exists"
            );
        }
        else {
            return companyRepository.save(company);
        }
        
    }

    @Override
    public Company updateCompany(Company company) {

        if (company.getId() == null) {
            throw new IncorrectServiceException(
                "this service cannot be used for insert operations",
                "id", "id cannot be null"
            );
        }

        if (companyRepository.existsById(company.getId())) {
            return companyRepository.save(company);
        }
        else {
            throw new RecordNotFoundException(
                "tried to update a non existing record",
                company.getCompanyName(), "record not found"
            );
        }
        
    }

    @Override
    public String deleteCompany(Integer companyId) {

        if (companyRepository.existsById(companyId)) {
            companyRepository.deleteById(companyId);
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
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findByCustomersId(Integer id) {
        return companyRepository.findByCustomersId(id);
    }
    
}