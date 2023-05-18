package cloudmark.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloudmark.entity.Job;
import cloudmark.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Map<Boolean, String> deleteJob(int id) {
        Map<Boolean,String> deleteMap=new HashMap<>();

        if(jobRepository.existsById(id)){
            try{
                jobRepository.deleteById(id);
                deleteMap.put(true, "deleteJob success");
            }
            catch(IllegalArgumentException e ){
                deleteMap.put(false, "deleteJob error");
            }
        }
        else{
            deleteMap.put(false, "job not exist");
        }
        return deleteMap;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }
    
}
