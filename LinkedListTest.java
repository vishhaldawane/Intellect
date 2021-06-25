import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class Contact
{
	String contactName;
	String contactMobile;
	String contactEmail;
	public Contact(String contactName, String contactMobile, String contactEmail) {
		super();
		this.contactName = contactName;
		this.contactMobile = contactMobile;
		this.contactEmail = contactEmail;
	}
	@Override
	public String toString() {
		return "Contact [contactName=" + contactName + ", contactMobile=" + contactMobile + ", contactEmail="
				+ contactEmail + "]";
	}
	
	
}
public class LinkedListTest {
	public static void main(String[] args) {
		System.out.println("Preparing content.....");
		Contact cont1 = new Contact("Vishhal", "9820443464", "vishalviniing@gmail.com");
		Contact cont2 = new Contact("Deven", "8820448464", "deve@gmail.com");
		Contact cont3 = new Contact("Jayesh", "7820449464", "jayesh@gmail.com");
		Contact cont4 = new Contact("Milind", "7720443064", "milind@gmail.com");
		
		System.out.println("Content is ready........");
		
		System.out.println("Making the Container....");
		LinkedList myPhoneBook = new LinkedList ();
		System.out.println("Container....is ready...");
		
		System.out.println("Adding the Content in the Container....");
		myPhoneBook.add(cont1);
		myPhoneBook.add(cont2);
		myPhoneBook.add(cont3);
		myPhoneBook.add(cont4);
		
		System.out.println("Added all the Content in the Container....");
		
		System.out.println("Retriving the Iterator from the Container....");
		Iterator myIterator = myPhoneBook.iterator();
		System.out.println("Iterating through the Container....");
		while(myIterator.hasNext())
		{
			Object o = myIterator.next(); // windows button and + <---zoom in
							//windows button and - <---zoom out
			Contact x = (Contact) o; // casting of Object to Song
			System.out.println("Contact : "+x);
		}
		
		System.out.println("End of main....");
	}
}
