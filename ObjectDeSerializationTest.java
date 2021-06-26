import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import bank.BankAccount;

public class ObjectDeSerializationTest {
	public static void main(String[] args) {
		
		BankAccount bankObj1 = null;
	
		try {
			FileInputStream fin = new FileInputStream("d:\\javatraining1\\bank.dat");
			/*PrintWriter pw = new PrintWriter(fout,true);
			pw.println(bankObj1.getAccountNumber());
			pw.println(bankObj1.getAccountHolderName());
			pw.println(bankObj1.getAccountBalance());*/
			
			ObjectInputStream ois = new ObjectInputStream(fin);
			System.out.println("Object input stream ready to read objects....");
			bankObj1 = (BankAccount) ois.readObject();
			
			System.out.println("Bank object de-serialized from the file...");
			
			System.out.println("Bank Obj1 : "+bankObj1);
			bankObj1.showBankAccount();
			fin.close();
			ois.close();

			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
