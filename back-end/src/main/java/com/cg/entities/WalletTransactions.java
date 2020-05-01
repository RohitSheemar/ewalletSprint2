package com.cg.entities;

import javax.persistence.*;
@Entity
@Table(name="sprint_transactions")
public class WalletTransactions  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tran_seq")
	private Integer transactionID;
	
	private Double amount;
	
	private Double accountBalance;
	

	public WalletTransactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(Integer transactionID) {
		this.transactionID = transactionID;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public WalletTransactions(Double amount, Double accountBalance) {
		super();
		this.amount = amount;
		this.accountBalance = accountBalance;
	}
	
	

}
