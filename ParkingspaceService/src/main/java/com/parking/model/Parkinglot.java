package com.parking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parkinglot")
public class Parkinglot {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long lotid;
	
	private long block;
	
	private String wing;
	
	private String building;
	
	private String location;
	
	private String status;
	
	private long noofdays;
	
	private long eid;

	public long getLotid() {
		return lotid;
	}

	public void setLotid(long lotid) {
		this.lotid = lotid;
	}

	public long getBlock() {
		return block;
	}

	public void setBlock(long block) {
		this.block = block;
	}

	public String getWing() {
		return wing;
	}

	public void setWing(String wing) {
		this.wing = wing;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getNoofdays() {
		return noofdays;
	}

	public void setNoofdays(long noofdays) {
		this.noofdays = noofdays;
	}

	public long getEid() {
		return eid;
	}

	public void setEid(long eid) {
		this.eid = eid;
	}
	
	
	
	
	
}
