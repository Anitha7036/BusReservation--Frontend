package com.BusReservation.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BusReservation.ResourceNotFoundException;
import com.BusReservation.entity.CustomerEntity;
import com.BusReservation.repository.CustomerRepository;

@Service
@Transactional

public class CustomerServiceImpl implements CustomerService {
 
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public CustomerEntity createCustomer(CustomerEntity customer) {
		return customerRepository.save(customer);
	}

	@Override
	public CustomerEntity updateCustomer(CustomerEntity customer) {
	Optional < CustomerEntity > CustomerDB= this.customerRepository.findById(customer.getId());
	
	if(CustomerDB.isPresent()) {
		CustomerEntity customerUpdate = CustomerDB.get();
		customerUpdate.setId(customer.getId());
		customerUpdate.setFirstname(customer.getFirstname());
		customerUpdate.setLastname(customer.getLastname());
		customerUpdate.setEmail(customer.getEmail());
		customerUpdate.setGender(customer.getGender());
		customerUpdate.setMobile(customer.getMobile());
		customerUpdate.setPassword(customer.getPassword());
		customerUpdate.setCity(customer.getCity());
		customerUpdate.setState(customer.getState());
		customerUpdate.setStreet(customer.getStreet());
		customerUpdate.setPincode(customer.getPincode());
		
		customerRepository.save(customerUpdate);
		return customerUpdate;
	} else {
		throw new ResourceNotFoundException("Record not found with id : " + customer.getId());
	}
	}

	@Override
	public List<CustomerEntity> getAllCustomer() {
		return this.customerRepository.findAll();
	}

	@Override
	public CustomerEntity getCustomerById(long customerId) {
		Optional < CustomerEntity > CustomerDB = this.customerRepository.findById(customerId);
		if ( CustomerDB.isPresent()) {
			return CustomerDB.get();
		}
		else {
			throw new ResourceNotFoundException("Record not found with id : " + customerId);
		}	
	}
		
	@Override
	public void deleteCustomer(long customerId) {
		Optional < CustomerEntity > CustomerDB = this.customerRepository.findById(customerId);
		if ( CustomerDB.isPresent()) {
			this.customerRepository.delete(CustomerDB.get());
		}
		else {
			throw new ResourceNotFoundException("Record not found with id : " + customerId);
		}	

	}

}
