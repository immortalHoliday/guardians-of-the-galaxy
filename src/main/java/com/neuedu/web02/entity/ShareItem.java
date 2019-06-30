package com.neuedu.web02.entity;

public class ShareItem {

	User fromUser;
	User toUser;
	Bank bank;
	Integer operation;
	
	public ShareItem() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public ShareItem(User fromUser, User toUser, Bank bank, Integer operation) {
		super();
		this.operation = operation;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.bank = bank;
	}
	public Integer getOperation() {
		return operation;
	}
	public void setOperation(Integer operation) {
		this.operation = operation;
	}
	public User getFromUser() {
		return fromUser;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	public User getToUser() {
		return toUser;
	}
	public void setToUser(User toUser) {
		this.toUser = toUser;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	
}
