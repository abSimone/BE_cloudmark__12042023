package cloudmark.service;

import java.util.Map;
import java.util.List;

import cloudmark.entity.Job;

public interface JobService {

    public Job saveJob(Job job);

    public Job updateJob(Job job);

    public Map<Boolean,String> deleteJob(Integer id);

    public List<Job> findAll();

    public Job findJobById(Integer id);

    


    
}
