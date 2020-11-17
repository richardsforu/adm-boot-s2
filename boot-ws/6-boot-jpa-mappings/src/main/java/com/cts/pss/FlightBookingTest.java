package com.cts.pss;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.pss.entity.Flight;
import com.cts.pss.service.FlightBookingServiceImpl;
import com.cts.pss.service.FlightSearchServiceImpl;

@SpringBootApplication
public class FlightBookingTest {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(FlightBookingTest.class, args);
		
		FlightBookingServiceImpl fb = ac.getBean(FlightBookingServiceImpl.class);
		fb.bookFlight(1040, 3);
		
		

		
		
		

	}

}
