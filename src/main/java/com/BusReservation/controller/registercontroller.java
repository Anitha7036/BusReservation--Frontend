package com.busreservation.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.busreservation.entity.registerentity;
import com.busreservation.service.registerservice;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class registercontroller {
	 @Autowired
	    private registerservice userService;
	 	
	    @GetMapping("/users")
	    public ResponseEntity < List < registerentity >> getAllUser() {
	        return ResponseEntity.ok().body(userService.getAllUser());
	    }

	    @GetMapping("/users/{id}")
	    public ResponseEntity < registerentity > getProductById(@PathVariable long id) {
	        return ResponseEntity.ok().body(userService.getUserById(id));
	    }

	    @PostMapping("/users")
	    public ResponseEntity < registerentity > createProduct(@RequestBody registerentity user) {
	        return ResponseEntity.ok().body(this.userService.createUser(user));
	    }

	    @PutMapping("/users/{id}")
	    public ResponseEntity < registerentity > updateProduct(@PathVariable long id, @RequestBody registerentity user) {
	        user.setId(id);
	        return ResponseEntity.ok().body(this.userService.updateUser(user));
	    }

	    @DeleteMapping("/users/{id}")
	    public HttpStatus deleteProduct(@PathVariable long id) {
	        this.userService.deleteUser(id);
	        return HttpStatus.OK;
	    }
	    
	    
	    
}
