package com.cts.pss.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pss.controller.UIData;
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

	public Passenger bookFlight(long id, int numberofPassengers,UIData uiData) {

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

			uiData.getPassenger().setBookingRecored(br);

			bookingRecordDao.save(br);
			passengerDao.save(uiData.getPassenger());

		} else {
			System.out.println("No more Seats available");
		}

		return null;
	}

}
