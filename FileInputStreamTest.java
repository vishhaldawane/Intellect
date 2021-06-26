import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) {
		
		try
		{
			System.out.println("Trying to read the file........");
			FileInputStream fin = new FileInputStream("D:\\JavaTraining1\\features.tt");
			System.out.println("File is ready for reading.....");
			
			byte b = (byte) fin.read();
			while( b != -1 ) // -1 means EOF end of file 
			{
				System.out.print((char)b); //convert number into char
				 b = (byte) fin.read(); //read successive letters
				 Thread.sleep(10);
			}
			System.out.println("==> DONE ");
			System.out.println("Trying to close the file....");
			fin.close();
			System.out.println("File is closed....");
		}
		catch(FileNotFoundException e) {
			System.out.println("File problem : "+e);
			
		} catch (IOException e) {
			System.out.println("I/O problem : "+e);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
