import java.io.*;
import java.util.*;

/*
 * HashMap Class Declaration
 */
public class HashMap 
{
	private class HashEntry //hash nodes
	{
		public int key;
		public char status; // 'U'->Used, 'E'-> currently empty, 'D'->deleted
		
		public HashEntry() // constructor
		{

		}	
		
	}

	// declare two static constant variables TABLE_Size 
	// and PRIME with initial values 13 and 11 respectively
	// also declare a count variable and an array of HashEntry named htable

	public HashMap() {

	}

	// function to calculate first hash
	private int hash1(int key) {

	}

	// function to calculate second hash
	private int hash2(int key) {

	}

	// Insert the key in hashtable
	public void insert(int k) {

	}

	// Search the key
	public int search(int k) {

	}

	// Delete the given key from hashtable
	public void remove(int k) {

	}

	//return current_size
	public int getSize()
	{

	}

	// Print all the elements in the hashtable
	public void display() {
		for (int i = 0; i < TABLE_SIZE; i++) {
			if (htable[i].status == 'U')
				System.out.println(i + ": " + htable[i].key);
			else
				System.out.println(i + ": ");
		}
	}
}
