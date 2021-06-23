
class Machine
{
	private int machineNumber; // unique id 
	private String manufacturer; // creator
		
	public Machine(int machineNumber, String manufacturer) {
		super();
		this.machineNumber = machineNumber;
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Machine [machineNumber=" + machineNumber + ", manufacturer=" + manufacturer + "]";
	}
	
		
}

class Tub
{
	
}

class WashingTub extends Tub //isA
{
	String materialType; //platic / steel
	boolean isSanitizer;// check if sanitization inlet is there or not
	public WashingTub(String materialType, boolean isSanitizer) {
		super();
		this.materialType = materialType;
		this.isSanitizer = isSanitizer;
	}
	
	@Override
	public String toString() {
		return "WashingTub [materialType=" + materialType + ", isSanitizer=" + isSanitizer + "]";
	}
	
	
}

class WashingMachine extends Machine //isA  -STRUCTURAL SUPPORT
{
	private String modelName;
	private String capacity;
	private WashingTub washTub ; //hasA    -STRUCTURAL SUPPORT ---> let it be null here
	private int minutes=20; // min wash timing
	
	public WashingMachine(int machineNumber, String manufacturer, String modelName, String capacity, String tubType ,boolean isSanizationAvailable) {
		super(machineNumber, manufacturer);
		this.modelName = modelName;
		this.capacity = capacity;
		washTub = new WashingTub(tubType,isSanizationAvailable); //hasA
	}

	@Override
	public String toString() {
		return "WashingMachine [toString()=" + super.toString() + ", modelName=" + modelName + ", capacity=" + capacity
				+ ", washTub=" + washTub + "]";
	} 
	
//FUNCTIONAL/OPERATIONAL		FUNCTIONAL/OPERATIONAL	FUNCTIONAL/OPERATIONAL	FUNCTIONAL/OPERATIONAL
//producesA							usesA			uses		usesA				usesA
	LaundryBill  washingProgram(Electricity elect, Water w, WashingPowder washPow, Cloth c[])
	{
		//panel is shown here... for user to select the wash type, fuzzy, blanket, saree, tubclean ...
		//water level is also selected  mid, low, high very high
		// timer .. 20 30 40 60
		// water type : hot | cold
		System.out.println("Electricity   : "+elect);
		System.out.println("Water         : "+w);
		System.out.println("WashingPowder : "+washPow);	
		System.out.println("Cloths        : ");
		for(int i=0;i<c.length;i++) {
			System.out.println("Cloth "+c[i]);
		}
		wash(c);
		LaundryBill laundryBill = new LaundryBill("Cloth",50,c.length);
		return laundryBill ;
	}
				//passed here as an argument - hence known as usesA relationship
	private void wash(Cloth c[]) 
	{
		int i=1;
		
		while(i<=minutes) {
			System.out.println("Washing started....");
			i++;
			
		}
		for(int j=0;j<c.length;j++) {
			c[j].clothStatus="clean";
		}
	}
	
}

class Water
{
	String mineralLevels;
	String phLevel;
	int quantity;
	
	public Water(String mineralLevels, String phLevel, int quantity) {
		super();
		this.mineralLevels = mineralLevels;
		this.phLevel = phLevel;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Water [mineralLevels=" + mineralLevels + ", phLevel=" + phLevel + ", quantity=" + quantity + "]";
	}
	
	
}
/*
class HardWater extends Water
{
	
	
}
class SoftWater extends Water
{
	
}
*/

class Power
{
	
}
class Electricity extends Power //isA
{
	private String volateCapacity; //220 
	private String powerProvider;
	
	public Electricity(String volateCapacity, String powerProvider) {
		super();
		this.volateCapacity = volateCapacity;
		this.powerProvider = powerProvider;
	}
	
	@Override
	public String toString() {
		return "Electricity [volateCapacity=" + volateCapacity + ", powerProvider=" + powerProvider + "]";
	} 

}

