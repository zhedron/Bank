package systembank;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String firstname;
	
	private String lastname;
	
	private List<Account> accounts;
	
	private String uuid;
	
	public User (String firstname, String lastname, String pin, Bank bank) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.uuid = bank.getNewUserUUID();
		
		this.accounts = new ArrayList<>();
		
		System.out.println("New User " + this.firstname + " " + this.lastname + " with ID " + this.uuid + " created.");
	}

	public String getUuid() {
		return uuid;
	}
	
	public void addAccount (Account account) {
		this.accounts.add(account);
	}
	
	public String getFirstName () {
		return this.firstname;
	}
}
