package com.cg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.exceptions.UserException;

@RestControllerAdvice
public class WalletControllerAdvice {
	
	@ExceptionHandler(value= {UserException.class} )
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorMessage handleException(Exception ex)
	{
		return new ErrorMessage(ex.getMessage());
	}

}



