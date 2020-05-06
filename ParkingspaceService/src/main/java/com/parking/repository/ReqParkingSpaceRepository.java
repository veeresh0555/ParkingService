package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.model.Requestingparkingspace;

@Repository
public interface ReqParkingSpaceRepository extends JpaRepository<Requestingparkingspace, Long> {

}
