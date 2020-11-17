package com.cts.pss;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.pss.entity.Flight;
import com.cts.pss.service.FlightSearchServiceImpl;

@SpringBootApplication
public class FindFlightsTest {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(FindFlightsTest.class, args);
		FlightSearchServiceImpl fs = ac.getBean(FlightSearchServiceImpl.class);

		List<Flight> flights = fs.findFlightByOriginAndDestinationAndFlightDate("Delhi", "Chennai",
				LocalDate.of(2020, 11, 21),3);

		flights.forEach(flight -> {
			System.out.println(flight.getId());
			System.out.println(flight.getFlightNumber());
			System.out.println(flight.getOrigin());
			System.out.println(flight.getDestination());
			System.out.println(flight.getFlightDate());
			System.out.println(flight.getFlightTime());
			System.out.println(flight.getFare().getFare());
			System.out.println(flight.getInventory().getCount());
			System.out.println("---------------------------------------------");
		});

	}

}
