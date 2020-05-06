package com.parking.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tempparkingspace")
public class TempParkingSpace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tparkid;
	
	private long lotid;
	
	private long eid;
	
	public long getTparkid() {
		return tparkid;
	}

	public void setTparkid(long tparkid) {
		this.tparkid = tparkid;
	}

	public long getLotid() {
		return lotid;
	}

	public void setLotid(long lotid) {
		this.lotid = lotid;
	}

	public long getApprivedays() {
		return apprivedays;
	}

	public void setApprivedays(long apprivedays) {
		this.apprivedays = apprivedays;
	}

	public Requestingparkingspace getReqparkspace() {
		return reqparkspace;
	}

	public void setReqparkspace(Requestingparkingspace reqparkspace) {
		this.reqparkspace = reqparkspace;
	}

	public long getEid() {
		return eid;
	}

	public void setEid(long eid) {
		this.eid = eid;
	}

	private long apprivedays;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="reqid")
	Requestingparkingspace reqparkspace;
	
	
	
	
	
}
