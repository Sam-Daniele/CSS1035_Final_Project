public class Checking_S2022_Group_1 extends Account_S2022_Group_1 {

	private double balance;
	private double feeCharge = 10;
	private int numOfWithdrawals = 0;

	public Checking_S2022_Group_1() {

	}

	public double getBalance() {

		return balance;

	}

	public void setBalance(double balance) {

		this.balance = balance;

	}

	public void withdraw(double funds) {

		if (funds >= 0) {

			if (funds <= getBalance()) {

				setBalance(getBalance() - funds);
				numOfWithdrawals++;

			}

		}
		withdrawFees();
		

	}

	public void deposit(double funds) {

		if (funds > 0) {

			balance = funds + balance;

		}

	}
	
	// Method to charge fees if more than x amount of withdrawals are made
	// Set to 2 for now just to make testing easier
	public void withdrawFees() {
		if (numOfWithdrawals <= 2) {
			setBalance(getBalance());
		}
		else {
			setBalance(getBalance() - feeCharge);
		}
		
	}

}
