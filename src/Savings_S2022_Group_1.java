public class Savings_S2022_Group_1 extends Account_S2022_Group_1 {

	private double balance;

	public Savings_S2022_Group_1() {

	}

	public double getBalance() {

		return balance;

	}

	public void setBalance(double balance) {

		this.balance = balance;

	}

	public void withdraw(double funds) {

		if (funds > 0) {

			if (funds <= getBalance()) {

				setBalance(getBalance() - funds);

			}else {
				//error message?
			}

		}

	}

	public void deposit(double funds) {

		if (funds > 0) {

			balance = funds + balance;

		}

	}

}
