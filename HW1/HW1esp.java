/*
 Name: Beck Chandler
 Description: Exam Statistics Program, calculates the Maximum value, Minimum value, Average, 
 and amount of letter grades from a text file
 Email: bchandler@butler.edu
 Date: 1/28/2024
 
 I affirm that I have not given or received any unauthorized help on this assignment, and that all work is my own.
*/


import java.io.*;
import java.io.File;
import java.util.Scanner;

/* 
Problem Statement
-----------------
 Create a esp.java file to compute statistics on a list of exam scores, the Exam Statistics Program (ESP). 
 A text file (esp.txt) contains the number of scores followed by the list of scores (see the example below).
 You should then display the following information:

· The minimum, maximum, and average scores

· The number of As, Bs, Cs, Ds, and Fs, using a 90-80-70-60 scale.

 You must use functions for the tasks, and you must use an array to store the list of exam scores. The result must be displayed in an output file named result.txt.
 */

public class HW1esp {

	public int max;
	public int min;
	public double avg;
	private int total;


	public static int findMax(int[] arr)
	{
		File file = new File("esp.txt");
		Scanner scanner = new Scanner("esp.txt");

		max = arr[0];
		while (scanner.hasNextInt()) {
			int num = scanner.nextInt();
			if(num > max) {
				maxint = num;
				}
			}
			scanner.close();
		}
/* 
	public static int findMin(int[] arr)
	{
		File file = new File("esp.txt");
		min = arr[0];
		for(int i = 1; i < arr.size(); i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		return min;	
	}

	public static double findAvg(int[] arr)
	{
		File file = new File("esp.txt");
		total = 0;
		for(int i = 0; i <= arr.size(); i++) {
			total = total + arr[i];
		}
		avg = total/arr.size();
		return avg;
	}

	public static int [] scoreGrade(int [] arr)
	{
		/*
		 * A = 90 and above
		 * B = 80 - 89
		 * C = 70 - 79
		 * D = 60 - 69
		 * F = 59 and below
		 
		int []count = new int[5]; 
		// in java int values are defaulted to 0 automatically
		// this array will be used for counting number of A's, B's etc.
			for(int i = 0; i <= arr.size(); i++) {

			}
		
		
		

		return count;
			
	}
	*/

	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(new FileReader("esp.txt"));
		int i, max, min, num, file_int;
		double avg;

		

		// Instantiate a FileReader and PrintWriter

		// Now read the number of elements and then store all the elements in an array
		

		// call the appropriate functions and write in the file result.txt


		// don't forget to close FileReader and PrintWriter
	}
}