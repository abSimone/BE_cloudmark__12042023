package cloudmark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloudmark.entity.Job;
import cloudmark.exception.IncorrectServiceException;
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
            throw new IncorrectServiceException(
                "tried to create record",
                "id",
                "Id given");
        }
        else{
            return jobRepository.save(job);
        }
    }

    @Override
    public Job updateJob(Job job) {
        if(job.getId()==null){
            throw new IncorrectServiceException(
                "tried to update record",
                "id",
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
    public String deleteJob(Integer id) {

        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
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
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job findJobById(Integer id) {
        if(jobRepository.existsById(id)){
            return jobRepository.findById(id).get();
        }
        else{
            throw new RecordNotFoundException(
                    "tried to retrieve a non existing record",
                    Integer.toString(id),
                    "record not found"
            );
        }
    }

}
