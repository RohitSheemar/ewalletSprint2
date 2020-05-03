package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.entities.*;
import com.cg.exceptions.UserException;

@Repository
public class OnlineWalletDaoImp implements OnlineWalletDao {
    @PersistenceContext
	private EntityManager entityManager;
	

	/*
	 *This method will create the user table in the database.
	 */
	
	@Override
	public boolean addUser(WalletUser user) {
		entityManager.persist(user);
		return true;
	}	

	/*
	 *This method will create the wallet account table with reference to user table.	 
	 */
	@Override
	public void persistAccount(WalletAccount account)
	{
		entityManager.persist(account);
	}

	/*
	 *This method will create the transaction table with reference to account table.	 
	 */
	@Override
	public void persistTransaction(WalletTransactions transaction)
	{
		entityManager.persist(transaction);
	}
	
	
	@Override
	public void flush()
	{
		entityManager.flush();
	}
	
	
	/*
	 *This method will retrieve the user from user table by matching the user id.
	 */

	@Override
	public boolean login(String email, String password) throws UserException {
		String Qstr = "SELECT user FROM WalletUser user WHERE user.email= :email";
		TypedQuery<WalletUser> query = entityManager.createQuery(Qstr, WalletUser.class);
		//Users users=em.find(Users.class, mailId);
		if(query==null) throw new UserException("User not registered");
		return true;
	}

	
	
}
