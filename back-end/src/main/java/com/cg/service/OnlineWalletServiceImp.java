package com.cg.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.*;
import com.cg.entities.*;
import com.cg.exceptions.*;

@Transactional
@Service
public class OnlineWalletServiceImp implements OnlineWalletService {

    @Autowired
    private OnlineWalletDao dao;
    
    
    /*
	 * This method will call the Dao class to check whether the user with the entered id exist in database or not.
	 * It will also check the combination of userId and password to get logged in. 
	 */
   
 // login function, validating email id and password
 	@Override
 	public String login(String phoneNumber, String password) throws UserException{   
     	if(dao.checkUserByEmail(phoneNumber)==false)
     		throw new UserException("The entered User does not exist, Please enter a valid phone number");
     	WalletUser user=dao.getUserByEmail(phoneNumber);

     	if(user.getPassword().equals(password)==false)
     		throw new UserException("The phone and password Combination does not match");

     	System.out.println("Login successful with phone number "+user.getPhoneNumber() );

     	return user.getPhoneNumber() ;
     	
     }
    
    
    
    
    /*
	 * This method will call the Dao class to let the user fill the user details to register for new account.
	 * It will then add the details to the user table and wallet account table also.
	 */


	@Override
	public boolean addUser(WalletUser user) {
		WalletAccount account=new WalletAccount(0.00,null);
		dao.persistAccount(account);
		user.setAccountDetail(account);
		return dao.addUser(user);

	}
	
	/*
	 * This method will update the user password if user id exist in database. 
	 */
	
	
	// update function
		@Override
		public String updateUser(WalletUser user, int userID) throws UserException{
			if(dao.update(user, userID)==false)
				throw new UserException("No user exists for given user id");
			return "user password updated";	
		}
	

		

    	
}
