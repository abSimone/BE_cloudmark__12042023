package cloudmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloudmark.entity.Job;

public interface JobRepository extends JpaRepository<Job,Integer>{
    
}
