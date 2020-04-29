package com.cg.entities;

import javax.persistence.*;


@Entity
@Table(name="sprint_user")
public class WalletUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_seq")
	private int userID;
	private String userName;
	private String password;
	private String phoneNumber;
	private String email;	
	
	@OneToOne(cascade=CascadeType.ALL)
	WalletAccount accountDetail;
	
	

	public WalletUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public WalletAccount getAccountDetail() {
		return accountDetail;
	}

	public void setAccountDetail(WalletAccount accountDetail) {
		this.accountDetail = accountDetail;
	}

	public WalletUser(String userName, String password, String phoneNumber, String email, WalletAccount accountDetail) {
		super();
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.accountDetail = accountDetail;
	}

	
	
	
}
