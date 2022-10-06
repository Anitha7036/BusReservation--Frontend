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
import com.busreservation.service.Busservice;
import com.busreservation.entity.Busentity;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Buscontroller {
	@Autowired
    private Busservice busService;

    @GetMapping("/Bus")
    public ResponseEntity < List < Busentity >> getAllBus() {
        return ResponseEntity.ok().body(busService.getAllBus());
    }

    @GetMapping("/Bus/{id}")
    public ResponseEntity < Busentity > getBusById(@PathVariable long id) {
        return ResponseEntity.ok().body(busService.getBusById(id));
    }

    @PostMapping("/{Bus}")
    public ResponseEntity < Busentity > createBus(@RequestBody Busentity bus) {
        return ResponseEntity.ok().body(this.busService.createBus(bus));
    }

    @PutMapping("/Bus/{id}")
    public ResponseEntity < Busentity > updateBus(@PathVariable long id, @RequestBody Busentity bus) {
        bus.setId(id);
        return ResponseEntity.ok().body(this.busService.updateBus(bus));
    }

    @DeleteMapping("/Bus/{id}")
    public HttpStatus deleteProduct(@PathVariable long id) {
        this.busService.deleteBus(id);
        return HttpStatus.OK;
    }
}
