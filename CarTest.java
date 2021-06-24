
public class CarTest {
	public static void main(String[] args) {
		//Movable m = new Movable(); // cannot instantiate
		//Vehicle v = new Vehicle();
		//v.start(); //call the move() via the start()
		Car c = new Car();
		c.start(); //here invoker is c, hence the move() of c is called..
	}
}
interface Movable { //same as java.lang.Runnable
	void move();
}
class Vehicle /*same as java.lang.Thread */ implements Movable {
	public void move() { //mandate
		System.out.println("Vehicle is moving...");
	}
	public void start() {
		System.out.println("Talking to JVM thread scheduler...");
		move();
		System.out.println("Talk is over...");
	}
}
class Car extends Vehicle //ur car extends Thread
{
	public void move() { //not mandate...just overriding
		System.out.println("Car is moving...");
	}
}
