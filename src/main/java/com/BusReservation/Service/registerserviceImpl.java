package com.busreservation.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busreservation.ResourceNotFoundException;

import com.busreservation.entity.registerentity;
import com.busreservation.repository.registerrepository;




@Service
@Transactional
public class registerserviceImpl implements registerservice {
	 @Autowired
	    private registerrepository userRepository;

	    @Override
	    public registerentity createUser(registerentity user) {
	        return userRepository.save(user);
	    }

	    @Override
	    public registerentity updateUser(registerentity user) {
	        Optional < registerentity > userDB = this.userRepository.findById(user.getId());

	        if (userDB.isPresent()) {
	        	registerentity userUpdate = userDB.get();
	        	userUpdate.setId(user.getId());
	        	userUpdate.setEmail(user.getEmail());
	        	userUpdate.setPassword(user.getPassword());
	        	userRepository.save(userUpdate);
	            return userUpdate;
	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + user.getId());
	        }
	    }

	    @Override
	    public List < registerentity > getAllUser() {
	        return this.userRepository.findAll();
	    }

	    @Override
	    public registerentity getUserById(long userId) {

	        Optional < registerentity > userDB = this.userRepository.findById(userId);

	        if (userDB.isPresent()) {
	            return userDB.get();
	        } 
	        else {
	            throw new ResourceNotFoundException("Record not found with id : " + userId);
	        }
	    }

	    @Override
	    public void deleteUser(long userId) {
	        Optional < registerentity > userDB = this.userRepository.findById(userId);

	        if (userDB.isPresent()) {
	            this.userRepository.delete(userDB.get());
	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + userId);
	        }

	    }
	    
	    
	  
}
