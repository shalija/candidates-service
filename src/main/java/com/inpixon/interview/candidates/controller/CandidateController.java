package com.inpixon.interview.candidates.controller;

import com.inpixon.interview.candidates.data.CandidateProfile;
import com.inpixon.interview.candidates.model.Candidates;
import com.inpixon.interview.candidates.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/candidates")
public class CandidateController {
    @Autowired
    CandidateService candidateService;

    @GetMapping
    Candidates getCandidates(){
        String transationId= UUID.randomUUID().toString();
        //TODO
        //Pagination
        // Error Response Message
        return new Candidates().transationId(transationId).candidates(candidateService.getCandidates());
    }











}
