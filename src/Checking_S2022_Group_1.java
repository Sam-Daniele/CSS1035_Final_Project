public class Checking_S2022_Group_1 extends Account_S2022_Group_1

{
	
private double balance;

public Checking_S2022_Group_1()

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
