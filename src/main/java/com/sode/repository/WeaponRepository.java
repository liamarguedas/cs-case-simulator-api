package com.sode.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sode.domain.Weapon;

@Repository
public interface WeaponRepository extends MongoRepository<Weapon, String> {

}
