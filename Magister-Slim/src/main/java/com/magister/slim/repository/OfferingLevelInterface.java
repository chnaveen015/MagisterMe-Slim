package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.magister.slim.entity.OfferingLevel;

public interface OfferingLevelInterface extends MongoRepository<OfferingLevel,Integer>{

}
