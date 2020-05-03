package com.cg.dao;

import com.cg.entities.WalletAccount;
import com.cg.entities.WalletTransactions;
import com.cg.entities.WalletUser;
import com.cg.exceptions.UserException;

public interface OnlineWalletDao {
	void persistAccount(WalletAccount account);
	void persistTransaction(WalletTransactions transaction);
	void flush();


	boolean addUser(WalletUser user);
	boolean login(String email, String password) throws UserException;

	
}
