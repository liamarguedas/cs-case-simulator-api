package com.sode.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sode.domain.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

}
