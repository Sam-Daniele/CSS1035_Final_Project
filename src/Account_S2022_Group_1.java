public class Account_S2022_Group_1

{
	
private double balance;

public Account_S2022_Group_1()

{
	
	
}

public Account_S2022_Group_1(double newBalance)

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