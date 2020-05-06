package com.parking.controller;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.client.EmployeeClient;
import com.parking.exception.RecordNotFoundException;
import com.parking.model.Employee;
import com.parking.model.Requestingparkingspace;
import com.parking.model.SpaceAvailability;
import com.parking.request.ParkingRequestVO;
import com.parking.request.ParkingspaceReleaseVO;
import com.parking.service.ParkingService;

@RestController
@RequestMapping("/parkingspace")
public class ParkingController {

	@Autowired
	EmployeeClient employeeclient;
	
	@Autowired
	ParkingService parkingservice;
	
	@GetMapping
	public ResponseEntity<List<Employee>> findAllemployees() throws RecordNotFoundException{
		return employeeclient.findAllemployees();
	}
	
	@PostMapping
	public ResponseEntity<SpaceAvailability> releaseparkspace(@RequestBody ParkingspaceReleaseVO request)throws RecordNotFoundException, ParseException {
		SpaceAvailability spacerelease=parkingservice.realeaseparkingspace(request);
		return new ResponseEntity<SpaceAvailability>(spacerelease, HttpStatus.OK);
	}
	
	
	@PostMapping("/parkingrequest")
	public ResponseEntity<Requestingparkingspace> reqparkingspace(@RequestBody ParkingRequestVO request) throws RecordNotFoundException, ParseException{
		Requestingparkingspace reqparkingspace=parkingservice.reqparkingspace(request);
		return new ResponseEntity<Requestingparkingspace>(reqparkingspace, HttpStatus.OK);
		
	}
	
	
	
	
	
}
