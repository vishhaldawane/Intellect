import java.util.Scanner;

class Doctor //does not know who the child is!!!!!
{
	void diagnose() { //1. exclusive method
		System.out.println("Doctor: Diagnosing...");
	}
}
class Surgeon extends Doctor //child knows who the parent is!!
{
	void diagnose() { //2. it is inherited+overridden method
		System.out.println("Surgeon: Diagnosing...");
	}
	void doSurgery() { //1. it is exclusive method
		System.out.println("Surgeon: doing surgery...");
	}
}
//4. implemented method ( will see at interface time)
class HeartSurgeon extends Surgeon
{
	//3. the doSurgery() is inherited here + u may override it
	
	void diagnose() {
		System.out.println("HeartSurgeon: Diagnosing...");
	}
	void doHeartSurgery() { //1. exclusive method
		
	}
}
class Patient {
	
}
class Hospital
{
	static Doctor getDoctor() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Select Choice of Doctor");
		System.out.println("1. Doctor | Savings");
		System.out.println("2. Surgeon | Current");
		System.out.println("3. HeartSurgeon | Credit");
		int choice = scan.nextInt();
		Doctor d = null;
		switch(choice) {
			case 1: d = new Doctor(); break;  
			case 2: d = new Surgeon(); break;
			case 3: d = new HeartSurgeon(); break;
		}
		return d;
	}
}
public class DoctorTest {
	public static void main(String[] args) {
		Doctor d = Hospital.getDoctor(); //Doctor is hidden here
		
		if(d instanceof HeartSurgeon) { //typeof in C++ - RTTI
			System.out.println("d is pointing at HeartSurgeon");
		}
		else if(d instanceof Surgeon) { //typeof in C++ - RTTI
			System.out.println("d is pointing at Surgeon");
		}
		else if (d instanceof Doctor) {
			System.out.println("d is pointing at Doctor");
		}
		
	}
}
