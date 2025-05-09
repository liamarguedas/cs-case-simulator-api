package com.sode.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sode.domain.Skin;

@Repository
public interface SkinRepository extends MongoRepository<Skin, String> {

}
