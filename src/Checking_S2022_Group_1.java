public class Checking_S2022_Group_1 extends Account_S2022_Group_1 {

	private double feeCharge = 10;
	private int numOfWithdrawals = 0;

	public Checking_S2022_Group_1() {

	}

	

	public void withdraw(double funds) {

		if (funds > 0) {

			if (funds <= getBalance()) {

				setBalance(getBalance() - funds);
				numOfWithdrawals++;
				withdrawFees();

			}else 
				System.out.println("Balance is not enough to withdraw chosen amount.");
		}else
			System.out.println("Invalid amount");

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
