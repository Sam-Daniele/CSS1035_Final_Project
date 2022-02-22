package banking_application;

import java.util.Scanner;

public class Banking_Application_S2022_Group_1 {

	public static void main(String[] args) {
		
		Checking_S2022_Group_1 checkingAccount = new Checking_S2022_Group_1();

		System.out.println("Welcome to Group 1 Bank.");
		
		Scanner deposit = new Scanner(System.in);
		
		
		
		while(true) {
			System.out.println("How much would you like to deposit into your checking account?");
			if(deposit.hasNextDouble()) {
		
				double depositValue = deposit.nextDouble();
		
					try{
						checkingAccount.deposit(depositValue);
					}
					catch(Negative_Exception Neg_Exc){
						System.out.println("You cannot deposit a negative number into your checking account.");
					}
				break;
					
			}else {
				System.out.println("Value inserted is not a valid number.");
				deposit.nextLine();
			}
		}
			
		
		Scanner withdraw = new Scanner(System.in);
		
		System.out.println("How much would you like to withdraw from your checking account?");
		
		if(withdraw.hasNextDouble()) {
		
			double withdrawValue = withdraw.nextDouble();
			
				try{
					checkingAccount.withdraw(withdrawValue);
				}
				catch(Negative_Exception Neg_Exc){
					System.out.println("You cannot withdraw a negative number from your checking account.");	
				}
				catch(Overdraft_Exception Overd_Exc) {
					System.out.println("Balance is not enough to withdraw chosen amount.");
				}
		}else
			System.out.println("Value inserted is not a valid number.");
		
		System.out.println("The balance of your checking account is " + checkingAccount.getBalance() + " dollars.");
		
		deposit.close();
		
		withdraw.close();
	
	}

}