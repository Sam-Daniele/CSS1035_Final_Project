public class Savings_S2022_Daniele_Espinet extends Account_S2022_Daniele_Espinet

{

private double balance;

public Savings_S2022_Daniele_Espinet()

{

}

public double getBalance() 

{
	
return balance;

}


public void setBalance(double balance) 

{
	
this.balance = balance;

}

public void withdraw(double funds)

{
	
if (funds >= 0)
	
{
	
if (funds <= getBalance())
	
{
	
setBalance(getBalance() - funds);

}

}

}

public void deposit(double funds)

{
	
if (funds > 0)
	
{
	
balance = funds + balance;

}

}

}
