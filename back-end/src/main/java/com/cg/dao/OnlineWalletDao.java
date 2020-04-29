package com.cg.dao;

import java.util.List;

import com.cg.entities.WalletAccount;
import com.cg.entities.WalletTransactions;
import com.cg.entities.WalletUser;

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
	public List retrieve();

	
}
