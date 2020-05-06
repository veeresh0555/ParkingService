package com.parking.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="spaceavailability")
public class SpaceAvailability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Timestamp fromdate;
	
	private Timestamp todate;
	
	private long reqdays;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "eid")
	Employee employee;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="lotid")
	Parkinglot plot;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Timestamp getFromdate() {
		return fromdate;
	}

	public void setFromdate(Timestamp fromdate) {
		this.fromdate = fromdate;
	}

	public Parkinglot getPlot() {
		return plot;
	}

	public void setPlot(Parkinglot plot) {
		this.plot = plot;
	}

	public Timestamp getTodate() {
		return todate;
	}

	public void setTodate(Timestamp todate) {
		this.todate = todate;
	}

	public long getReqdays() {
		return reqdays;
	}

	public void setReqdays(long reqdays) {
		this.reqdays = reqdays;
	}
	
	
	
	
	
}
