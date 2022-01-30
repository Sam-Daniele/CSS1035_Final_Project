public class Banking_Application_S2022_Daniele_Espinet 

{

public static void main(String[] args) 

{

System.out.println("Welcome to Daniele and Espinet Bank");

Checking_S2022_Daniele_Espinet checkingAccount = new Checking_S2022_Daniele_Espinet();

double deposit = 100;

checkingAccount.deposit(deposit);

System.out.println(checkingAccount.getBalance() + " dollars has been deposited into your checking account");

}

}