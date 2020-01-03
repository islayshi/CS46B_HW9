package hashtable;

import java.util.ArrayList;

// Class to represent entire hash table 
class MyHashTable<K, V> {
	// bucketArray is used to store array of chains
	private ArrayList<HashNode<K, V>> bucketArray;

	// Current capacity of array list
	private static int numBuckets = 10;

	// Current size of array list
	private int size = 0;

	// Constructor (Initializes capacity, size and
	// empty chains.
	public MyHashTable() {
		this.bucketArray = new ArrayList<>(numBuckets);
		this.size = 0;
		for (int i = 0; i < numBuckets; i++) {
			bucketArray.add(null);
		}
	}

	// Implement the size() method
	public int size() {
		return size;
	}

	// Implement the isEmpty() method
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	// This implements hash function to find index for a key.
	// Do not change this method
	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % numBuckets;
		return index;
	}

	// Implement remove() method
	// Apply hash function to find index for given key
	// Get head of chain
	// Search for key in its chain. If Key found remove the node and return the
	// value of the node. If key not found return null.
	public V remove(K key) {
		int index = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(index);

		// Search for key in its chain
		HashNode<K, V> prev = null;
		while (head != null) {
			// If Key found
			if (head.key.equals(key)) {
				break;
			}
			prev = head;
			head = head.next;
		}
		// If key doesn't exist
		if (head == null) {
			return null;
		}
		// decrement size
		size--;
		if (prev != null) {
			prev.next = head.next;
		} else {
			bucketArray.set(index, head.next);
		}
		return head.value;
	}

	// Implement get() method
	// Find head of chain for given key
	// Search key in chain. If key found return the value. If not found return null.
	public V get(K key) {
		int index = getBucketIndex(key);
		V value = null;
		// check if the head is there
		if (bucketArray.get(index) != null) {

			HashNode<K, V> current = bucketArray.get(index);

			while (current.next != null) {
				if (key == current.key) {
					value = current.value;
				}

				// hop to next node if not found
				current = current.next;
			}
		}
		return value;

	}

	// Implement add() method
	// Find head of chain for given key
	// Check if key is already present. If true replace the old value with the new
	// value.
	// If false add the new node to the chain and increase the size.
	public void add(K key, V value) {
		//Find head of chain
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(bucketIndex);

		// Check if key is already present
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		// insert key
		size++;
		head = bucketArray.get(bucketIndex);
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		newNode.next = head;
		bucketArray.set(bucketIndex, newNode);
	}
}