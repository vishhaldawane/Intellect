
public class ExceptionTest1 {
	public static void main(String[] args) {
		
		String str=null;//="Intellect Arena";
		try
		{
			System.out.println("str : "+str);
			System.out.println("str : "+str.length());
			try
			{
				System.out.println("str : "+str.charAt(17));
			}
			catch(StringIndexOutOfBoundsException e) {
				System.out.println("String index is out of range...");
			}

			System.out.println("str : "+str.toUpperCase());
			System.out.println("str : "+str.toLowerCase());
	
			String companies[]= {"Google","IBM","Microsoft"};
			try
			{
				System.out.println("company : "+companies[3]);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Invalid index of the array... ");
			}
		
			System.out.println("End of main");
		}
		catch(NullPointerException e) {
			System.out.println("Null value is set...");
		}
	}
}