class Powder
{
	
}
class TalcumPowder extends Powder { }

class WashingPowder extends Powder 
{ 
	String washingPowderBrand;
	int quantity;
	
	public WashingPowder(String washingPowderBrand, int quantity) {
		super();
		this.washingPowderBrand = washingPowderBrand;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "WashingPowder [washingPowderBrand=" + washingPowderBrand + ", quantity=" + quantity + "]";
	}
	
	
}

class Cloth
{
	String clothType;
	String clothBrand;
	String clothMaterialType;
	String clothStatus; //clean / dirty
	float clothCost;
	String clothSize;
	String clothColor;
	
	public Cloth(String clothType,String clothBrand, String clothMaterialType, String clothStatus, float clothCost, String clothSize,
			String clothColor) {
		super();
		this.clothType = clothType;
		this.clothBrand = clothBrand;
		this.clothMaterialType = clothMaterialType;
		this.clothStatus = clothStatus;
		this.clothCost = clothCost;
		this.clothSize = clothSize;
		this.clothColor = clothColor;
	}
	@Override
	public String toString() {
		return "Cloth [clothBrand=" + clothBrand + ", clothType=" + clothType + ", clothStatus=" + clothStatus
				+ ", clothCost=" + clothCost + ", clothSize=" + clothSize + ", clothColor=" + clothColor + "]";
	}
	
	
}

class Bill { }

class LaundryBill 
{
	String typeOfCloth;
	float costPerItem;
	float totalCost;
	int numberOfCloths;
	
	
	public LaundryBill(String typeOfCloth, float costPerItem, int numberOfCloths) {
		super();
		this.typeOfCloth = typeOfCloth;
		this.costPerItem = costPerItem;
		this.numberOfCloths = numberOfCloths;
		calculateLaundryBill();
	}
	private void calculateLaundryBill() {
		totalCost = costPerItem * numberOfCloths;
	}
	
	@Override
	public String toString() {
		return "LaundryBill [typeOfCloth=" + typeOfCloth + ", costPerItem=" + costPerItem + ", totalCost=" + totalCost
				+ ", numberOfCloths=" + numberOfCloths + "]";
	}


	
}
public class AssociationTest {
	public static void main(String[] args) {
		Machine m1 = new Machine(123,"Tata Power");
			//toString() --> getClass().getName() + '@' + hashCode();
		
		System.out.println("m1 "+m1); //toString() -> Machine+@+hashCode
		
		WashingMachine washMach = new WashingMachine(122, "Tata Power", "Samsung", "9.5kg","Steel",true);
		System.out.println("washMach : "+washMach);
		
		Electricity ele = new Electricity("220V","Reliance");
		Water w = new Water("45", "7", 50);
		
		Cloth myCloths[] = {
				new Cloth("Jeans","Levis", "Jean", "dirty", 3000, "32", "DarkBlue"),
				new Cloth("Jeans","Levis", "Jean", "dirty", 4000, "32", "Black"),
				new Cloth("Jeans","Levis", "Jean", "dirty", 5000, "32", "Navy"),
				new Cloth("Tshirt","Levis", "Cotton", "dirty", 500, "34", "White"),
				new Cloth("Tshirt","Levis", "Cotton", "dirty", 800, "34", "Red"),
				new Cloth("Tshirt","Levis", "Cotton", "dirty", 500, "34", "Pink"),
				new Cloth("Tshirt","Levis", "Cotton", "dirty", 800, "34", "Green")
		};

		
		WashingPowder washPowder = new WashingPowder("Tide", 3);
		LaundryBill myLaundryBill = washMach.washingProgram(ele, w, washPowder, myCloths);
		System.out.println("----------after wash -----------");
		
		for(int j=0;j<myCloths.length;j++) {
			System.out.println("Status : "+myCloths[j].clothStatus);
		}
		
		System.out.println("Laundry bill : "+myLaundryBill);
	}
	
}
