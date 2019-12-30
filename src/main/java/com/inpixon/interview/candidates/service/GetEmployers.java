package com.inpixon.interview.candidates.service;

import com.inpixon.interview.candidates.model.Employer;
import com.inpixon.interview.candidates.model.EmployerList;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class GetEmployers {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand
            (fallbackMethod = "getDefaultEmployer",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value="6"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value="6000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="50")
            }
    )
    public List<Employer> getEmployers(String candidateId){
        //url should not hard coded
        EmployerList response= restTemplate.getForObject("http://Employers-Service/employers/candidate/{candidateId}", EmployerList.class,candidateId);
          return    response.getEmployers();
    }

      public List<Employer> getDefaultEmployer(String candidateId)
      {
          Employer employer=new Employer();
          employer.setCompanyName("not available");
          employer.setJobLocation("not available");
          employer.setJobTitle("not available");
          employer.setSalary(0.0);
          return Arrays.asList(employer);
      }
}
