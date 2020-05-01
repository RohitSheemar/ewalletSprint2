package com.cg;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.entities.*;

@Transactional
@SpringBootApplication
public class EwalletSprint2Application implements CommandLineRunner{
    @Autowired
    EntityManager em;
	public static void main(String[] args) {
		SpringApplication.run(EwalletSprint2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Welcome to Online Wallet");
		
		 /*
		 WalletTransactions wat1=new WalletTransactions(500.0,500.0);
		 WalletTransactions wat2=new WalletTransactions(500.0,1000.0);
		 WalletTransactions wat3=new WalletTransactions(500.0,1500.0);
		 WalletTransactions wat4=new WalletTransactions(500.0,1000.0);
		 
		 
		 
		 List<WalletTransactions> list1=new ArrayList<WalletTransactions>();
		 List<WalletTransactions> list2=new ArrayList<WalletTransactions>();
		 
		 
		 list1.add(wat1);
		 list1.add(wat2);
		 list2.add(wat3);
		 list2.add(wat4);
		 
	     WalletAccount wa1=new WalletAccount(1000.00,list1);
	     WalletAccount wa2=new WalletAccount(1000.00,list2);
	     
	     WalletUser wu1=new WalletUser("Rohit Sheemar","Rohit@123","9041179854","rohitsheemar89@gmail.com",wa1);
		 WalletUser wu2=new WalletUser("Goldi","Goldi@123","9876543210","goldi@gmail.com",wa2);
		 WalletUser wu3=new WalletUser("Ashok Kumar","Ashok@123","9876543200","ashokkumar@gmail.com",wa2);

		 em.persist(wu1);
	     em.persist(wu2);
	     em.persist(wu3);
	     
	     em.persist(wa1);
	     em.persist(wa2);
	     
	     em.persist(wat1);
		 em.persist(wat2);
		 em.persist(wat3);
		 em.persist(wat4);
		 */
	}
    
}
