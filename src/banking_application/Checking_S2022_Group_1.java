package banking_application;
public class Checking_S2022_Group_1 extends Account_S2022_Group_1 {

	private double feeCharge = 10;
	private int numOfWithdrawals = 0;

	public Checking_S2022_Group_1() {

	}

	public Checking_S2022_Group_1(double newBalance) {
		super(newBalance);
	}

	public void withdraw(double funds) throws Negative_Exception {

		if (funds > 0) {

			if (funds <= getBalance()) {

				setBalance(getBalance() - funds);
				numOfWithdrawals++;
				withdrawFees();
				
				System.out.println(funds + " dollars has been withdrawn from your checking account.");

			}else 
				System.out.println("Balance is not enough to withdraw chosen amount.");
		}else
			
			throw new Negative_Exception(funds);
			
	}

	// Method to charge fees if more than x amount of withdrawals are made
	// Set to 2 for now just to make testing easier
	public void withdrawFees() {
		if (numOfWithdrawals > 2) {
			setBalance(getBalance() - feeCharge);
			System.out.println("Withdrawals fees are being applied.");
		}
		
	}

}
