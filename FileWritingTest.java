import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWritingTest {
	public static void main(String[] args) {
		
		try {
			System.out.println("Trying to create a File ...");
				FileOutputStream fout = new FileOutputStream("d:\\javatraining1\\newfile.txt",true);
				
			System.out.println("File is ready for writing...");
			/*String paragraph = "function overloading - compile time decision\r\n" + 
					"\r\n" + 
					"			ability of a function to be redefined \r\n" + 
					"			in the same class or across the hierarchy\r\n" + 
					"			provided the following condition are met\r\n" + 
					""; 
			*/
			String paragraph = "New line now";
			
			byte byteArray[] = paragraph.getBytes();
			fout.write(byteArray);
			System.out.println("File data is written...");
			fout.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File Error : "+e);
		} catch (IOException e) {
			System.out.println("File IO  : "+e);
		}
		
	}
}
