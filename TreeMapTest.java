import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

class Country
{
	String countryName;
	String capitalName;
	String primeMinister;
	String population;
	String currency;
	
	public Country(String countryName, String capitalName, String primeMinister, String population, String currency) {
		super();
		this.countryName = countryName;
		this.capitalName = capitalName;
		this.primeMinister = primeMinister;
		this.population = population;
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "Country [countryName=" + countryName + ", capitalName=" + capitalName + ", primeMinister="
				+ primeMinister + ", population=" + population + ", currency=" + currency + "]";
	}

}
public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<String,Country> nuclearPowerContriesMap = new TreeMap<String,Country>();
		
		Country c1 = new Country("India", "New Delhi", "Mr. Narendra Modi", "136.64 Crores", "Rs");
		Country c2 = new Country("Pakistan", "Islamabad", "Mr. Imran Khan", "21.66 Crores", "Pakistani Rupee");
		Country c3 = new Country("China", "Beijing", "Mr. Xi Jinping", "139.77 Crores", "Yuan");
		Country c4 = new Country("UK", "London", "Mr. Boriss Johnson", "6.66 Crores", "Pound Sterling");
		Country c5 = new Country("USA", "Washington DC", "Mr. Joe Biden", "32.82 Crores", "USD");
		
		
		System.out.println("Putting values in the map");
		
		nuclearPowerContriesMap.put("IND",c1);
		nuclearPowerContriesMap.put("PAK",c2);
		nuclearPowerContriesMap.put("CHI",c3);
		nuclearPowerContriesMap.put("UK",c4);
		nuclearPowerContriesMap.put("USA",c5);
		
		System.out.println("Retrieve the values from the map...");
		
		Set<String> allKeys = nuclearPowerContriesMap.keySet();
		Iterator<String> keyIter = allKeys.iterator();
		while(keyIter.hasNext()) {
			String actualKey = keyIter.next();
			Country theCountry = nuclearPowerContriesMap.get(actualKey);
			System.out.println("The Country : "+theCountry);
		}
		System.out.println("================");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter key : ");
		String key = scan.nextLine();
		if(nuclearPowerContriesMap.containsKey(key)) {
			Country countryFound = nuclearPowerContriesMap.get(key);
			System.out.println("Country found : "+countryFound);
		}
		else {
			System.out.println("Key not found "+key);
		}
	}
}













