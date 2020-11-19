package com.cts.pss.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.pss.dao.FlightDao;
import com.cts.pss.entity.Fare;
import com.cts.pss.entity.Flight;
import com.cts.pss.entity.Passenger;
import com.cts.pss.service.FlightBookingServiceImpl;
import com.cts.pss.service.FlightSearchServiceImpl;

@Controller
public class WebsiteController {

	@Autowired
	private FlightSearchServiceImpl ss;
	
	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private FlightBookingServiceImpl book;

	@RequestMapping("/")
	public String searchForm(Model model) {
		SearchQuery searchQuery = new SearchQuery("DELHI", "CHENNAI", LocalDate.of(2020, 11, 21), 2);
		UIData uiData = new UIData();

		uiData.setSearchQuery(searchQuery);
		model.addAttribute("uidata", uiData);
		return "SearchFlight";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchResults(@ModelAttribute UIData uiData, Model model) {

		List<Flight> flights = ss.findFlightByOriginAndDestinationAndFlightDate(uiData.getSearchQuery().getOrigin(),
				uiData.getSearchQuery().getDestination(), uiData.getSearchQuery().getFlightDate(),
				uiData.getSearchQuery().getNumberofPassengers());
		System.out.println(">>>>> " + flights + "<<<<<<<<<<");
		uiData.setFlights(flights);
		model.addAttribute("uidata", uiData);

		return "Result";
	}

	@RequestMapping("/book/{id}/{flightNumber}/{origin}/{destination}/{flightDate}/{flightTime}/{duration}/{fare}/{numberofPassengers}")
	public String bookFlight(Model model, @PathVariable("id") int id, @PathVariable("flightNumber") String flightNumber,
			@PathVariable("origin") String origin, @PathVariable("destination") String destination,
			@PathVariable("flightDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate flightDate,
			@PathVariable("flightTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime flightTime,
			@PathVariable("duration") String duration, @PathVariable("fare") double fare,
			@PathVariable("numberofPassengers") int numberofPassengers) {

		UIData uiData = new UIData();
		Flight flight = new Flight(id, origin, destination, duration, flightDate, flightTime, flightNumber, fare);
		uiData.setFlight(flight);
		uiData.setPassenger(new Passenger());
		model.addAttribute("uidata", uiData);
		model.addAttribute("numberofPassengers", numberofPassengers);

		return "BookFlight";
	}
	
	@RequestMapping("/bookFlight")
	public String saveBooking(@ModelAttribute UIData uiData,@RequestParam("id")long id,@RequestParam("numberofPassengers")int numberofPassengers) {
		
		
		
		book.bookFlight(id, numberofPassengers,uiData);
		
		
		
		
		return "Confirm";
	}

}
