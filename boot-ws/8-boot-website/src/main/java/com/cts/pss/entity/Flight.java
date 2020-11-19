package com.cts.pss.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Flight {

	@Id
	@GeneratedValue
	private long id;
	private String origin;
	private String destination;
	private String duration;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate flightDate;
	private LocalTime flightTime;
	private String flightNumber;
	
	@Transient
	private double fares;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "fareId")
	private Fare fare;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "invId")
	private Inventory inventory;
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Flight(long id, String origin, String destination, String duration, LocalDate flightDate,
			LocalTime flightTime, String flightNumber, double fares) {
		super();
		this.id = id;
		this.origin = origin;
		this.destination = destination;
		this.duration = duration;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.flightNumber = flightNumber;
		this.fares = fares;
	}



	
	public double getFares() {
		return fares;
	}



	public void setFares(double fares) {
		this.fares = fares;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public LocalTime getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(LocalTime flightTime) {
		this.flightTime = flightTime;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Fare getFare() {
		return fare;
	}

	public void setFare(Fare fare) {
		this.fare = fare;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

}
