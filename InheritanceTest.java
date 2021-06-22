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
    	System.out.println("BankAccount(int,String,double) ctor...");
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
	float rateOfInterest; //4th data member + inherited 3 fields 
	
	SavingsAccount(float rate) {
		super(); //default first line
		System.out.println("SavingsAccount(float)....");
		rateOfInterest = rate;
	}
	SavingsAccount(int num, String holder, double bal, float rate) {
		super(num,holder,bal); // reuse the existing code to initialize
		//accountNumber= num;
		System.out.println("SavingsAccount(int,String,double,float)....");
		rateOfInterest = rate;
	}
	
	void showBankAccount() { //ACCESSOR METHOD
		super.showBankAccount(); //invoke super class method
    	System.out.println("Account rate    : "+rateOfInterest);
    	System.out.println("----------------------------------");
    }
	// implicit no-arg ctor | default ctor	
}
class FixedDepositAccount extends SavingsAccount
{
	int maturityYear;
	
	FixedDepositAccount(int num, String holder, double bal, float rate, int year) {
		super(num,holder,bal,rate);
		maturityYear = year;
	}
	void showBankAccount() { //ACCESSOR METHOD
		super.showBankAccount(); //invoke super class method
    	System.out.println("Account Maturity: "+maturityYear);
    	System.out.println("----------------------------------");
    }
}
public class InheritanceTest {
	public static void main(String[] args) {
		
		BankAccount bankObj = new BankAccount(101, "Julie", 50000);
		bankObj.showBankAccount();	
		
		System.out.println("===============");
		
		SavingsAccount sa = new SavingsAccount(102,"Smith",60000,3.5f);
		sa.showBankAccount();
		
		System.out.println("===============");
		
		FixedDepositAccount fd = new FixedDepositAccount(103, "Peter", 70000, 4.5f, 2025);
		fd.showBankAccount();
		
	}
}
