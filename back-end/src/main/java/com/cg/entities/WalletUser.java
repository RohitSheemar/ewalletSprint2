package com.cg.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="sprint_user")
public class WalletUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_seq")
	private int userID;
	
	@NotEmpty(message="username is mandatory")
	@Column(length=20)
	private String userName;
	
	@Column()
	@NotEmpty(message="password is mandatory")
	private String password;
	
	@Column(unique=true)
	@Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,14}$", message=": Password must contain one number,one alphabet,one special character and size should be at least 8 characters and not more than 14 characters")
	private String phoneNumber;
	
	@Column(unique=true)
	@NotEmpty(message="email id is mandatory")
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

	@Override
	public String toString() {
		return "WalletUser [userID=" + userID + ", userName=" + userName + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", email=" + email + "]";
	}
	
	

	
	
	
}
