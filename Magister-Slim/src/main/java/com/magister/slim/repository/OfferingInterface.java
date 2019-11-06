package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.magister.slim.entity.Offering;

public interface OfferingInterface extends MongoRepository<Offering,Integer>{

}
