package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.parking.model.SpaceAvailability;

@Repository
public interface ParkingReleaseRepository extends JpaRepository<SpaceAvailability, Long> {

}
