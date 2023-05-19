package cloudmark.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloudmark.entity.Job;
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
        if (job != null) {
            return jobRepository.save(job);
        } else {
            // risposta da sistemare con le eccezioni
            throw new IllegalArgumentException("Job cannot be null");
        }
    }

    @Override
    public Job updateJob(Job job) {
        if (job != null) {
            return jobRepository.save(job);
        } else {
            throw new IllegalArgumentException("Job cannot be null");
        }

    }

    @Override
    public Map<Boolean, String> deleteJob(int id) {
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
