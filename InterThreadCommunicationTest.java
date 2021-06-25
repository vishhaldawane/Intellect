
public class InterThreadCommunicationTest {
	public static void main(String[] args) {
		FoodItem food = new FoodItem("Masala Dosa");
		Server serverObj = new Server(food);
		Eater eaterObj = new Eater(food);
		serverObj.start();
		eaterObj.start();
	}
}

interface Serving {	void serve(); }
interface Eating  {	void eat();   }
class FoodItem implements Serving, Eating
{
	String foodItemName;
	boolean isServed=false;
	
	FoodItem (String x) { foodItemName = x ; }
	public synchronized void serve() {
		if(isServed==false) // by default it is false
		{
			System.out.println("Server: Serving : "+foodItemName);
			isServed= true;
			System.out.println("Server: Served  : "+foodItemName);
			notify(); // notifies the awaiting thread....to release the wait() and proceed next lines
			//must be invoked from a monitor | synchronized block
		}
	}
	public synchronized void eat() {
		if(isServed==false) // by default it is false 
		{
			System.out.println("Eater : Awaiting for the Server to serve the food : "+foodItemName);
			try {
				wait(); //must be invoked from a monitor | synchronized block
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //from Object class
		}
		
		System.out.println("Eater : Thank you for serving the food : "+foodItemName);
		System.out.println("Eater : Eating  : "+foodItemName);
		
	}
}
class Server extends Thread 
{
	Serving foodRef;
	
	Server(FoodItem x) { foodRef = x; }
	
	public void run() {
		//foodRef.eat();
		foodRef.serve();
	}
}
class Eater extends Thread 
{
	Eating foodRef;
	
	Eater(FoodItem x) { foodRef = x; }
	
	public void run() { //if gets the first chance to run, then it should verify the production of the food
		foodRef.eat(); //if the food is produced, only then it should consume, else it has to wait
		//foodRef.serve();
	}
}
