package com.example.demo.exception;

public class InsufficientAmountException extends RuntimeException{

	public InsufficientAmountException(String msg)
	{
		super(msg);
	}
	
}
