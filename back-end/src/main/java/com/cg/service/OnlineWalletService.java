package com.cg.service;


import com.cg.entities.WalletUser;

public interface OnlineWalletService {
	
	void registerUser(WalletUser user);
	Integer login(int userId, String password);
}
