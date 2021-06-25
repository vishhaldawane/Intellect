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
			
			Book b7 = b4;
			
		System.out.println("Content is ready........");
		
		System.out.println("Making the Container....");
			HashSet<Book> myBookShelf = new HashSet<Book>();
			
		System.out.println("Container....is ready...");
		
		System.out.println("Adding the Content in the Container....");
		myBookShelf.add(b1);
		myBookShelf.add(b2);
		myBookShelf.add(b3);
		
		myBookShelf.add(b4);
		myBookShelf.add(b5);
		myBookShelf.add(b6);
		myBookShelf.add(b7);
		
		
	
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
