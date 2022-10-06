//package com.busreservation.controller;

/*import java.util.List;
import org.springframework.ui.Model;

import com.busreservation.repository.loginrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;*/
/*import org.springframework.web.bind.annotation.CrossOrigin;


import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.busreservation.entity.loginentity;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class logincontroller {
	@Autowired
	private loginrepository loginrepo;
	
	@PostMapping("/login")
	public ResponseEntity< loginentity > loginUser(@RequestBody loginentity userData){
		loginentity user = loginrepo.findUserByEmail(userData());
		if(user.getPassword().equals(userData.getPassword()));
			return ResponseEntity.ok(user);
		}
}
*/