package cloudmark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloudmark.entity.Job;
import cloudmark.service.JobService;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/")
    public Job saveJob(@Valid @RequestBody Job job){
        return jobService.saveJob(job);
    }

    @PutMapping("/")
    public Job updateJob(@Valid @RequestBody Job job){
        return jobService.updateJob(job);
    }

    @DeleteMapping("/id/{jobId}")
    public String deleteJob(@PathVariable Integer jobId){
        return jobService.deleteJob(jobId);
    }

    @GetMapping("/")
    public List<Job> findAll(){
        return jobService.findAll();
    }

    @GetMapping("/id/{jobId}")
    public Job findJobById(@PathVariable Integer jobId){
        return jobService.findJobById(jobId);
    }

    @GetMapping("/customer-id/{customerId}")
    public List<Job> findJobsByCustomer(@PathVariable Integer customerId) { return jobService.findJobsByCustomer(customerId);}

    
}
