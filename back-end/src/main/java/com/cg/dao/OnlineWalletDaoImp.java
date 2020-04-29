package com.cg.dao;

import java.util.List;

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
	
	@Override
	public void persistUser(WalletUser user) {
		entityManager.persist(user);
	}
	
	@Override
	public void persistAccount(WalletAccount account)
	{
		entityManager.persist(account);
	}
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
	

	@Override
	public List retrieve() {
		Query q=entityManager.createQuery("from WalletUser u");
		return q.getResultList();
	}
	
	
	
    @Override
   	public boolean checkUserByUserId(int userId)
   	{   
   		String Qstr="SELECT user.userId FROM WalletUser user WHERE user.userId= :userId";
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
	
	
}
