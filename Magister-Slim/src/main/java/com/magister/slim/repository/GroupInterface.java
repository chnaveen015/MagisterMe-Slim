package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.magister.slim.entity.Group;

public interface GroupInterface extends MongoRepository<Group,Integer>{

}
