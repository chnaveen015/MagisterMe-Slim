package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.magister.slim.entity.Theme;

public interface ThemeInterface extends MongoRepository<Theme,Integer>{

}
