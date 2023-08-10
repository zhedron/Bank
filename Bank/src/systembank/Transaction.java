package systembank;

import java.security.Timestamp;
import java.util.Date;

public class Transaction {
	private double amount;
	
	private Account account;
	
	public Transaction (double amount, Account account) {
		this.amount = amount;
		this.account = account;
	}

	public double getAmount() {
		return amount;
	}
	
	
}
