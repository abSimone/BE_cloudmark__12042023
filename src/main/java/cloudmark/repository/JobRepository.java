package cloudmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloudmark.entity.Job;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Integer>{

    public List<Job> findByCustomer_Id(Integer customerId);
    
}
