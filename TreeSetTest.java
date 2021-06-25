import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

class ChemicalElement implements Comparable<ChemicalElement>
{
	int atomicNumber;
	String atomicName;
	String atomicFormula;
	double atomicWeight;
	
	public ChemicalElement(int atomicNumber, String atomicName, String atomicFormula, double atomicWeight) {
		super();
		this.atomicNumber = atomicNumber;
		this.atomicName = atomicName;
		this.atomicFormula = atomicFormula;
		this.atomicWeight = atomicWeight;
	}
	@Override
	public String toString() {
		return "ChemicalElement [atomicNumber=" + atomicNumber + ", atomicName=" + atomicName + ", atomicFormula="
				+ atomicFormula + ", atomicWeight=" + atomicWeight + "]";
	}
	@Override
	/*public int compareTo(ChemicalElement x) {
		System.out.println("Comparing "+x.atomicNumber+ " with "+atomicNumber);
		return Integer.compare(x.atomicNumber, atomicNumber);
		
		//if(atomicNumber > x.atomicNumber) 
		//	return 1;
		//else if(atomicNumber < x.atomicNumber) 
		//	return -1;
		//else
			//return 0;
	}*/
	public int compareTo(ChemicalElement x) {
		System.out.println("Comparing "+atomicName+ " with "+x.atomicName);
		return atomicName.compareTo(x.atomicName); //c++>strcmp()  java->equals
		
		/*if(atomicNumber > x.atomicNumber) 
			return 1;
		else if(atomicNumber < x.atomicNumber) 
			return -1;
		else
			return 0;*/
	}
	
	
}

public class TreeSetTest {
	public static void main(String[] args) {
		System.out.println("Preparing content.....");
		
		ChemicalElement element1 = new ChemicalElement(7,"Nitrogen","N",14.007);
		ChemicalElement element2 = new ChemicalElement(12,"Magnesium","Mg",24.305);
		ChemicalElement element3 = new ChemicalElement(3,"Lithium","Li",6.94);
		ChemicalElement element4 = new ChemicalElement(1,"Hydrogen","H",1.0);
		ChemicalElement element5 = new ChemicalElement(15,"Phosphorus","P",30.974);
		
		System.out.println("Content is ready........");
		
		
		System.out.println("Making the Container....");
			TreeSet<ChemicalElement> periodicTableSet = new TreeSet<ChemicalElement>();
		System.out.println("Container....is ready...");
		
		System.out.println("Adding the Content in the Container....");
			periodicTableSet.add(element1); //?????? how to add??? on which column to decide???
			periodicTableSet.add(element2); // internally int 20  is Integer(20)
			periodicTableSet.add(element3);
			periodicTableSet.add(element4);
			periodicTableSet.add(element5);
			
		System.out.println("Added all the Content in the Container....");
		
		System.out.println("Retriving the Iterator from the Container....");
		Iterator myIterator = periodicTableSet.iterator();
		System.out.println("Iterating through the Container....");
		while(myIterator.hasNext())
		{
			Object o = myIterator.next(); // windows button and + <---zoom in
							//windows button and - <---zoom out
			ChemicalElement x = (ChemicalElement) o; // casting of Object to Song
			//Integer x = (Integer) o; // casting of Object to Song
			System.out.println("Contact : "+x);
		}
		
		System.out.println("End of main....");
	}
}
