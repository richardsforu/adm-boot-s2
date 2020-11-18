package com.cts.pss.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.pss.entity.Flight;

@Controller
public class FlightController {

	@RequestMapping("/s1")
	public String f1() {
		System.out.println(">>> f1 method of FlightController");
		return "One";
	}

	@RequestMapping("/s2")
	public String f2(Model model, ModelMap map) {
		model.addAttribute("userName", "Praveen");
		map.addAttribute("city", "Hyderabad");
		System.out.println(">>> f1 method of FlightController");
		return "Two";
	}

	@RequestMapping("/s3") // redirect to s1
	public String f3() {
		System.out.println(">>> f3 method of FlightController");
		return "redirect:s1";
	}

	// Displaying Model object - Flight

	@RequestMapping("/s4")
	public String f4(Model model) {

		Flight f1 = new Flight(10, "FK-348", "Delhi", "Chennai", LocalDate.of(2020, 12, 26), LocalTime.of(23, 19));

		model.addAttribute("flight", f1);

		return "Flight";
	}

	@RequestMapping("/s5")
	public String f5(Model model) {

		Flight f1 = new Flight(10, "FK-348", "Delhi", "Chennai", LocalDate.of(2020, 12, 26), LocalTime.of(23, 19));
		Flight f2 = new Flight(11, "AI-234", "Delhi", "Chennai", LocalDate.of(2020, 11, 21), LocalTime.of(23, 00));
		Flight f3 = new Flight(12, "KL-102", "Hyderabad", "Chennai", LocalDate.of(2020, 11, 18), LocalTime.of(10, 15));
		Flight f4 = new Flight(13, "JK-984", "Mumbai", "Pune", LocalDate.of(2020, 12, 21), LocalTime.of(18, 45));
		Flight f5 = new Flight(14, "6E-565", "Kolkata", "Delhi", LocalDate.of(2020, 12, 28), LocalTime.of(4, 40));
		Flight f6 = new Flight(15, "AI-987", "Chennai", "Hyderabad", LocalDate.of(2020, 12, 31), LocalTime.of(6, 00));

		model.addAttribute("flights", Arrays.asList(f1, f2, f3, f4, f5, f6));

		return "Flights";
	}

	// load form
	@RequestMapping("/loadForm")
	public String f6() {
		return "Form";
	}

	@RequestMapping("/s6")
	public String f7(@RequestParam("origin") String origin, @RequestParam("destination") String destination,
			@RequestParam("flightDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate flightDate) {

		System.out.println(">>>>>> FORM Submited <<<<<<<");
		System.out.println("Origin: " + origin);
		System.out.println("Destination: " + destination);
		System.out.println("Flight Date: " + flightDate);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return "";
	}

}
