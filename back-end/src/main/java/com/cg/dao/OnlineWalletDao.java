package com.cg.dao;

import com.cg.entities.WalletAccount;
import com.cg.entities.WalletTransactions;
import com.cg.entities.WalletUser;

public interface OnlineWalletDao {
	void persistAccount(WalletAccount account);
	void persistTransaction(WalletTransactions transaction);
	void flush();


	boolean addUser(WalletUser user);

	boolean checkUserByPhone(String phoneNumber);
	
	WalletUser getUserByPhone(String phoneNumber);
	
	public void updateUser(WalletUser user);


	
}
