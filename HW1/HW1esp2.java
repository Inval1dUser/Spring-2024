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


public class HW1esp2 {

	public int max;
	public int min;
	public double avg;
	private int total;
	private int returnAverage;


	public static int findMax(int[] arr)
	{
		int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
	}

	public static int findMin(int[] arr)
	{
		int min = 0;
        for (int i = 1; i < arr.length; i++) {
                min = Math.min(min, arr[i]);
        }
        return min;
	}

	public static double findAvg(int[] arr)
	{
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return (double) sum / arr.length;
	}

	public static int [] scoreGrade(int [] arr)
	{
		int[] count = {0, 0, 0, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 90 && arr[i] <= 100) {
                count[0]++;
            } else if (arr[i] >= 80 && arr[i] <= 89) {
                count[1]++;
            } else if (arr[i] >= 70  && arr[i] <= 79) {
                count[2]++;
            } else if (arr[i] >= 60 && arr[i] <= 69) {
                count[3]++;
            } else if (arr[i] <= 59 && arr[i] >= 0){
                count[4]++;
            }
        }
        return count;
	}
	

	public static void main(String [] args) throws IOException
	{

		int i, max, min, num, file_int;
		double avg;

		// Instantiate a FileReader and PrintWriter
		FileReader fileReader = new FileReader("esp.txt");
		PrintWriter printWriter = new PrintWriter("result.txt");

		// Now read the number of elements and then store all the elements in an array	
		Scanner scanner = new Scanner(fileReader);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (i = 0; i < n; i++) {
			if(scanner.hasNext()) {
            arr[i] = scanner.nextInt();
			} else {
				break;
			}
        }
	

		// call the appropriate functions and write in the file result.txt
		max = findMax(arr);
        min = findMin(arr);
        avg = findAvg(arr);
        int[] gradeCount = scoreGrade(arr);

		printWriter.println("Maximum: " + max);
        printWriter.println("Minimum: " + min);
        printWriter.println("Average: " + avg);
        printWriter.println("Grade Distribution:");
        printWriter.println("A: " + gradeCount[0]);
        printWriter.println("B: " + gradeCount[1]);
        printWriter.println("C: " + gradeCount[2]);
        printWriter.println("D: " + gradeCount[3]);
        printWriter.println("F: " + gradeCount[4]);

		// don't forget to close FileReader and PrintWriter
		fileReader.close();
		printWriter.close();
	}
}