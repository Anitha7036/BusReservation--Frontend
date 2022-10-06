package com.BusReservation.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.BusReservation.entity.CustomerEntity;

public interface CustomerRepository extends MongoRepository < CustomerEntity, Long >{

}
