package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	

	// login function, checking whether account exist or not
	@Override
	public boolean checkUserByEmail(String phoneNumber) throws NoResultException{
   		String Qstr="SELECT user.phoneNumber FROM WalletUser user WHERE user.phoneNumber= :phoneNumber";
   		
   	   	TypedQuery<String> query=entityManager.createQuery(Qstr, String.class).setParameter("phoneNumber",phoneNumber);
   	   	
	   	String ph=query.getSingleResult();
   	   	try
   	   	{
   	   		ph.equals(phoneNumber);
   	   	}
   	   	catch(NoResultException ex)
   	   	{
   	   		throw new NoResultException("user not exist");
   	   	}
   	   	return true;
   	   	
   	}
	
	// login function, getting email id for matching with password entered
	@Override
	public WalletUser getUserByEmail(String phoneNumber){
		String Qstr="SELECT user FROM WalletUser user WHERE user.phoneNumber= :phoneNumber";
   		TypedQuery<WalletUser> query=entityManager.createQuery(Qstr, WalletUser.class).setParameter("phoneNumber",phoneNumber);
   		
   		return query.getSingleResult();
   		
	}
	
	
	// update password function
		@Override
		public boolean update(WalletUser user, int userID) {
			  WalletUser userUpdate= entityManager.find(WalletUser.class, userID);
			  if(userUpdate==null) return false;
			  
			  userUpdate.setPassword(user.getPassword() );
			 
			  entityManager.persist(userUpdate);
			  
			  return true;
			
		}

}
