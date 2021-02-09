package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FlightBookingAcknowledgment;
import com.example.demo.dto.FlightBookingRequest;
import com.example.demo.service.FlightBookingService;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class FlightServiceExampleApplication {
	
	@Autowired
	private FlightBookingService service;

	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgment bookFlightTicket(@RequestBody FlightBookingRequest request)
	{
		return service.bookFlightTicket(request);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FlightServiceExampleApplication.class, args);
	}

}
