package com.Verizon.VAS;

public class User {
 private int userId;
 private String name;
 private int balance;
 
 //constructor chaining
 public User(int userId, String name, int balance) {
	//super();
	this(userId,name);
	this.balance = balance;
}
 
 public User(int userId, String name) {
	super();
	this.userId = userId;
	this.name = name;
}


 public User() {
	// TODO Auto-generated constructor stub
}

 public int getUserId() {
	return userId;
 }
 public void setUserId(int userId) {
	this.userId = userId;
 }
 public String getName() {
	return name;
 }
 public void setName(String name) {
	this.name = name;
 }
 public int getBalance() {
	return balance;
 }
 public void setBalance(int balance) {
	this.balance = balance;
 }
 
 //alt+shft+s
 
}
