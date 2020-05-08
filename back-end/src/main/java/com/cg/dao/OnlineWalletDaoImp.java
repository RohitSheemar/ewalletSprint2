package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.entities.*;

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
	public boolean checkUserByPhone(String phoneNumber){
   		String Qstr="SELECT user.phoneNumber FROM WalletUser user WHERE user.phoneNumber= :phoneNumber";
   		
   	   	TypedQuery<String> query=entityManager.createQuery(Qstr, String.class).setParameter("phoneNumber",phoneNumber);
   	   	try
   	   	{
   	   		String ph=query.getSingleResult();
   	   		ph.equals(phoneNumber);
   	   	}
   	   	catch(Exception ex)
   	   	{
   	   		return false;
   	   	}
   	   	
   	   	return true;
   	   	
   	}
	
	// getting user by mathcing with phone number
	@Override
	public WalletUser getUserByPhone(String phoneNumber){
		String Qstr="SELECT user FROM WalletUser user WHERE user.phoneNumber= :phoneNumber";
   		TypedQuery<WalletUser> query=entityManager.createQuery(Qstr, WalletUser.class).setParameter("phoneNumber",phoneNumber);
   		
   		return query.getSingleResult();
   		
	}
	
	//method to update password of the existed user
	@Override
	public void updateUser(WalletUser user) {

       WalletUser newUser = entityManager.find(WalletUser.class, user.getPhoneNumber() );
       
       if(newUser != null)
       {
       newUser.setPassword(user.getPassword());
       }
      		
	}
	

	

}
