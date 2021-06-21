private class AtmMachine
{
	int atmNumber;
	private double totalCashPresent; //100000
	int numberOfCustomerHitToday;
	private int numberOf500=100; //500X100=50000
	private int numberOf200=100; //200x100=20000
	private int numberOf100=300; //100x300-30000
	
	private void dispense(double cashToDispense) { //1200
		totalCashPresent = totalCashPresent-cashToDispense;
		//5x500 = 2500
		//8x200 = 1600
		//9x100 =  900
		numberOf500 = numberOf500 - 5;
	}
	void withdraw(float amountToWithdraw) {
		BankConnection ba = new BankConnection();
		ba.connectToBankServer();
		dispense(amountToWithdraw);
	}
	private class BankConnection {
		void connectToBankServer() {
			System.out.println("Connecting to bank server...");
		}
		void downloadUpdates() {
			System.out.println("Downloading new updates from the bank server...");
		}
		void uploadDailyTransactions() {
			System.out.println("Uploading todays all transactions to the bank server...");
		}
	}
}
public class AbstractionEncapsulationTest {
	public static void main(String[] args) {
		
		AtmMachine myAtm = new AtmMachine();
		//myAtm.totalCashPresent
		myAtm.withdraw(5000);
		myAtm.BankConnection b = new AtmMachine.BankConnection(); 
		
	}

}
