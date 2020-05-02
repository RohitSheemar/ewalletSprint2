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
	public void persistUser(WalletUser user) {
		entityManager.persist(user);
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
	 *This method will check the user by userId.
	 *If the userId don't exist in table it will add the user. 
	 */
    @Override
   	public boolean checkUserByUserId(int userId)
   	{   
   		String Qstr="SELECT user.userID FROM WalletUser user WHERE user.userID= :userId";
   		TypedQuery<String> query=entityManager.createQuery(Qstr,String.class).setParameter("userId",userId);
   		try
   		{
   			query.getSingleResult();
   		}
   		catch(Exception ex)
   		{
   			return false;
   		}
   		return true;
   	}
    

	/*
	 *This method will retrieve the user from user table by matching the user id.
	 */
	@Override 
	public WalletUser getUserByUserId(int userId)
	{
		String Qstr="SELECT user FROM WalletUser user WHERE user.userId= :userId";
   		TypedQuery<WalletUser> query=entityManager.createQuery(Qstr,WalletUser.class).setParameter("userId",userId);
   		return query.getSingleResult();
	}
	
	
	@Override
	public WalletUser getUser(Integer userId)
	{   
		WalletUser user=entityManager.find(WalletUser.class, userId);
        return user;
	}
	
	@Override
	public WalletAccount getAccount(Integer accountId)
	{
		WalletAccount account=entityManager.find(WalletAccount.class, accountId);
		return account;
	}
	
	@Override
	public WalletTransactions getTransaction(Integer transactionId)
	{
		WalletTransactions transaction=entityManager.find(WalletTransactions.class, transactionId);
		return transaction;
	}
	
	@Override
	public boolean addUser(WalletUser user) {
		entityManager.persist(user);
		return true;
	}
	

	@Override
	public boolean signin(int userId, String password) throws UserException {
		String Qstr = "SELECT password FROM WalletUser user WHERE user.emailId="+ userId;
		TypedQuery<WalletUser> query = entityManager.createQuery(Qstr, WalletUser.class);
		//Users users=em.find(Users.class, mailId);
		if(query==null) throw new UserException("User not registered");
		return true;
	}

	
	
}
