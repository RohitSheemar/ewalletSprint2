package com.cg.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="capg_acc")
public class WalletAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_seq")
	private int accountID;
	
	private Double accountBalance;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<WalletTransactions> transactionList;
	
	

	public WalletAccount() {
		super();
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<WalletTransactions> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<WalletTransactions> transactionList) {
		this.transactionList = transactionList;
	}

	public WalletAccount(Double accountBalance, List<WalletTransactions> transactionList) {
		super();
		this.accountBalance = accountBalance;
		this.transactionList = transactionList;
	}
	
}
