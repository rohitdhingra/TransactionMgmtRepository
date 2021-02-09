package com.example.demo.dto;

import java.util.Date;

import com.example.demo.entity.PassengerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor	
public class FlightBookingAcknowledgment {
	private String status;
	private double totalFare;
	private String pnrNo;
	private PassengerInfo passengerInfo; 

}
