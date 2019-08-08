package com.skillenza.parkinglotjava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ParkingLotController {

	@Autowired
	ParkingLotImpl impl;

	@GetMapping("/parkings")
	public ResponseEntity<List<ParkingLot>> getParkings() {
		List<ParkingLot> parkingLots = impl.findAll();
		return ResponseEntity.accepted().body(parkingLots);
	}

	@PostMapping("/parkings")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ParkingLot> addParkingInfo(@RequestBody ParkingLot parkingLot) {
		ParkingLot preparedParkingLot = impl.prepareParkingLot(parkingLot);
		ParkingLot lot = impl.addParkingLot(preparedParkingLot);
		return new ResponseEntity<ParkingLot>(lot, HttpStatus.CREATED);

	}
}
