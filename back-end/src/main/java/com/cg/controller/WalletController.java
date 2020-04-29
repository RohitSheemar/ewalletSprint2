package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.WalletUser;
import com.cg.service.*;

@CrossOrigin
@RestController
public class WalletController {

	@Autowired
	private OnlineWalletService service;
	
	@GetMapping(value="/user")
	  public List<WalletUser> fetchStudent()
	  {
		  return service.retrieve();
	  }

	
	
	@PostMapping(value="/register",consumes= {"application/json"})
	public ResponseEntity<String> registerUser(@RequestBody WalletUser user)
	{   
		service.registerUser(user);
		return new ResponseEntity<String>("The User is Registered successfully",HttpStatus.OK);
		
	}
	
		
	@PostMapping("/login")
	public ResponseEntity<Integer> login(@PathVariable int userId, String password)
	{
		Integer uId=service.login(userId, password);
		return new ResponseEntity<Integer>(uId,HttpStatus.OK);
	}
	
		
}
