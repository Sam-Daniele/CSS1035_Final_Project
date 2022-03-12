package banking_application;

import java.util.Scanner;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;

public class Banking_Application_S2022_Group_1 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		Checking_S2022_Group_1 checkingAccount = new Checking_S2022_Group_1();
		
		System.out.println("Welcome to Group 1 Bank.");
		
		/*
		 * While loop is used to prevent application from crashing/terminating on errors.
		 * Verifies that user enters a valid name.
		 */
		
		while(true)
			
		{
			
		System.out.println("Enter your first and last name.");
			
		Scanner name = new Scanner(System.in);
			
		String nameValue = name.nextLine();
			
			
		// Normalization of entered name
		
        nameValue = Normalizer.normalize(nameValue, Normalizer.Form.NFKC);
        
        // Validation of entered name
		
		Pattern regex = Pattern.compile("[$&+,:;=?@#|'<>.^*()%!-]");
		     
		Matcher matcher = regex.matcher(nameValue);
		 
		if (matcher.find())
			 
		{
			 
		System.out.println("Value entered is not a valid name.");
		 
		}
		 
		else 
			 
		{
		
		// Output encoding of entered password
			
		System.out.println("Enter your password.");
			
		Scanner password = new Scanner(System.in);
			
		String passwordValue = password.nextLine();
	        
	    System.out.println("You have logged in as " + nameValue + " with password: " + encodePassword(passwordValue));
	    
		break;
		
		}
	       
		}
		
		Scanner deposit = new Scanner(System.in);
		
		/*
		 * While loop is used to prevent application from crashing/terminating on errors.
		 * Verifies that user has enter a valid positive double amount.
		 */
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
		
		/*
		 * While loop is once again used to prevent application from crashing/terminating.
		 * Verifies that the user enters a valid positive number that is less than the total balance.
		 */
		while(true) {		
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
					break;
			}else {
				System.out.println("Value inserted is not a valid number.");
				withdraw.nextLine();
			}
		}
		System.out.println("The balance of your checking account is " + checkingAccount.getBalance() + " dollars.");
		
		deposit.close();
		
		withdraw.close();
	
	}
	
	// Method that returns the Base64 encoded SHA-256 hash of the entered password
	
	 static String encodePassword(String q) throws NoSuchAlgorithmException
	 
	 {
		 
		 MessageDigest md = MessageDigest.getInstance("SHA-256");
		 
		 byte[] digest = md.digest(q.getBytes());
		 
	     String encodedPassword = Base64.getUrlEncoder().encodeToString(digest);
		 
		 return encodedPassword;

	}

}