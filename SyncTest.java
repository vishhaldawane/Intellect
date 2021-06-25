class BankAccount // super parent for common data+methods
{
	// implicit no-arg ctor | default ctor provided unless u write
	private int accountNumber;
	private String accountHolderName;
	private double accountBalance; // can be referred by the child too
	
	//abstract void withdraw(double amountToWithdraw); //mandate to the child
	//abstract void deposit(double amountToDeposit); //mandate to the child
	
    BankAccount() { //user defined explicit no-arg ctor | NOT A DEFAULT ONE
		System.out.println("BankAccount ctor....");
	}

	/* void set */BankAccount(int num, String holder, double bal) {
    	System.out.println("BankAccount(int,String,double) ctor...");
    	accountNumber=num;
    	accountHolderName=holder;
    	accountBalance=bal;
    }
	// either implicit or explicit ctor | but not both at a time
    void showBankAccount() { //ACCESSOR METHOD
    	System.out.println("->Account Number  : "+accountNumber);
    	System.out.println("->Account Holder  : "+accountHolderName);
    	System.out.println("->Account Balance : "+accountBalance);
    	System.out.println("----------------------------------");
    }
    public double getBalance(String tn) { //simulation of the DB select query
    	System.out.println(tn+" getBalance() invoked....");
    	return accountBalance;
    }
    private void setBalance(double amount, String tn) {//simulation of the DB update query
    	System.out.println(tn+" setBalance() invoked....");
    	accountBalance = amount;
    }
    public synchronized void deposit(double amountToDeposit, String tn) {
    	System.out.println(tn+" started depositing...."+amountToDeposit);
		double currentBalance = getBalance(tn); //step1
		double newBalance = currentBalance + amountToDeposit;
    	System.out.println(tn+" deposit() invoked....");
    	setBalance(newBalance, tn);
    	System.out.println(tn+" deposited...."+amountToDeposit);
    }
}
//java SyncTest
// |
// "main" <-- thread of the JVM

public class SyncTest {
	public static void main(String[] args) {
		System.out.println("->Begin of main");
		BankAccount ba = new BankAccount(101,"Julie",50000);
		ba.showBankAccount();
		
		Teller t1 = new Teller("Seeta",ba,5000);
		Teller t2 = new Teller("\tGeeta",ba,7000);
		Teller t3 = new Teller("\t\tReeta",ba,8000);
		System.out.println("->Starting the threads...");
		t1.start(); //intentionally --> not start
		t2.start();
		t3.start();
		System.out.println("->Started the threads...");
		
		try {
			t1.join();
			t2.join();
			t3.join();
		}
		catch(InterruptedException e) {
			System.out.println("Some problem : "+e);
		}
		
		System.out.println("->After all transactions....lets check the balance....");
		ba.showBankAccount();
		System.out.println("->End of main");
	}
}

class Teller extends Thread //1
{
	String tellerName;
	BankAccount bankRef;
	double amountToDeposit;
	
	Teller(String tn, BankAccount x, double amt) {
		tellerName = tn;
		bankRef = x;
		amountToDeposit=amt;
	}
	//2 
	public void run() {
			bankRef.deposit(amountToDeposit,tellerName);
	}
}









