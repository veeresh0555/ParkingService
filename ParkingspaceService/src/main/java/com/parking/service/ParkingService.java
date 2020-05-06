package com.parking.service;

import java.text.ParseException;

import com.parking.exception.RecordNotFoundException;
import com.parking.model.Requestingparkingspace;
import com.parking.model.SpaceAvailability;
import com.parking.request.ParkingRequestVO;
import com.parking.request.ParkingspaceReleaseVO;

public interface ParkingService {

	public SpaceAvailability realeaseparkingspace(ParkingspaceReleaseVO request) throws RecordNotFoundException, ParseException ;

	public Requestingparkingspace reqparkingspace(ParkingRequestVO request) throws RecordNotFoundException, ParseException ;

}
