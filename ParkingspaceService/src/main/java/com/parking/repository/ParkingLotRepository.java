package com.parking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.parking.model.Parkinglot;

@Repository
public interface ParkingLotRepository extends JpaRepository<Parkinglot, Long> {

	@Query(value = "select plot from Parkinglot plot where eid=:eid")
	Optional<Parkinglot> findParspaceByid(@Param("eid")long eid);

}
