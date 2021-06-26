import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

class Book
{
	int bookNumber;
	String bookName;
	String bookAuthor;
	int bookEdition;
	float bookCost;
	int numberOfPages;
	public Book(int bookNumber, String bookName, String bookAuthor, int bookEdition, float bookCost,
			int numberOfPages) {
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookEdition = bookEdition;
		this.bookCost = bookCost;
		this.numberOfPages = numberOfPages;
	}
	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor
				+ ", bookEdition=" + bookEdition + ", bookCost=" + bookCost + ", numberOfPages=" + numberOfPages + "]";
	}
	@Override
	public int hashCode() { // artificial number generation 
				// would be same if the contens are same
		
		final int prime = 31;
		
		int result = 1;					//JG - 55
		result = prime * result + ((bookAuthor == null) ? 0 : bookAuthor.hashCode());
		
				//31   *  81 = 2511 + 1200 = 3711
		result = prime * result + Float.floatToIntBits(bookCost); //1200
		
			   //	31  * 3711 + 115041 + 4      
		result = prime * result + bookEdition; //4 -> 115045
		
					//31 * 115045 = 3566395 + 10 
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode()); //Java
		
			//	 31 * 3566405 + 101 = 3566506
		result = prime * result + bookNumber; //101
		
		//31 * 3566506 = 110561686 + 1000 = 110562686 
		result = prime * result + numberOfPages; //1000
		return result;
	}  
	/*
	 * Book b1 = new Book(101, "The Java Programming Language", "James Gosling", 4, 1200,1000);
	 * Book b1 = new Book(101, "The Java Programming Language", "Kathey S", 4, 1200,1000);
	 * 
	 * 
	   Book b2 = new Book(102, "The C++ Programming Language", "Bjarne Stroustup", 2, 800,1500);
			
	 * 
	 */
	
	@Override
	public boolean equals(Object obj) {
		//why the boolean is by default false :
		
		//"false" does not require "the proof" to prove it "as a false"
		
		//It is BAD to "feel bad" to "remove bad habits"
		//It is GOOD to "feel good" to "improve good habits"
		
		
		//the court needs a proof to prove as truth 
		
		if (this == obj) // shelf.add(b1); shelf.add(b1);
			return true;
		
		if (obj == null) // shelf.add(null);
			return false;
		
		if (getClass() != obj.getClass())  //shelf.add(b1); shelf.add(accObj);
			return false;
		
		Book other = (Book) obj; //casting into a Book
		
		if (bookAuthor == null) {
			if (other.bookAuthor != null)
				return false;
			
		} else if (!bookAuthor.equals(other.bookAuthor))
			return false; // indication to hashSet to take it as a unique object
		
		
		if (Float.floatToIntBits(bookCost) != Float.floatToIntBits(other.bookCost))
			return false;
		
		if (bookEdition != other.bookEdition)
			return false;
		
		if (bookName == null) {
			if (other.bookName != null)
				return false;
			
		} else if (!bookName.equals(other.bookName))
			return false;
		
		if (bookNumber != other.bookNumber)
			return false;
		
		if (numberOfPages != other.numberOfPages)
			return false;
		
		return true; //to come here, all the fields must be same
	}
	
	
}
public class HashSetTest {
	public static void main(String[] args) {
		System.out.println("Preparing content.....");
			Book b1 = new Book(101, "The Java Programming Language", "James Gosling", 4, 1200,1000);
			Book b2 = new Book(102, "The C++ Programming Language", "Bjarne Stroustup", 2, 800,1500);
			Book b3 = new Book(103, "The C Programming Language", "Dennis Ritchie", 1, 500,900);
			
			Book b4 = new Book(104, "The Autobiography Of A Yogi", "SS Paramhansa Yogananda", 1, 175, 730);
			Book b5 = new Book(104, "The Autobiography Of A Yogi", "SS Paramhansa Yogananda", 1, 175, 730);
			Book b6 = new Book(104, "The Autobiography Of A Yogi", "SS Paramhansa Yogananda", 1, 175, 730);
			//b5 and b6 are added, since hashcodes are different
			//but content is same!!!! 
			//how do we inform hashset's add() algorithm ???? 
			//identify unique ness based on hashcode() + equals()
			
			Book b7 = b4; // book wont be added again, since hashcode of 
			//both b7 and b4 is the same
			/*System.out.println("b1 "+b1.hashCode());
			System.out.println("b2 "+b2.hashCode());
			System.out.println("b3 "+b3.hashCode());
			System.out.println("b4 "+b4.hashCode());
			System.out.println("b5 "+b5.hashCode());
			System.out.println("b6 "+b6.hashCode());
			System.out.println("b7 "+b7.hashCode());*/
			
		System.out.println("Content is ready........");
		
		System.out.println("Making the Container....");
			HashSet<Book> myBookShelf = new HashSet<Book>();
			
		System.out.println("Container....is ready...");
		
		System.out.println("Adding the Content in the Container....");
		myBookShelf.add(b1);
		myBookShelf.add(b2);
		myBookShelf.add(b3);
		
		myBookShelf.add(b4);
		myBookShelf.add(b5); //it is the same book
		myBookShelf.add(b6); //it is the same book
		myBookShelf.add(b7); //it is the same book
		
		
	
		System.out.println("Added all the Content in the Container....");
		
		System.out.println("Retriving the Iterator from the Container....");
		Iterator myIterator = myBookShelf.iterator();
		System.out.println("Iterating through the Container....");
		while(myIterator.hasNext())
		{
			Object o = myIterator.next(); // windows button and + <---zoom in
							//windows button and - <---zoom out
			Book x = (Book) o; // casting of Object to Song
			System.out.println("Book : "+x);
		}
		
		System.out.println("End of main....");
	}
}
