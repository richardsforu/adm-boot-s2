package com.cts.pss.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pss.dao.BookingRecordDao;
import com.cts.pss.dao.FlightDao;
import com.cts.pss.dao.PassengerDao;
import com.cts.pss.entity.BookingRecord;
import com.cts.pss.entity.CoPassenger;
import com.cts.pss.entity.Flight;
import com.cts.pss.entity.Passenger;

@Service
public class FlightBookingServiceImpl {

	@Autowired
	private FlightDao fligtDao;

	@Autowired
	private BookingRecordDao bookingRecordDao;

	@Autowired
	private PassengerDao passengerDao;

	public Passenger bookFlight(long id, int numberofPassengers) {

		Flight flight = fligtDao.findById(id).orElse(null);
		if (flight.getInventory().getCount() >= numberofPassengers) {

			BookingRecord br = new BookingRecord();
			
			br.setBookingDate(LocalDateTime.now());
			br.setOrigin(flight.getOrigin());
			br.setDestination(flight.getDestination());
			br.setFlightDate(flight.getFlightDate());
			br.setFlightTime(flight.getFlightTime());
			br.setFare(flight.getFare().getFare() * numberofPassengers);
			br.setFlightNumber(flight.getFlightNumber());
			br.setStatus("CONFIRMED");

			Passenger p1 = new Passenger();
			p1.setFirstName("Govind");
			p1.setLastName("Sharma");
			p1.setGender("male");
			p1.setEmailAddress("govind@govind.com");
			p1.setMobileNumber(8765432365L);
			p1.setBookingRecored(br);

			CoPassenger cop1 = new CoPassenger();
			cop1.setFirstName("Nik");
			cop1.setLastName("John");
			cop1.setGender("Female");

			CoPassenger cop2 = new CoPassenger();
			cop2.setFirstName("Dev");
			cop2.setLastName("Ora");
			cop2.setGender("Male");

			p1.getCoPassengers().add(cop1);
			p1.getCoPassengers().add(cop2);

			bookingRecordDao.save(br);
			passengerDao.save(p1);

		} else {
			System.out.println("No more Seats available");
		}

		return null;
	}

}
