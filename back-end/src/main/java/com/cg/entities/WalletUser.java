package com.cg.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="capg_user", uniqueConstraints= {@UniqueConstraint(columnNames= {"email"})})


public class WalletUser {
	
	@Id
	@Pattern(regexp="[1-9][0-9]{9}", message=": Not a valid phone number")
	private String phoneNumber;
	
	@Size(min=3, max=20, message="User name is not valid")
	@Pattern(regexp="([A-Za-z]+)|([A-Za-z]+[ ][A-Za-z]+)", message=": Only alphabets and one space is allowed")
	private String userName;
	
	@Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,14}$", message=": Password must contain one number,one alphabet,one special character and size should be at least 8 and not more than 14 characters")
	private String password;
	
	@Column(unique=true)
	@Email(message="Email id is not valid")
	private String email;	
	
	@OneToOne(cascade=CascadeType.ALL)
	WalletAccount accountDetail;
	
	

	public WalletUser() {
		super();
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
