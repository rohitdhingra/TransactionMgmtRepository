package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PASSENGER_INFO")
public class PassengerInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pId;
	private String name;
	private String email;
	private String source;
	private String destination;
	@JsonFormat(shape = Shape.STRING,pattern = "dd-MM-yyyy")
	private Date travelDate;
	private String pickUpTime;
	private String arrivalTime;
	private double fare;
}
