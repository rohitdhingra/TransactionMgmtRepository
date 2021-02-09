package com.example.demo.dto;

import java.util.Date;

import com.example.demo.entity.PassengerInfo;
import com.example.demo.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingRequest {

	private PassengerInfo passengerInfo;
	private PaymentInfo paymentInfo;
	
}
