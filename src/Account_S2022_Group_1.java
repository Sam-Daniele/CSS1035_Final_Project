public abstract class Account_S2022_Group_1 {

	private double balance;
	public int account_number;
	
	public Account_S2022_Group_1() {
		balance=0.00;
	}

	public Account_S2022_Group_1(double newBalance) {

		balance = newBalance;

	}
	public double getBalance() {

		return balance;

	}

	public void setBalance(double balance) {

		this.balance = balance;

	}

	public void withdraw(double funds) {

		if (funds > 0) {
			if (funds <= this.balance) {

				setBalance(getBalance() - funds);

			}else 
				System.out.println("Balance is not enough to withdraw chosen amount.");
		}else
			System.out.println("Invalid amount");

	}

	public void deposit(double funds) {

		if (funds > 0) 
			this.balance = funds + balance;
		else
			System.out.println("Invalid amount");

	}

}