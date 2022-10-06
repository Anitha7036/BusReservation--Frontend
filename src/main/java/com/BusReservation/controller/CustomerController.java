package com.BusReservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BusReservation.Service.CustomerService;
import com.BusReservation.entity.CustomerEntity;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
    private CustomerService customerService;

    @GetMapping("/Customer")
    public ResponseEntity < List < CustomerEntity >> getAllCustomer() {
        return ResponseEntity.ok().body(customerService.getAllCustomer());
    }

    @GetMapping("/Customer/{id}")
    public ResponseEntity < CustomerEntity > getCustomerById(@PathVariable long id) {
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }

    @PostMapping("/{Customer}")
    public ResponseEntity < CustomerEntity > createCustomer(@RequestBody CustomerEntity customer) {
        return ResponseEntity.ok().body(this.customerService.createCustomer(customer));
    }

    @PutMapping("/Customer/{id}")
    public ResponseEntity < CustomerEntity > updateCustomer(@PathVariable long id, @RequestBody CustomerEntity customer) {
        customer.setId(id);
        return ResponseEntity.ok().body(this.customerService.updateCustomer(customer));
    }
    
    @DeleteMapping("/Customer/{id}")
    public HttpStatus deleteProduct(@PathVariable long id) {
        this.customerService.deleteCustomer(id);
        return HttpStatus.OK;
    }

}
