package com.parking.client;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.parking.exception.RecordNotFoundException;
import com.parking.model.Employee;

@FeignClient(name = "http://employeeservice/employee")
public interface EmployeeClient {
	
	@GetMapping
	public ResponseEntity<List<Employee>> findAllemployees() throws RecordNotFoundException;

}
