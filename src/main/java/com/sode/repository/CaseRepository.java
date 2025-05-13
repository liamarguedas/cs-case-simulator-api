package com.sode.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sode.domain.Case;

@Repository
public interface CaseRepository extends MongoRepository<Case, String> {

}
