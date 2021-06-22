
public class InterfaceTest {
	public static void main(String[] args) {
		//Payment payment = new Payment(); // cannot be instantiated
		Payment payment = new ChequePayment();
		payment.pay();
	}
}

interface Payment // pure abstract class
{
	void pay(); // pure partial - abstract,public
}

class GooglePayment implements Payment
{
	public void pay() {
		System.out.println("Gpay....");
	}
}
class CardPayment implements Payment
{
	public void pay() {
		System.out.println("Card pay....");
	}
}
class ChequePayment implements Payment
{
	public void pay() {
		System.out.println("Cheque pay....");
	}
}
class CashPayment implements Payment
{
	public void pay() {
		System.out.println("Cash pay....");
	}
}