package banking_application;

public class Negative_Exception extends Exception 

{
	
	public Negative_Exception()
	
	{
		
		super();
	
	}
	
	public Negative_Exception(double funds)
	
	{
		
		super("Negative Value: " + funds);
	
	}

}
