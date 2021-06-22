class BankAccount
{
	// implicit no-arg ctor | default ctor provided unless u write
	private int accountNumber;
	private String accountHolderName;
	private double accountBalance;
	
    BankAccount() { //user defined explicit no-arg ctor | NOT A DEFAULT ONE
		System.out.println("BankAccount ctor....");
	}

	/* void set */BankAccount(int num, String holder, double bal) {
    	System.out.println("Setting the BankAccount details...");
    	accountNumber=num;
    	accountHolderName=holder;
    	accountBalance=bal;
    }
	// either implicit or explicit ctor | but not both at a time
    void showBankAccount() { //ACCESSOR METHOD
    	System.out.println("Account Number  : "+accountNumber);
    	System.out.println("Account Holder  : "+accountHolderName);
    	System.out.println("Account Balance : "+accountBalance);
    	System.out.println("----------------------------------");
    }
}
class SavingsAccount extends BankAccount 
{
	// implicit no-arg ctor | default ctor	
}
class FixedDepositAccount extends SavingsAccount
{
	// implicit no-arg ctor | default ctor
}
public class InheritanceTest {
	public static void main(String[] args) {
		BankAccount bankObj = new BankAccount(101, "Julie", 50000);
		bankObj.showBankAccount();	
		bankObj.setBankAccount(106, "Julia", 45000);
		bankObj.showBankAccount();
	}
}
