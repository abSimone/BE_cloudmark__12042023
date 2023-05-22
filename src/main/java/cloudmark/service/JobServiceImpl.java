package cloudmark.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloudmark.entity.Job;
import cloudmark.exception.InvalidRequestException;
import cloudmark.exception.RecordNotFoundException;
import cloudmark.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    /*
     * abbiamo definito che i job vengono create e che solo
     * successivamente
     * vi si associano dei employees. Ovvero non si verifica il caso in cui si
     * inserisca una job con dei employees associati che non sono presenti su db;
     * Inoltre il customer  della commessa deve essere già presente sul db ovviamente.
     */
    @Override
    public Job saveJob(Job job) {
        if(job.getId()!=null){
            throw new InvalidRequestException(
                "tried to create record",
                job.getDescription(),
                "Id given");
        }
        else{
            return jobRepository.save(job);
        }
    }

    @Override
    public Job updateJob(Job job) {
        if(job.getId()==null){
            throw new InvalidRequestException(
                "tried to update record",
                job.getDescription(),
                "Id not given");
        }
        if(jobRepository.existsById(job.getId())){
            Job jobUpdated= jobRepository.save(job);
            return jobUpdated;
        }
        else{
            throw new RecordNotFoundException(
                "tried to update a non existing record",
                job.getDescription(),
                "record not found");
        }
    }

    @Override
    public Map<Boolean, String> deleteJob(Integer id) {
        Map<Boolean, String> deleteMap = new HashMap<>();

        if (jobRepository.existsById(id)) {
            try {
                jobRepository.deleteById(id);
                deleteMap.put(true, "deleteJob success");
            } catch (IllegalArgumentException e) {
                deleteMap.put(false, "deleteJob error");
            }
        } else {
            deleteMap.put(false, "job not exist");
        }
        return deleteMap;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

}
