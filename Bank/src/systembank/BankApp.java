package systembank;

import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Bank bank = new Bank ("Bank of Zhedron");
		
		User user = bank.addUser("Zheka", "Dron", "1234");
		
		Account acc = new Account("Checking", user, bank);
		user.addAccount(acc);
		bank.addAccount(acc);
		
		User curUser;
		
		while (true) {
			curUser = BankApp.mainUser(bank, scanner);
			BankApp.userMenu(curUser, scanner);
		}
		
	}
	
	public static User mainUser (Bank bank, Scanner sc) {
		String userID;
		String pin;
		User authUser;
		
		do {
			System.out.println("Welcome " + bank.getName());
			System.out.println("Enter your ID: ");
			userID = sc.nextLine();
			System.out.println("Enter your pin: ");
			pin = sc.nextLine();
			
			authUser = bank.userLogin(userID, pin);
			
			if (authUser == null) {
				System.out.println("Incorrect your ID/pin, please try again");
			}
		} while (authUser == null);
		
		return authUser;
	}
	
	public static void userMenu (User user, Scanner sc) {
		
		int choice;
		
		do {
			System.out.println("Hello! What do you want to choose from this list?");
			System.out.println("1) Deposit\n2) Transfer\n3) Withdrawl\n4) Quit");
			
			System.out.println("Enter choice: ");
			
			choice = sc.nextInt();
			
			if (choice < 1 || choice > 5) {
				System.out.println("Invalid choice. Please try again");
			}
		} while (choice < 1 || choice > 5);
		
		switch (choice) {
		case 1:
			depositfunds (user, sc);
			break;
		case 2:
			transfer (user, sc);
			break;
		case 3:
			withdrawlfunds(user, sc);
			break;
		case 4:
			System.out.println("Quit");
			break;
		}
		
		if (choice != 5) {
			BankApp.userMenu (user, sc);
		}
	}
	
	public static void depositfunds (User user, Scanner sc) {
		int summaryDeposit;
		
		int transferfromDeposit;
		
		do {
			System.out.println("Set the maximum deposit");
			summaryDeposit = sc.nextInt();
			System.out.println(user.getFirstName() + " u have deposit: " + summaryDeposit);
			

			
			System.out.println("Transfer to account from a deposit");
			
			transferfromDeposit = sc.nextInt();
			
			if (summaryDeposit < 0 || summaryDeposit < transferfromDeposit) {
				System.out.println("Invaild transferfromDeposit/summaryDeposit. Please try again");
			} else {
				System.out.println("Account transferred" + transferfromDeposit);
			}
		} while (summaryDeposit < 0 || transferfromDeposit < summaryDeposit);
	}
	
	public static int transfer (User user, Scanner sc) {
		int fromAcc;
		int toAcc = 0;
		
		do {
			System.out.println("Enter your amount you want to transfer to another account");
			
			fromAcc = sc.nextInt();
			
			toAcc += fromAcc;
			
			System.out.println("Account transferred to another account " + toAcc);
			
			if (toAcc < 0) {
				System.out.println("Failed to transfer account. " + "Please try again");
			}
		} while (toAcc < 0);
		
		return toAcc;
	}
	
	public static void withdrawlfunds (User user, Scanner sc) {
		int fromAcc = 0;
		
		do {
			System.out.println("Enter the amount you want to withdraw money");
			
			fromAcc = sc.nextInt();
			
			System.out.println("You have successfully withdrawn money");
			
			
			
			if (fromAcc < 0) {
				System.out.println("Failed to transfer account. " + "Please try again");
			}
		} while (fromAcc < 0);
	}
}
