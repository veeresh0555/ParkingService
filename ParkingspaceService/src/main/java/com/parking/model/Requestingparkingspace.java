package com.parking.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reqparkingspace")
public class Requestingparkingspace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reqid;
	
	private long reqdays;
	
	private Timestamp fromdate;
	
	private Timestamp todate;
	
	private String status;
	
	private long eid;
	
	
	public long getEid() {
		return eid;
	}

	public void setEid(long eid) {
		this.eid = eid;
	}

	@OneToMany(mappedBy = "reqparkspace",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<TempParkingSpace> tempparkspace;

	public Set<TempParkingSpace> getTempparkspace() {
		return tempparkspace;
	}

	public void setTempparkspace(Set<TempParkingSpace> tempparkspace) {
		this.tempparkspace = tempparkspace;
	}

	public long getReqid() {
		return reqid;
	}

	public void setReqid(long reqid) {
		this.reqid = reqid;
	}

	public long getReqdays() {
		return reqdays;
	}

	public void setReqdays(long reqdays) {
		this.reqdays = reqdays;
	}

	public Timestamp getFromdate() {
		return fromdate;
	}

	public void setFromdate(Timestamp fromdate) {
		this.fromdate = fromdate;
	}

	public Timestamp getTodate() {
		return todate;
	}

	public void setTodate(Timestamp todate) {
		this.todate = todate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	
}
