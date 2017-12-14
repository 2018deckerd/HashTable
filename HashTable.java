/*
 * This class sets up the hash table data structure along with
 * the utility methods to manipulate it.
 */
public class HashTable {

	private Node[] map;
	private int tableSize;
	
	// constructor
	public HashTable(int tableSize) {
		map = new Node[tableSize];
		this.tableSize = tableSize;
	}
	
	/*
	 * This is the hash function.
	 * For this hash function, return 0 if key is the empty string.
	 * Otherwise, calculate the sum of the ASCII values of the characters in key
	 * and find the remainder when divided by 8 (remember mod divisision %).
	 * Check the java API for String methods that may be helpful.
	 */
	private int hash(String key) {
		if (key.equals("")) {
			return 0;
		} else {
			int sum = 0;
			for (int i = 0; i < key.length(); i++) {
				sum = sum + key.codePointAt(i);
			}
			return sum % 8;
		}
	}
	
	/*
	 * This method should insert a node containing the given key
	 * in the proper bucket in the hash table.  Insert new nodes
	 * at the head of each linked list for ease of implementation.
	 */
	public void insert(String key) {
		int index = hash(key);
		Node data = new Node(key);
		data.next = map[index];
		map[index] = data;
	}
	
	/*
	 * This method returns true if the search key is contained in the
	 * hash table, and false otherwise.
	 */
	public boolean search(String key) {
		Node pointer = null;
		int index = hash(key);
		pointer = map[index];
		while (pointer != null) {
			if (pointer.record.equals(key)) {
				return true;
			}
			pointer = pointer.next;
		}
		return false;
}
	
	/*
	 * This method should print out the hash table row by row.
	 * Each line should print out a separate row of the table.
	 * Print the index followed a colon and then the records in that
	 * bucket with spaces between them.
	 * 
	 * For example:
	 * 1: Nicholas Mary Kim Jack
	 */
	public void printTable() {
		Node pointer = null;
		for (int i = 0; i < map.length; i++) {
			System.out.print(i + ": ");
			pointer = map[i];
			while (pointer != null) {
				System.out.print(pointer.record + " ");
				pointer = pointer.next;
			}
			System.out.println("");
		}
		
	}
	
	/*
	 * This method should delete ALL nodes matching the search key.
	 */
	public void delete(String key) {
		if (search(key) == false) {
			// do nothing
		} else {
			Node pointerPrevious = null;
			Node pointer = null;
			int index = hash(key);
			pointerPrevious = map[index];
			pointer = pointerPrevious.next;
			while (pointer != null && pointerPrevious != null) {
				if (pointerPrevious.record.equals(key)) {
					map[index] = map[index].next;
					pointerPrevious = map[index];
					pointer = pointerPrevious.next;
				}
				if (pointer.record.equals(key)) {
					pointerPrevious.next = pointer.next;
				}
			
				pointerPrevious = pointerPrevious.next;
				pointer = pointer.next;
			}
		}
	}
	
}
