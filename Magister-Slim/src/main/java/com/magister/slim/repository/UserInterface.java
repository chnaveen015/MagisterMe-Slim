package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.magister.slim.entity.User;

public interface UserInterface extends MongoRepository<User,Integer>{

}
