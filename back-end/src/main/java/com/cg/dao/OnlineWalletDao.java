package com.cg.dao;

import com.cg.entities.WalletAccount;
import com.cg.entities.WalletTransactions;
import com.cg.entities.WalletUser;
import com.cg.exceptions.UserException;

public interface OnlineWalletDao {
	void persistUser(WalletUser user);
	void persistAccount(WalletAccount account);
	void persistTransaction(WalletTransactions transaction);
	void flush();

	boolean checkUserByUserId(int userId);
	WalletUser getUserByUserId(int userId);

	WalletUser getUser(Integer userId);
	WalletAccount getAccount(Integer accountId);
	WalletTransactions getTransaction(Integer transactionId);
	boolean addUser(WalletUser user);
	boolean signin(int userId, String password) throws UserException;

	
}
