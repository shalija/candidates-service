package com.inpixon.interview.candidates.model;


import java.util.*;

public class Candidates {

    String transationId;
    List<Candidate> candidates;


    public String getTransationId() {
        return transationId;
    }

    public Candidates transationId(String transationId) {
        this.transationId = transationId;
        return this;
    }

    public List<Candidate> getCandidates() {

        return Optional.ofNullable(candidates).orElse(new ArrayList<>());
    }

    public Candidates candidates(List<Candidate> candidates) {
        this.candidates = candidates;
        return this;
    }
}
