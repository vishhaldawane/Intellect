class MyValues<T>//what are the services offered by this class
{
	private T i;	private T j; // DATA MEMBERS PAIR FOR INTEGERS
	
	MyValues(T i, T j) { // INITIALIZATION OF THE PAIR
		this.i = i;
		this.j = j;
	}
	public void printMyValues() //PRINTING OF THE PAIR
	{
		System.out.println("MyValues:printMyValues: i "+i);
		System.out.println("MyValues:printMyValues: j "+j);
	}
	public void swapMyValues() { // SWAPPING OF THE PAIR VALUES
		System.out.println("MyValues:swapMyValues: Swapping..anyvalue");
		T temp;		temp = i;		i = j;		j = temp;
		System.out.println("MyValues:swapMyValues: Swapped..anyvalue");
	}
}

public class GenericTest4 {
	public static void main(String[] args) {
		
		MyValues mi1 = new MyValues(10,20);// wrapped in an object
		mi1.printMyValues();
		mi1.swapMyValues();
		mi1.printMyValues();
		
		System.out.println("------------------");
		
		MyValues mi2 = new MyValues(30.5f,60.9f);// wrapped in an object
		mi2.printMyValues();
		mi2.swapMyValues();
		mi2.printMyValues();
		
		System.out.println("------------------");
		
		MyValues mi3 = new MyValues('D','N');// wrapped in an object
		mi3.printMyValues();
		mi3.swapMyValues();
		mi3.printMyValues();
		
		System.out.println("------------------");
		
		MyValues mi4 = new MyValues(100.0,150.0);// wrapped in an object
		mi4.printMyValues();
		mi4.swapMyValues();
		mi4.printMyValues();
		

		System.out.println("------------------");
		
		MyValues mi5 = new MyValues("John","Julie");// wrapped in an object
		mi5.printMyValues();
		mi5.swapMyValues();
		mi5.printMyValues();

	}
}
