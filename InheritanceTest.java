//if u goto an ATM - u wont find any BankAccount, rather
//				common data ie  acno, name, balance

// what is found -> Savings, Current   or   Credit
//				    rate      overdraft		credit/cash limit

abstract class BankAccount // super parent for common data+methods
{
	// implicit no-arg ctor | default ctor provided unless u write
	private int accountNumber;
	private String accountHolderName;
	protected double accountBalance; // can be referred by the child too
	
	abstract void withdraw(double amountToWithdraw); //mandate to the child
	abstract void deposit(double amountToDeposit); //mandate to the child
	
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
	void deposit(double amountToDeposit) //mandate to define here
	{
		System.out.println("Depositing..."+amountToDeposit);
		accountBalance = accountBalance + amountToDeposit;
	}
	void withdraw(double amountToWithdraw) //mandate to define here
	{
		System.out.println("Withdrawing..."+amountToWithdraw);
		accountBalance = accountBalance - amountToWithdraw;
	}
	
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
		System.out.println("FixedDepositAccount(int,String,double,float,int)....");
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
		
	//	BankAccount bankObj = new BankAccount(101, "Julie", 50000);
	//	bankObj.showBankAccount();	
		
	//	System.out.println("===============");
		
		SavingsAccount sa = new SavingsAccount(102,"Smith",60000,3.5f);
		sa.showBankAccount();
		sa.withdraw(4000);
		sa.showBankAccount();
		sa.deposit(80000);
		sa.showBankAccount();
		
		System.out.println("===============");
		
		FixedDepositAccount fd = new FixedDepositAccount(103, "Peter", 70000, 4.5f, 2025);
		fd.showBankAccount();
		fd.deposit(30000);
		fd.showBankAccount();
		
	}
}
