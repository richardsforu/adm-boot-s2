package com.cts.pss.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pss.dao.FlightDao;
import com.cts.pss.entity.Flight;

@Service
public class FlightSearchServiceImpl {
	
	@Autowired
	private FlightDao flightDao;
	
	public List<Flight> findFlightByOriginAndDestinationAndFlightDate(String origin,String destination,LocalDate flightDate,int numberofPassengers){
		
		List<Flight> flights= flightDao.findByOriginAndDestinationAndFlightDate(origin, destination, flightDate);
		return flights.stream().filter(flight->flight.getInventory().getCount()>=numberofPassengers).collect(Collectors.toList());
	}
	

}
