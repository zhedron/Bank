package systembank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {
	private String name;
	
	private List<Account> accounts;
	
	private List<User> users;
	
	public Bank (String name) {
		this.name = name;
		this.accounts = new ArrayList<>();
		this.users = new ArrayList<>();
	}
	
	// generate UUID
	public String getNewUserUUID () {
		String uuid;
		
		Random random = new Random();
		
		boolean nonUnique = false;
		
		int length = 6;
		
		do {
			uuid = "";
			
			for (int i = 0; i < length; i++) {
				uuid += ((Integer) random.nextInt(10)).toString();
			}
			
			for (User user : this.users) {
				if (uuid.compareTo(user.getUuid()) == 0) {
					nonUnique = true;
					break;
				}
			}
			
		} while (nonUnique);
		
		return uuid;
	}
	
	// generate UUID
	public String getNewAccountUUID () {
		String uuid;
		
		Random random = new Random();
		
		boolean nonUnique = false;
		
		int length = 6;
		
		do {
			uuid = "";
			
			for (int i = 0; i < length; i++) {
				uuid += ((Integer) random.nextInt(10)).toString();
			}
			
			for (Account a : this.accounts) {
				if (uuid.compareTo(a.getUuid()) == 0) {
					nonUnique = true;
					break;
				}
			}
			
		} while (nonUnique);
		
		return uuid;
	}
	
	public void addAccount (Account account) {
		this.accounts.add(account);
	}
	
	// add account
	public User addUser (String firstname, String lastname, String pin) {
		User user = new User (firstname, lastname, pin, this);
		
		this.users.add(user);
		
		Account account = new Account(firstname, user, this);
		
		user.addAccount(account);
		this.addAccount(account);
		
		return user;
	}
	
	// needed to login
	public User userLogin (String userID, String pin) {
		for (User u : this.users) {
			if (u.getUuid().compareTo(userID) == 0) {
				return u;
			}
		}
		
		return null;
	}

	public String getName() {
		return name;
	}
}
