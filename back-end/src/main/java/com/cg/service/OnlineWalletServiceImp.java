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
   
    

	@Override
	public boolean login(String email, String password) throws UserException {
		return dao.login(email, password);
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
	 * This method will call ensure that any of the user details must not already exist in database to register for new account  
	 */
	
	
		

    	
}
