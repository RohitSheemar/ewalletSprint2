package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PostMapping("/login")
	public ResponseEntity<Integer> login(@PathVariable int userId, String password)
	{
		Integer uId=service.login(userId, password);
		return new ResponseEntity<Integer>(uId,HttpStatus.OK);
	}
	
		
	@PostMapping("/signin")
	public String getMailId(@Valid @RequestBody WalletUser user, BindingResult br) throws UserException{
		
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors=br.getFieldErrors();
			for(FieldError error : errors)
				err= err + error.getDefaultMessage() + " ";
			throw new UserException(err);
		}
		try {
			service.signin(user.getUserID() , user.getPassword());
			return "Login Successful";
		}
		catch(Exception e) {
			throw new UserException("Please enter valid userId and Password");
		}
	}
	
		
}
