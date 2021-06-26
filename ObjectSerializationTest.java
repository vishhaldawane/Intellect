import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import bank.BankAccount;

public class ObjectSerializationTest {
	public static void main(String[] args) {
		
		BankAccount bankObj1 = new BankAccount(101, "Julie", 80000);
		bankObj1.showBankAccount();
		
		try {
			FileOutputStream fout = new FileOutputStream("d:\\javatraining1\\bank.dat");
			/*PrintWriter pw = new PrintWriter(fout,true);
			pw.println(bankObj1.getAccountNumber());
			pw.println(bankObj1.getAccountHolderName());
			pw.println(bankObj1.getAccountBalance());*/
			
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			System.out.println("Object output stream ready to write objects....");
			oos.writeObject(bankObj1);
			
			System.out.println("Bank object serialized to the file...");
			fout.close();
			oos.close();

			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
