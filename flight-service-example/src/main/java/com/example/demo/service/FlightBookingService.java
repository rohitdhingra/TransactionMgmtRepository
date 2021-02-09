package com.example.demo.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.FlightBookingAcknowledgment;
import com.example.demo.dto.FlightBookingRequest;
import com.example.demo.entity.PassengerInfo;
import com.example.demo.entity.PaymentInfo;
import com.example.demo.repository.PassengerInfoRepository;
import com.example.demo.repository.PaymentInfoRepository;
import com.example.demo.utils.PaymentUtils;

@Service
public class FlightBookingService {
	@Autowired
	private PaymentInfoRepository paymentInfoRepository;
	
	@Autowired
	private PassengerInfoRepository passengerInfoRepository;
	
	@Transactional//(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
	public FlightBookingAcknowledgment bookFlightTicket(FlightBookingRequest request)
	{
		PassengerInfo passengerInfo = request.getPassengerInfo();
		passengerInfo = passengerInfoRepository.save(passengerInfo);
		
		PaymentInfo paymentInfo = request.getPaymentInfo();
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		
		paymentInfo.setPassengerId(passengerInfo.getPId());
		paymentInfo.setAmount(passengerInfo.getFare());
		
		paymentInfoRepository.save(paymentInfo);
		
		return new FlightBookingAcknowledgment("SUCCESS",passengerInfo.getFare(),UUID.randomUUID().toString().split("-")[0],passengerInfo);
	}

}
