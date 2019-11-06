package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.magister.slim.entity.Unit;

public interface UnitInterface extends MongoRepository<Unit,Integer>{

}
