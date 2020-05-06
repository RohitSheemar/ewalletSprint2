package com.cg.service;


import com.cg.entities.WalletUser;
import com.cg.exceptions.UserException;

public interface OnlineWalletService {
	
	boolean addUser(WalletUser user);
	String login(String phoneNumber, String password) throws UserException;
	String updatePassword(WalletUser user) throws UserException;

	
	

}
  