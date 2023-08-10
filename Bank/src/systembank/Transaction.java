package systembank;

import java.security.Timestamp;
import java.util.Date;

public class Transaction {
	private double amount;
	
	private Date timestamp;
	
	private Account account;
	
	public Transaction (double amount, Timestamp timestamp, Account account) {
		this.amount = amount;
		this.timestamp = new Date();
		this.account = account;
	}

	public double getAmount() {
		return amount;
	}
	
}
