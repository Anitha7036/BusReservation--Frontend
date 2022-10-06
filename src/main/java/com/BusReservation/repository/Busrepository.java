package com.busreservation.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.busreservation.entity.Busentity;
public interface Busrepository extends MongoRepository < Busentity, Long >{

}
