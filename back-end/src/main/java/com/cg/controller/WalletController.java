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
import com.cg.exceptions.UserException;
import com.cg.service.*;

@RestController
public class WalletController {

	@Autowired
	private OnlineWalletService service;
	
	
	/*
	 * This method will add the user into user table if user enters all the details correctly.
	 */
	
	@CrossOrigin
	@PostMapping("/add")
	public String addUser(@Valid @RequestBody WalletUser user, BindingResult br) throws UserException{
		
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors=br.getFieldErrors();
			for(FieldError error : errors)
				err= err + error.getDefaultMessage() + "<br>";
			throw new UserException(err);
		}
		try {
			service.addUser(user);
			return "The User is Registered successfully" ;
		}
		catch(DataIntegrityViolationException ex) {
			throw new UserException("Please enter valid user details");
		}
	}

	
	/*
	 * This method will return the wallet account of user if the login credentials are correct.
	 */	
	
	
	// login function using emailId and password
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
	 * This method will check the user by matching with user id and update the password.
	 */
	
	// update user function using userId
	@CrossOrigin
	@PutMapping("/update")
	public String updatePassword(@RequestBody WalletUser user) throws UserException{
		return service.updatePassword(user);
	}

	
	
	
		
}
