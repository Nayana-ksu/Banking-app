package com.ustg.Bankaccount.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {
@Id
String accountid;
String accounttype;
String address;
String aadhar;
String bankname;
String bankcode;
String bankbranch;
String emailid;
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getAccountid() {
	return accountid;
}
public void setAccountid(String accountid) {
	this.accountid = accountid;
}
public String getAccounttype() {
	return accounttype;
}
public void setAccounttype(String accounttype) {
	this.accounttype = accounttype;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getAadhar() {
	return aadhar;
}
public void setAadhar(String aadhar) {
	this.aadhar = aadhar;
}
public String getBankname() {
	return bankname;
}
public void setBankname(String bankname) {
	this.bankname = bankname;
}
public String getBankcode() {
	return bankcode;
}
public void setBankcode(String bankcode) {
	this.bankcode = bankcode;
}
public String getBankbranch() {
	return bankbranch;
}
public void setBankbranch(String bankbranch) {
	this.bankbranch = bankbranch;
}


public String toString() {
	return " Accountid " + accountid + " Account type " + accounttype + " address " + address + " aadhar " + aadhar + " bankname " + bankname + " bankcode " + bankcode + " bankbranch " + bankbranch;
}
}
