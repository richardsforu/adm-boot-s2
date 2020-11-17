package com.cts.pss.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Passenger {

	@Id
	@GeneratedValue
	private long passengerId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String gender;
	private long mobileNumber;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookingId")
	private BookingRecord bookingRecored;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "copassengerInfo", joinColumns = { @JoinColumn(name = "passengerId") }, inverseJoinColumns = {
			@JoinColumn(name = "copassengerId") })
	private List<CoPassenger> coPassengers = new ArrayList<>();

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public BookingRecord getBookingRecored() {
		return bookingRecored;
	}

	public void setBookingRecored(BookingRecord bookingRecored) {
		this.bookingRecored = bookingRecored;
	}

	public List<CoPassenger> getCoPassengers() {
		return coPassengers;
	}

	public void setCoPassengers(List<CoPassenger> coPassengers) {
		this.coPassengers = coPassengers;
	}

}
