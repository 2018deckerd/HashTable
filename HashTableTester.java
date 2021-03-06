/**
 * This is the main tester class for the HashTable class which implements
 * a hash table for string data.
 * 
 * Do not change this class.
 * 
 * @author Michael Ida
 *
 */
public class HashTableTester {

	public static void main(String[] args) {
		String[] testData = {"Anne", "Betty", "Charlie", "Betty", "Doug", "Emma",
				"Frank", "Greta", "Harry", "Irene", "Jack", "Kim", "Lenny",
				"Mary", "Nicholas", "Ophelia", "Paul", "Queenie", "Rich",
				"Betty", "Betty"};
		
		// set up the hash table
		HashTable table = new HashTable(8);
		for (String rec : testData) {
			table.insert(rec);
		}
		
		// print out original table
		System.out.println("ORIGINAL TABLE");
		table.printTable();
		/*
		 * should be:
		 * 0: Betty Betty Emma Betty Charlie Betty
		 * 1: Nicholas Mary Kim Jack
		 * 2: Paul Ophelia Frank Anne
		 * 3: Irene Greta
		 * 4: Queenie
		 * 5:
		 * 6: Rich Lenny Harry
		 * 7: Doug
		 */
		
		// test search method
		System.out.println();
		System.out.println("\"Lenny\" FOUND? " + table.search("Lenny"));
		// should be true
		System.out.println("\"Xavier\" FOUND? " + table.search("Xavier"));
		// should be false
		System.out.println();
		
		// test delete method
		System.out.println("TABLE WITH \"Betty\" DELETED");
		table.delete("Betty");
		table.printTable();
	}
	
}
