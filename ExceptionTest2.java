
public class ExceptionTest2 {
	public static void main(String[] args) {
		System.out.println("Begin main");
		try
		{
			Car c = new Car();
			c.unlockTheCarDoor();
			//c.shortDrive();
		}
		catch(RedSignalDishonouredException e) {
			System.out.println("Problem1 :"+e); //Exception class + Message
		}
		catch(FlatTyreException e) {
			System.out.println("Problem2 :"+e);
		}
		catch(DrivingLicenceException e) {
			System.out.println("Problem3 :"+e);
		}
		System.out.println("End main");
	}
}
//Doors - at our home....  
//AutomaticDoorLocking(Lock is fixed here) - key with you
//	vs ManualDoorLocking ( only latch is here - lock + key with u)

//who has the key??? The Car(Locks on the Doors) or the Driver (Key)?

class RedSignalDishonouredException extends RuntimeException //unchecked
{
	RedSignalDishonouredException(String msg){
		super(msg); //to be stored by the Throwable class 
	}
}
class FlatTyreException extends RuntimeException //unchecked
{
	FlatTyreException (String msg) {
		super(msg); //to be stored by the Throwable class 
	}
}
class DrivingLicenceException extends Exception //checked 
{
	DrivingLicenceException (String msg) {
		super(msg); //to be stored by the Throwable class 
	}
}

class Car
{
	
	void unlockTheCarDoor() throws DrivingLicenceException //mandatory for checked one
	{
		double value = Math.random()%10;
		if(value<0.10) { //short term memory loss
			DrivingLicenceException re = new DrivingLicenceException("Where is the driving licence.....oh no..getting late");
			//Exception re = new Exception("Where is the driving licence.....oh no..getting late");
			throw re;
		}
		else {
			System.out.println("Yes Driving licence is with me!!!! Good memory....");
			startTheCar();
		}
	}
	private void startTheCar() {
		 shortDrive();
	}
	private void shortDrive() //throws clause not mandatory for RuntimeException
	{
		System.out.println("=> Short drive started...");
		for(int i=1;i<=5;i++) {
			System.out.println(i+" Kms completed");
			double value = Math.random()%10;
			if(value > 0.90) {
				RedSignalDishonouredException re = new RedSignalDishonouredException("Oh!!! Red Signal dishonoured...due to high speed....");
				//RuntimeException re = new RuntimeException("Oh!!! Red Signal dishonoured...due to high speed....");
				throw re;
			}
			
			if(value > 0.50 && value <0.70) {
				FlatTyreException re = new FlatTyreException("Oh!!! I guess the tyre is punctured........");
				//Exception re = new Exception("Oh!!! I guess the tyre is punctured........");
				throw re;
			}
			//System.out.println("value "+value);
		}
		System.out.println("=> Short drive finished...");
	}
}
