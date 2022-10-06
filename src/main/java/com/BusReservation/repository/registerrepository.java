package com.busreservation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.busreservation.entity.registerentity;

public interface registerrepository extends MongoRepository < registerentity, Long >{


}
