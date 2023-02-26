package com.example.backend;



import java.util.HashMap;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class BikeController {

	@Autowired
	private BikeRepository bikeRepository;
	
	// get all bikes
	@GetMapping("/bikes")
	public List<Bike> getAllBikes(){
		return bikeRepository.findAll();
	}		
	
	// create bike rest api
	@PostMapping("/bikes")
	public Bike createbike(@RequestBody Bike bike) {
		return bikeRepository.save(bike);
	}
	
	// get bike by id rest api
	@GetMapping("/bikes/{id}")
	public ResponseEntity<Bike> getbikeById(@PathVariable Long id) {
		Bike bike = bikeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("bike not exist with id :" + id));
		return ResponseEntity.ok(bike);
	}
	
	// update bike rest api
	
	@PutMapping("/bikes/{id}")
	public ResponseEntity<Bike> updatebike(@PathVariable Long id, @RequestBody Bike bikeDetails){
		Bike bike = bikeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("bike not exist with id :" + id));
		
		bike.setBikeName(bikeDetails.getBikeName());
		bike.setModel(bikeDetails.getModel());
		bike.setFounder(bikeDetails.getFounder());
		
		Bike updatedbike = bikeRepository.save(bike);
		return ResponseEntity.ok(updatedbike);
	}
	
	// delete bike rest api
	@DeleteMapping("/bikes/{id}")
	public ResponseEntity<Map<String, Boolean>> deletebike(@PathVariable Long id){
		Bike bike = bikeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("bike not exist with id :" + id));
		
		bikeRepository.delete(bike);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}