package cloudmark.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloudmark.entity.Company;
import cloudmark.repository.CompanyRepository;


@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Map<Boolean, String> deleteCompany(Integer companyId) {
        
        Map<Boolean,String> deleteMap = new HashMap<>();

        if (companyRepository.existsById(companyId)) {
            try {
                companyRepository.deleteById(companyId);
                deleteMap.put(true, "deleteActor success");
            }
            catch (IllegalArgumentException e) {
                deleteMap.put(false, "deleteActor error");
            }
        }
        else {
            deleteMap.put(false, "non-existent actor");
        }

        return deleteMap;

    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
    
}