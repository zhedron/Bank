package systembank;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private double balance;
	
	private String name;
	
	private String uuid;
	
	private User holder;
	
	private List<Transaction> accounts;
	
	public Account (String name, User holder, Bank bank) {
		this.name = name;
		this.holder = holder;
		
		this.uuid = bank.getNewAccountUUID();
		
		this.accounts = new ArrayList<>();
		
		holder.addAccount(this);
		bank.addAccount(this);
	}

	public String getUuid() {
		return uuid;
	}
	
	public void addNewAccount (Transaction transpaction) {
		this.accounts.add(transpaction);
	}
	

	
	
	public double getBalance () {
		double balance = 0;
		
		for (Transaction t : this.accounts) {
			balance += t.getAmount();
		}
		
		return balance;
	}
}
