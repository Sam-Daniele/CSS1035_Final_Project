package banking_application;

public class Overdraft_Exception extends Exception {

	public Overdraft_Exception(double amount) {
		super("Invalid amount"+amount);
	}
}
