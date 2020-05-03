package com.cg.service;

import com.cg.entities.WalletUser;
import com.cg.exceptions.UserException;

public interface OnlineWalletService {
	
	boolean addUser(WalletUser user);
	boolean login(String email, String password) throws UserException;
}
  