import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class FileInputStreamTest2 {
	public static void main(String[] args) {
		
		try
		{
			System.out.println("Trying to read the file........");
			FileInputStream fin1 = new FileInputStream("D:\\JavaTraining1\\data.txt");
			
			FileInputStream fin2 = new FileInputStream("D:\\JavaTraining1\\data.txt");
			BufferedInputStream buff = new BufferedInputStream(fin2);
			System.out.println("File is ready for reading.....");
			
			Date now = new Date();
			byte b = (byte) fin1.read();
			while( b != -1 ) // -1 means EOF end of file 
			{
				//System.out.print((char)b); //convert number into char
				 b = (byte) fin1.read(); //read successive letters
				 //Thread.sleep(10);
			}
			Date then = new Date();
			System.out.println("File without buffering : "+(then.getTime()- now.getTime()) +" ms"  );
			System.out.println("==> DONE ");
			
			now = new Date();
			b = (byte) buff.read();
			while( b != -1 ) // -1 means EOF end of file 
			{
				//System.out.print((char)b); //convert number into char
				 b = (byte) buff.read(); //read successive letters
				 //Thread.sleep(10);
			}
			then = new Date();
			System.out.println("File with    buffering : "+(then.getTime()- now.getTime()) +" ms"  );
			System.out.println("==> DONE ");
			
			
			System.out.println("Trying to close the file....");
			fin1.close();
			System.out.println("File is closed....");
		}
		catch(FileNotFoundException e) {
			System.out.println("File problem : "+e);
			
		} catch (IOException e) {
			System.out.println("I/O problem : "+e);
		} 
		
	}
}
