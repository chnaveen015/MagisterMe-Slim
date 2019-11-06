package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.magister.slim.entity.Assignment;

public interface AssignmentInterface extends MongoRepository<Assignment,Integer>{

}
