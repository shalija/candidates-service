package com.inpixon.interview.candidates.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatesRepository extends MongoRepository<CandidateProfile, String> {
}
