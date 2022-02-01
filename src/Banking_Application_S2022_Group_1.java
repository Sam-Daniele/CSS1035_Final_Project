public class Banking_Application_S2022_Group_1 

{

public static void main(String[] args) 

{

System.out.println("Welcome to Group 1 Bank");

System.out.println("Welcome to Group 1 Bank");

Checking_S2022_Group_1 checkingAccount = new Checking_S2022_Group_1();

Savings_S2022_Group_1 savingsAccount = new Savings_S2022_Group_1();

double deposit = 100;

checkingAccount.deposit(deposit);

System.out.println(checkingAccount.getBalance() + " dollars has been deposited into your checking account");

savingsAccount.deposit(deposit);

System.out.println(savingsAccount.getBalance() + " dollars has been deposited into your savings account");

}

}