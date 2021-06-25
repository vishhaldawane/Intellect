
public class GenericTest2 {
	public static void printInteger(int x, int y)
	{
		System.out.println("printInteger: x "+x);
		System.out.println("printInteger: y "+y);
	}
	public static void swapIntegers(int x, int y) {
		System.out.println("swapIntegers: Swapping..ints");
		int temp = x;		x = y;		y = temp;
		System.out.println("swapIntegers: Swapped..ints");
	}
	public static void main(String[] args) {
		int i=10;	int j=20;
		printInteger(i,j);	swapIntegers(i,j);	printInteger(i,j);
		
		int p=50; 	int q=60;
		printInteger(p,q);	swapIntegers(p,q);	printInteger(p,q);
	}
}
