/*
 * name: Beck Chandler
 * email: bchandler@butler.edu
 * date: 2/18/2024
 * honor pledge: I promise that all work is my own and I did not recieve any un-authorised help on this assignment
 */

import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;


public class HW3AlgoAnalysis {

	public static int inefficient_find_max(int[][] a) { //reads the max number of ones per row in a 2d array
		int maxCount = 0; //final max count to return
		for (int i = 0; i < a.length; i++) { // Loop through rows
			int compare = 0; // Reset compare for each row
			for (int j = 0; j < a[i].length; j++) { // Loop through columns
				if (a[i][j] == 1) {
					compare++;
				} 
			}
			if (compare > maxCount) { // Compare count within each row
				maxCount = compare; // Update maxCount if needed
			}
		}
		return maxCount;
	}

	public static int efficient_find_max(int[][] a) {
        int Count = 0; 
		for (int i = 0; i < a.length; i++) { 
			int compare1 = 0; 
			for (int j = 0; j < a[i].length; j++) { 
				if (a[i][j] == 1) {
					compare1++;
				} else if (a[i][j] == 0) { //if 0 occurs, move on to the next row
					continue;
				}
			}
			if (compare1 > Count) { 
				Count = compare1; 
			}
		}
		return Count;
    }

	//my attempt at reusability 
	public static int readSize(String FilePath) throws IOException { //reads array size
		BufferedReader reader = new BufferedReader(new FileReader(FilePath));
		int lines = 0;
		while (reader.readLine() != null) {
			lines++;
		}
		reader.close();
		return lines;
	}


	public static int[][] readFileMatrix(String filePath) throws IOException { //reads matrix from file
		int numLines = readSize(filePath);
		int[][] matrix = new int[numLines][numLines]; //initializing a 10x10 matrix 

		File file = new File(filePath);
		Scanner scanner = new Scanner(file);
		
		for(int i = 0; i < numLines; i++) { //rows
			for(int j = 0; j < numLines; j++) { //columns
				if(scanner.hasNextInt()) {
					matrix[i][j] = scanner.nextInt();
				} else { 
					//handle case where there arent enough integers in the file
					matrix[i][j] = 0; //set default value to 0;
				}
			}
		}

		scanner.close();
		return matrix;
	}

	public static void main(String [] args) throws IOException
	{	
	    // read the two dimensional matrix from file

		int[][] HWarray = readFileMatrix("HW3.txt");

		// phase 1: Time for the inefficient function
	    double inefficient_startTime = System.currentTimeMillis(); // get the starting time
	    
	    // call the inefficient_find_max function 100000000 times
		int inefficient_max;
		int times_ran1 = 0;

		while(times_ran1 <= 100000000) {
			inefficient_find_max(HWarray);
			times_ran1 += 1;
		}
		inefficient_max = inefficient_find_max(HWarray);
	    // print the max number of 1's returned by inefficient_find_max function
		System.out.println("The maximum number of 1's is: " + inefficient_max);

	    // get the ending time and subtract from start to find and print the elapsed time
		double inefficient_endTime = System.currentTimeMillis(); //get the ending time
		double inefficientRuntime = inefficient_endTime - inefficient_startTime; //Runtime of inefficient_find_max()
		System.out.println("Total elapsed time: " + inefficientRuntime);


	    // phase 2: Time for the efficient function
		double efficient_startTime = System.currentTimeMillis();

		int efficient_max;
		int times_ran2 = 0;

		while(times_ran2 < 100000000) {
			efficient_find_max(HWarray);
			times_ran2 += 1;
		}
		efficient_max = efficient_find_max(HWarray);

		System.out.println("The maximum number of 1's is: " + efficient_max);

		double efficient_endTime = System.currentTimeMillis();
		double efficientRuntime = efficient_endTime - efficient_startTime;
		System.out.println("Total elapsed time: " + efficientRuntime);
	    // follow the same procedure as phase 1 to calculate the elapsed time
	
	}
}