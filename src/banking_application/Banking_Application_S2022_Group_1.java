package banking_application;

import java.util.Scanner;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.io.IOException;

public class Banking_Application_S2022_Group_1 {
	
	static Handler fileHandler = null;
	
    private static final Logger LOGGER = Logger.getLogger(Banking_Application_S2022_Group_1.class.getClass().getName());
    
    // Method that starts logging of the banking application into a file called Banking_Application_S2022_Group_1.log
    
    public static void startLogging() {

        try {
        	
            fileHandler = new FileHandler("./Banking_Application_S2022_Group_1.log");
            
            SimpleFormatter simple = new SimpleFormatter();
            
            fileHandler.setFormatter(simple);

            LOGGER.addHandler(fileHandler);

        } catch (IOException e) {
            
        }

    }

	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		startLogging();
		
		Checking_S2022_Group_1 checkingAccount = new Checking_S2022_Group_1();
		
		System.out.println("Welcome to Group 1 Bank.");
		
		/*
		 * While loop is used to prevent application from crashing/terminating on errors.
		 * Verifies that user enters a valid name.
		 * Contains sensitive data relating to the user's identity.
		 */
		
		while(true){
			
			System.out.println("Enter your first and last name.");
				
			Scanner name = new Scanner(System.in);
				
			String nameValue = name.nextLine();
				
				
			// Normalization of entered name
			
	        nameValue = Normalizer.normalize(nameValue, Normalizer.Form.NFKC);
	        
	        // Validation of entered name
			
			Pattern regex = Pattern.compile("[$&+,:;=?@#|'<>.^*()%!-]");
			     
			Matcher matcher = regex.matcher(nameValue);
			
			/*
			 * The following if-statement prompts the user for their password.
			 * User's password is considered sensitive data since it allows access to account.
			 */
			
			if (matcher.find()){		 
				System.out.println("Value entered is not a valid name."); 
				LOGGER.info("User has entered an invalid name.");
			}else{	
			// Output encoding of entered password
				
				System.out.println("Enter your password.");
					
				Scanner password = new Scanner(System.in);
					
				String passwordValue = password.nextLine();
			        
			    System.out.println("You have logged in as " + nameValue + " with password: " + encodePassword(passwordValue));
			    
			    LOGGER.info("User has entered a valid name and password.");
			    
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
						LOGGER.info("User has deposited funds into their checking account.");
					}
					catch(Negative_Exception Neg_Exc){
						System.out.println("You cannot deposit a negative number into your checking account.");
						LOGGER.info("User has attempted to deposit negative funds into their checking account.");
					}
				break;
					
			}else {
				System.out.println("Value inserted is not a valid number.");
				LOGGER.info("User has selected a value that is not a valid number when depositing funds into their checking account.");
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
						LOGGER.info("User has withdrawn funds from their checking account.");
						
					}
					catch(Negative_Exception Neg_Exc){
						System.out.println("You cannot withdraw a negative number from your checking account.");
						LOGGER.info("User has attempted to withdraw negative funds from their checking account.");
					}
					catch(Overdraft_Exception Overd_Exc) {
						System.out.println("Balance is not enough to withdraw chosen amount.");
						LOGGER.info("User has attempted to withdraw funds that is less than the balance of their checking account.");
					}
					break;
			}else {
				System.out.println("Value inserted is not a valid number.");
				LOGGER.info("User has selected a value that is not a valid number when withdawing funds from their checking account.");
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
		 
	     String encodedPassword = Base64.getEncoder().encodeToString(digest);
	   
		 
		 return encodedPassword;

	}

}