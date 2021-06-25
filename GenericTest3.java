class MyIntegers //what are the services offered by this class
{
	private int i;	private int j; // DATA MEMBERS PAIR FOR INTEGERS
	
	MyIntegers(int i, int j) { // INITIALIZATION OF THE PAIR
		this.i = i;
		this.j = j;
	}
	
	public void printInteger() //PRINTING OF THE PAIR
	{
		System.out.println("MyIntegers:printInteger: i "+i);
		System.out.println("MyIntegers:printInteger: j "+j);
	}
	
	public void swapIntegers() { // SWAPPING OF THE PAIR VALUES
		System.out.println("MyIntegers:swapIntegers: Swapping..ints");
		int temp = i;		i = j;		j = temp;
		System.out.println("MyIntegers:swapIntegers: Swapped..ints");
	}
	
}

class MyFloats //what are the services offered by this class
{
	private float i;	private float j; // DATA MEMBERS PAIR FOR FLOATS
	
	MyFloats(float i, float  j) { // INITIALIZATION OF THE PAIR
		this.i = i;
		this.j = j;
	}
	
	public void printFloats() //PRINTING OF THE PAIR
	{
		System.out.println("MyFloats:printFloats: i "+i);
		System.out.println("MyFloats:printFloats: j "+j);
	}
	
	public void swapFloats() { // SWAPPING OF THE PAIR VALUES
		System.out.println("MyFloats:swapFloats: Swapping..floats");
		float temp = i;		i = j;		j = temp;
		System.out.println("MyFloats:swapFloats: Swapped..floats");
	}
}


class MyCharacters //what are the services offered by this class
{
	private char i;	private char j; // DATA MEMBERS PAIR FOR FLOATS
	
	MyCharacters(char i, char j) { // INITIALIZATION OF THE PAIR
		this.i = i;
		this.j = j;
	}
	
	public void printCharacters() //PRINTING OF THE PAIR
	{
		System.out.println("MyCharacters:printCharacters: i "+i);
		System.out.println("MyCharacters:printCharacters: j "+j);
	}
	
	public void swapCharacters() { // SWAPPING OF THE PAIR VALUES
		System.out.println("MyCharacters:swapCharacters: Swapping..Characters");
		char temp = i;		i = j;		j = temp;
		System.out.println("MyCharacters:swapCharacters: Swapped..Characters");
	}
}

public class GenericTest3 {
	public static void main(String[] args) {
		
		MyIntegers mi = new MyIntegers(10,20);// wrapped in an object
		mi.printInteger();
		mi.swapIntegers();
		mi.printInteger();
		
		System.out.println("------------------");
		
		MyFloats mf = new MyFloats(30.5f,40.8f);// wrapped in an object
		mf.printFloats();
		mf.swapFloats();
		mf.printFloats();
		
		System.out.println("------------------");
		
		MyCharacters mch = new MyCharacters('N','D');// wrapped in an object
		mch.printCharacters();
		mch.swapCharacters();
		mch.printCharacters();
		
		
		
		
	}
}
