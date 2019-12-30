package com.inpixon.interview.candidates.service;

import com.inpixon.interview.candidates.data.CandidateProfile;
import com.inpixon.interview.candidates.data.CandidatesRepository;
import com.inpixon.interview.candidates.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateService {

    @Autowired
    CandidatesRepository candidatesRepository;
    @Autowired
    GetEmployers getEmployers;

    public List<Candidate> getCandidates() {
        List<CandidateProfile> candidateProfiles = candidatesRepository.findAll();

        return candidateProfiles.stream().parallel().map(candidateProfile ->
                new Candidate().candidateId(candidateProfile.getCandidateId())
                        .candidateName(candidateProfile.getCandidateName())
                        .currentLocation(candidateProfile.getCurrentLocation())
                        .expectedSalary(candidateProfile.getExpectedSalary())
                        .jobIds(candidateProfile.getJobIds())
                        .employers(getEmployers.getEmployers(candidateProfile.getCandidateId())))
                .collect(Collectors.toList());
    }

}
