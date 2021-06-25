
public class GenericTest {
	public static void main(String[] args) {
		
		int i=10;
		int j=20;
		
		System.out.println("i "+i);
		System.out.println("j "+j);
		
		System.out.println("Swapping..ints");
		int temp = i;
		i = j;
		j = temp;
		System.out.println("Swapped..ints");
		
		System.out.println("i "+i);
		System.out.println("j "+j);
		
		
		int p=50; //declaration cum initializaion
		int q=60;
		
		System.out.println("p "+p); //printing
		System.out.println("q "+q);
		
		System.out.println("Swapping..ints"); //swapping
		int temp1 = p;
		p = q;
		q = temp1;
		System.out.println("Swapped..ints");
		
		System.out.println("p "+p); //again printing
		System.out.println("q "+q);
		
	}
}
