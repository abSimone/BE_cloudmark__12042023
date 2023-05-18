package cloudmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloudmark.entity.Company;


public interface CompanyRepository extends JpaRepository<Company,Integer> {

    Company findByCustomersId(Integer id);
       
}