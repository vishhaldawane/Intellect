
public class ExceptionTest2 {
	public static void main(String[] args) {
		System.out.println("Begin main");
		
		Car c = new Car();
		try
		{
			c.unlockTheCarDoor();
		}
		catch(RedSignalDishonouredException e) {
			System.out.println("Problem1 :"+e); //Exception class + Message
		}
		catch(FlatTyreException e) {
			System.out.println("Problem2 :"+e);
			c.stopTheCar();
		}
		catch(DrivingLicenceException e) {
			System.out.println("Problem3 :"+e);
		}
		finally {
			for(int i=0;i<c.wheels.length;i++) {
				if(c.wheels[i].isWorking!=true) {
					System.out.println("Park the car aside to repair the puncture....");
					break;
				}
			}
			System.out.println("Finally invoked regardless of the exceptions...");
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

class Wheel {
	int wheelNumber; //1234 5(stepney)
	boolean isWorking; //  on or flat
	String wheelModel;
	float suggestedTyrePressure;
	
	public Wheel(int wheelNumber, boolean isWorking, String wheelModel, float suggestedTyrePressure) {
		super();
		this.wheelNumber = wheelNumber;
		this.isWorking = isWorking;
		this.wheelModel = wheelModel;
		this.suggestedTyrePressure = suggestedTyrePressure;
	}

	@Override
	public String toString() {
		return "Wheel [wheelNumber=" + wheelNumber + ", isWorking=" + isWorking + ", wheelModel=" + wheelModel
				+ ", suggestedTyrePressure=" + suggestedTyrePressure + "]";
	}

	public int getWheelNumber() {
		return wheelNumber;
	}

	public void setWheelNumber(int wheelNumber) {
		this.wheelNumber = wheelNumber;
	}

	public boolean isWorking() {
		return isWorking;
	}

	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}

	public String getWheelModel() {
		return wheelModel;
	}

	public void setWheelModel(String wheelModel) {
		this.wheelModel = wheelModel;
	}

	public float getSuggestedTyrePressure() {
		return suggestedTyrePressure;
	}

	public void setSuggestedTyrePressure(float suggestedTyrePressure) {
		this.suggestedTyrePressure = suggestedTyrePressure;
	}
	
	
}

class Car
{
	Wheel wheels[] = {
			/*Wheel frontRight = */new Wheel(1, true, "JK Tyre", 32.0f),
			/*Wheel frontLeft  = */new Wheel(2, true, "JK Tyre", 32.0f),
			/*Wheel backRight  = */new Wheel(3, true, "JK Tyre", 33.0f),
			/*Wheel backLeft   = */new Wheel(4, true, "JK Tyre", 33.0f)
	};
	Wheel stepney    = new Wheel(5, true, "JK Tyre", 33.0f);
	
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
	public void stopTheCar() {
		 System.out.println("Stopping the Car...");
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
				//Exception re = new Exception("Oh!!! I guess the tyre is punctured........");
				int min=0; int max=3;
				int randomIndex = (int) Math.floor(Math.random() * (max-min+1) + min );
				wheels[randomIndex].isWorking=false;
				FlatTyreException re = new FlatTyreException("Oh!!! I guess the tyre is punctured........wheels["+randomIndex+"] status : "+wheels[randomIndex].isWorking);
				throw re;
			}
			//System.out.println("value "+value);
		}
		System.out.println("=> Short drive finished...");
	}
}
