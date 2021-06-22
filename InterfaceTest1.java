
class FundTransferService
{
	void transferFunds(WithdrawService source, 
			DepositService target, double amountToTransfer)
	{
		System.out.println("Fund transfer initiated....");
		System.out.println("Fetching the source account balance...");
		if(source.getBalance() > amountToTransfer) {
			source.withdraw(amountToTransfer); // must be only withdraw
			target.deposit(amountToTransfer); // must be only deposit
			System.out.println("Fund transfer successful....");
		}
		else {
			System.out.println("Insufficient funds int the source...");
		}
		
	}
}
public class InterfaceTest1 {
	public static void main(String[] args) {
		SavingsAccount sa1 = new SavingsAccount(101,"Jack",50000,8.5f);
		SavingsAccount sa2 = new SavingsAccount(102,"Janet",60000,8.5f);
		sa1.showBankAccount();
		sa2.showBankAccount();
		
		FundTransferService transferServ = new FundTransferService();
		transferServ.transferFunds(sa1, sa2, 7000);
		
		sa1.showBankAccount();
		sa2.showBankAccount();
		
	}
}
