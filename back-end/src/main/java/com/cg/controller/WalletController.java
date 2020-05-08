package com.cg.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.WalletUser;
import com.cg.exceptions.UnauthorizedAccessException;
import com.cg.exceptions.UserException;
import com.cg.service.*;

@RestController
public class WalletController {

	@Autowired
	private OnlineWalletService service;
	
	
	/*
	 * This method will call the service class to check if the user already exist or not.
	 * This method will add the user into user table if user enters all the details correctly.
	 */
	
	@CrossOrigin
	@PostMapping("/add")
	public String addUser(@Valid @RequestBody WalletUser user, BindingResult br) throws UnauthorizedAccessException{
		
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors=br.getFieldErrors();
			for(FieldError error : errors)
				err= err + error.getDefaultMessage() + "<br>";
			throw new UnauthorizedAccessException(err);
		}
		try {
			service.addUser(user);
			return "The User is registered successfully" ;
		}
		catch(DataIntegrityViolationException ex) {
			throw new UnauthorizedAccessException("The user already exists. Please enter valid details");
		}
	}

	
	/*
	 * This method will first check whether the user with entered mobile exist or not.
	 * If user mobile number exist then it will match the password to get user logged in.
	 * This method will return the wallet account of user if the login credentials are correct.
	 */	
		
	@CrossOrigin
	@GetMapping("/login/{phoneNumber}/{password}")
	public String login(@PathVariable("phoneNumber") String phoneNumber, @PathVariable("password") String password) throws UserException{
		try {
			return service.login(phoneNumber, password);
			
		}
		catch(Exception e) {
			throw new UserException(e.getMessage());
		}
	}
	
	/*
	 * This method will check the user by matching with mobile number.
	 * If mobile number exist then it will give the user account to update.
	 */
	
	@CrossOrigin
	@GetMapping("/getUser/{phoneNumber}")
	public WalletUser getUserByPhone(@PathVariable("phoneNumber") String phoneNumber) throws UserException{
		try {
			return service.getUserByPhone(phoneNumber);		
		}
		catch(Exception e) {
			throw new UserException(e.getMessage());
		}
	}
	
	
	// update password function using phoneNumber
	@CrossOrigin
	@PutMapping(value ="user/update", consumes= {"application/json"})
	public String updateUser(@RequestBody WalletUser user )
	{
		service.updateUser(user);
		return "password updated";
	}
	
	

	
		
}
