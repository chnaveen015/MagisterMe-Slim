package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.magister.slim.entity.Resource;

public interface ResourceInterface extends MongoRepository<Resource,Integer>{

}
