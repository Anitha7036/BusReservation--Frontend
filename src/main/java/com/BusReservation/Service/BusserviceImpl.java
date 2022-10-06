package com.busreservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.busreservation.repository.Busrepository;
import com.busreservation.entity.Busentity;
import com.busreservation.service.BusserviceImpl;
import com.busreservation.ResourceNotFoundException;
@Service
@Transactional

public class BusserviceImpl implements Busservice{
	 @Autowired
	    private Busrepository busRepository;

	    @Override
	    public Busentity createBus(Busentity bus) {
	        return busRepository.save(bus);
	    }

	    @Override
	    public Busentity updateBus(Busentity bus) {
	        Optional < Busentity > BusDb = this.busRepository.findById(bus.getId());

	        if (BusDb.isPresent()) {
	            Busentity busUpdate = BusDb.get();
	            busUpdate.setId(bus.getId());
	            busUpdate.setArrival(bus.getArrival());
	            busUpdate.setBusNo(bus.getBusNo());
	            busUpdate.setDeparture(bus.getDeparture());
	            busUpdate.setDestination(bus.getDestination());
	            busUpdate.setPrice(bus.getPrice());
	            busUpdate.setSource(bus.getSource());
	           
	            busRepository.save(busUpdate);
	            return busUpdate;
	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + bus.getId());
	            
	        }
	    }

	    @Override
	    public List < Busentity > getAllBus() {
	        return this.busRepository.findAll();
	    }

	    @Override
	    public Busentity getBusById(long BusId) {

	        Optional < Busentity > BusDb = this.busRepository.findById(BusId);

	        if (BusDb.isPresent()) {
	            return BusDb.get();
	        } 
	        else {
	            throw new ResourceNotFoundException("Record not found with id : " + BusId);
	        }
	    }

	    @Override
	    public void deleteBus(long BusId) {
	        Optional < Busentity > BusDb = this.busRepository.findById(BusId);

	        if (BusDb.isPresent()) {
	            this.busRepository.delete(BusDb.get());
	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + BusId);
	        }

	    }
}
