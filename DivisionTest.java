import java.util.Scanner;

//java DivisionTest
// |
//"main" --> DivisionTest.main()

public class DivisionTest {
	public static void main(String[] args) {
		
		System.out.println("Begin Main");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter num : ");
		int num = scan.nextInt();
		System.out.println("num "+num);
		
		System.out.println("Enter den : ");
		int den = scan.nextInt();
		System.out.println("den "+den);
		
	
		//below line "must be verified" by the compiler
		
		// below line is intentionally ignored by the compiler
		// and the decision is upto the runtime environment
		
		//before the birth of try and catch, the best one is if condition
		
		/*
		if(den !=0 ) { // BUSINESS LOGIC BELOW
			int div = num / den ; //illegal math expression | memory activity
			System.out.println("div "+div);
		}
		else { //ERROR HANDLING LOGIC/MSG 
			System.out.println("Cannot divide by zero....");
		}
		
		*/
	/*	if(den ==0 ) { //ERROR HANDLING LOGIC/MSG
			System.out.println("Cannot divide by zero....");
		}
		else {  // BUSINESS LOGIC BELOW 
			int div = num / den ; //illegal math expression | memory activity
			System.out.println("div "+div);
		}
	*/
		try 
		{
			int div = num / den ; //illegal math expression | memory activity
			System.out.println("div "+div);
		}
		catch(ArithmeticException e) {
			System.out.println("Cannot divide by zero...");
		}
		
		System.out.println("End Main");
	}
}
