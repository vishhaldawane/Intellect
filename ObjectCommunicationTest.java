
public class ObjectCommunicationTest {
	public static void main(String[] args) {
		CurrentAccount ca = new CurrentAccount(80000);
		AtmServer atmServ = new AtmServer(ca);
		AtmClient atmCl = new AtmClient(atmServ);
		atmCl.withdraw(3000);
		
	}
}
class CurrentAccount
{
	private float balance ;
	
	CurrentAccount(float x) {
		System.out.println("Current Account is ready...");
		balance = x;
	}
	void withdraw(float amt) {
		System.out.println("CurrentAccount: Withdrawing...CurrentAccount.."+amt);
		balance = balance - amt;
		System.out.println("CurrentAccount: After withdraw..."+getBalance());
	}
	private float getBalance() { //May be a SELECT query of DBMS
		return balance;
	}
}
class AtmServer
{
	CurrentAccount ca;
	AtmServer(CurrentAccount x) {
		System.out.println("ATM Server is ready...");
		ca = x;
	}
	void withdraw(float amt) {
		System.out.println("ATMServer: Withdrawing...CurrentAccount.."+amt);
		ca.withdraw(amt);
	}
}
class AtmClient
{
	AtmServer as;
	
	AtmClient(AtmServer x) {
		System.out.println("ATM Client is ready...");
		as = x;
	}
	void withdraw(float amt) {
		System.out.println("ATMClient: Withdrawing...CurrentAccount.."+amt);
		as.withdraw(amt);
	}
}
