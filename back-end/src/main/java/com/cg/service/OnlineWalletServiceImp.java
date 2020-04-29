package com.cg.service;

import java.util.List;

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
    
    @Override
	public List retrieve() {
		return dao.retrieve();
	}
    
    @Override
    public Integer login(int userId, String password)
    {   
    	if(dao.checkUserByUserId(userId)==false)
    		throw new WrongValueException("The entered user id does not exist, Please enter a valid userId");
    	WalletUser user=dao.getUserByUserId(userId);
    	if(user.getPassword().equals(password)==false)
    		throw new ValidationException("The userId and password combination does not match");
    	return user.getUserID();
    		
    }
    
   
	@Override
	public void registerUser(WalletUser user) {
		
		checkUserId(user.getUserID() );
		WalletAccount account=new WalletAccount(0.00,null);
	    dao.persistAccount(account);
	    user.setAccountDetail(account);
		dao.persistUser(user);
	}


	
	private boolean checkUserId(int userId) {
		 if(dao.checkUserByUserId(userId)==true)
			 throw new WrongValueException("Entered UserId is already present, please enter another login Id");
		else 
			return true;
	}
	

    	
}
