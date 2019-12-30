package com.inpixon.interview.candidates.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Candidate {

    String candidateId;
    String candidateName;
    List<String> jobIds;
    String currentLocation;
    double expectedSalary;
    List<Employer> employers;


    public String getCandidateId() {
        return candidateId;
    }

    public Candidate candidateId(String candidateId) {
        this.candidateId = candidateId;
        return this;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public Candidate candidateName(String candidateName) {
        this.candidateName = candidateName;
        return this;
    }

    public List<String> getJobIds() {
        return Optional.ofNullable(jobIds).orElse(new ArrayList<>());
    }

    public Candidate jobIds(List<String> jobIds) {
        this.jobIds = jobIds;
        return this;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public Candidate currentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
        return this;
    }

    public double getExpectedSalary() {
        return expectedSalary;
    }

    public Candidate expectedSalary(double expectedSalary) {
        this.expectedSalary = expectedSalary;
        return this;
    }

    public List<Employer> getEmployers() {
        return Optional.ofNullable(employers).orElse(new ArrayList<>());
    }

    public Candidate employers(List<Employer> employers) {
        this.employers = employers;

        return this;

    }
}
