package com.BusReservation.Service;
import java.util.List;

import com.BusReservation.entity.CustomerEntity;

public interface CustomerService {
	CustomerEntity createCustomer(CustomerEntity customer);

	CustomerEntity updateCustomer(CustomerEntity customer);

    List < CustomerEntity > getAllCustomer();

    CustomerEntity getCustomerById(long customerId);

    void deleteCustomer(long id);

}
