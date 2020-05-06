package com.cg.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	public boolean checkUserByEmail(String phoneNumber){
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
	
	// login function, getting email id for matching with password entered
	@Override
	public WalletUser getUserByEmail(String phoneNumber){
		String Qstr="SELECT user FROM WalletUser user WHERE user.phoneNumber= :phoneNumber";
   		TypedQuery<WalletUser> query=entityManager.createQuery(Qstr, WalletUser.class).setParameter("phoneNumber",phoneNumber);
   		
   		return query.getSingleResult();
   		
	}
	
	
	
	
	//update password
	public List<WalletUser> viewUser()
	{
		Query query=entityManager.createQuery("from User u");
		return query.getResultList();
	}


	@Override
	public WalletUser viewUser(String phoneNumber)
	{
		List<WalletUser> list=viewUser();
		WalletUser user=null;
		Optional <WalletUser> optional=list.stream().
				filter(u1->u1.getPhoneNumber().equals(phoneNumber)).findFirst();
				if(optional.isPresent()) {
					user=optional.get();
				}
		return user;
		
	}
	
	public String updatePassword(WalletUser user) {
		entityManager.merge(user);
		return "Updated successfully";
	}
	
}
