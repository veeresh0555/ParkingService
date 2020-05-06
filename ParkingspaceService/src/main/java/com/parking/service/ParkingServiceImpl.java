package com.parking.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.parking.exception.RecordNotFoundException;
import com.parking.model.Parkinglot;
import com.parking.model.Requestingparkingspace;
import com.parking.model.SpaceAvailability;
import com.parking.repository.ParkingLotRepository;
import com.parking.repository.ParkingReleaseRepository;
import com.parking.repository.ReqParkingSpaceRepository;
import com.parking.request.ParkingRequestVO;
import com.parking.request.ParkingspaceReleaseVO;


@Service
public class ParkingServiceImpl implements ParkingService {

	
	@Autowired
	ParkingReleaseRepository pRepository;
	
	@Autowired
	ParkingLotRepository plotRepository;
	
	@Autowired
	ReqParkingSpaceRepository reqRepository;
	
	@Transactional
	@Override
	public SpaceAvailability realeaseparkingspace(ParkingspaceReleaseVO request) throws RecordNotFoundException, ParseException {
		Optional<Parkinglot> checkparklot=plotRepository.findParspaceByid(request.getEid());
		SpaceAvailability space=new SpaceAvailability();
		if(checkparklot.isPresent()) {
			Parkinglot parkinglot=checkparklot.get();
			 	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    java.util.Date frmdate = dateFormat.parse(request.getFromdate());
			    Timestamp frmdatetimestamp = new java.sql.Timestamp(frmdate.getTime());//fromDate
			    java.util.Date todate = dateFormat.parse(request.getTodate());
			    Timestamp todatetimestamp = new java.sql.Timestamp(todate.getTime());//todate
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
				LocalDate date1=LocalDate.parse(request.getFromdate(), dtf);
				LocalDate date2=LocalDate.parse(request.getTodate(), dtf);
				long days=Duration.between(date1, date2).toDays();//calculate between days
				 space.setPlot(parkinglot);
				 space.setFromdate(frmdatetimestamp);
				 space.setTodate(todatetimestamp);
				 space.setReqdays(days);
				 //update parkingLot status and days
				 parkinglot.setNoofdays(days);//Parkinglotsetdays
				 parkinglot.setStatus("V");//default status-A(available) -v for vacation
				 parkinglot =plotRepository.save(parkinglot);
				 
				 if(parkinglot.getEid()==0) {
					throw new RecordNotFoundException("ParkingLot Status and days Not Updated ");
				 }
				 return pRepository.save(space);
		}else {
			throw new RecordNotFoundException("Employee Id "+request.getEid()+ " Not Allowcated");
		}
	}

	@Override
	public Requestingparkingspace reqparkingspace(ParkingRequestVO request)
			throws RecordNotFoundException, ParseException {
		Optional<Parkinglot> checkparklot=plotRepository.findParspaceByid(request.getEid());
		Requestingparkingspace parkreqspace=new Requestingparkingspace();
		if(checkparklot.isPresent()) {
			Parkinglot plot=checkparklot.get();
			throw new RecordNotFoundException("Your already allowcated parking space!!! Your Lot Id is:  "+plot.getLotid());
		}else {
		 	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    java.util.Date frmdate = dateFormat.parse(request.getFromdate());
		    Timestamp frmdatetimestamp = new java.sql.Timestamp(frmdate.getTime());//fromDate
		    java.util.Date todate = dateFormat.parse(request.getTodate());
		    Timestamp todatetimestamp = new java.sql.Timestamp(todate.getTime());//todate
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
			LocalDate date1=LocalDate.parse(request.getFromdate(), dtf);
			LocalDate date2=LocalDate.parse(request.getTodate(), dtf);
			long days=Duration.between(date1, date2).toDays();//calculate between days
			parkreqspace.setEid(request.getEid());
			parkreqspace.setFromdate(frmdatetimestamp);
			parkreqspace.setTodate(todatetimestamp);
			parkreqspace.setStatus("req");
			parkreqspace.setReqdays(days);
			return reqRepository.save(parkreqspace);
		}
	}
	
	
	
	

}
