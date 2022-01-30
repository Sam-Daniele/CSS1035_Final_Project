public class Account_S2022_Daniele_Espinet

{
	
private double balance;

public Account_S2022_Daniele_Espinet()

{
	
	
}

public Account_S2022_Daniele_Espinet(double newBalance)

{
	
balance = newBalance;

}

public void withdraw(double funds)

{
	
if (funds != 0 ) 

{

balance = balance - funds;
	
}

}

public void deposit(double funds)

{
	
if (funds != 0 ) 
	
{
	
balance = funds + balance;

}

}

}