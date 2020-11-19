package com.cts.pss.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.pss.entity.Flight;

public interface FlightDao extends JpaRepository<Flight, Long> {

	Flight findByFlightNumberAndFlightDate(String flightNumber, LocalDate flightDate);
	List<Flight> findByOriginAndDestinationAndFlightDate(String origin, String destination, LocalDate flightDate);
	
}
