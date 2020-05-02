package com.cg.service;

import com.cg.entities.WalletUser;
import com.cg.exceptions.UserException;

public interface OnlineWalletService {
	
	void registerUser(WalletUser user);
	Integer login(int userId, String password);
	boolean addUser(WalletUser user);
	boolean signin(int userId, String password) throws UserException;
}
  