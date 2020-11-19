package com.cts.pss.controller;

import java.util.List;

import com.cts.pss.entity.Flight;
import com.cts.pss.entity.Passenger;

public class UIData {

	private SearchQuery searchQuery;
	private List<Flight> flights;
	private Passenger passenger;
	private Flight flight;

	public SearchQuery getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(SearchQuery searchQuery) {
		this.searchQuery = searchQuery;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
