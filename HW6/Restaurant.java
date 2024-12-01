/*
 * Name: Beck Chandler
 * Assignment 6
 * Honor Pledge: I pledge that I have neither given nor received any help on this assignment
 */


import java.io.*;
import java.util.*;

public class Restaurant {

	public static void main(String[] args) throws IOException {
		
		System.out.println("*** Welcome to the La Food Restaurant Simulator ***\n");

		// declare scanner class to read from file in a variable named option
		Scanner inFile = new Scanner(new File("in.txt"));
		QueueLL queue = new QueueLL();
		
		String option = inFile.next();
		
		int totalWaitTimeForParty = 0;
        int totalNumberOfParties = 0;
        int totalWaitTimeForPerson = 0;
        int totalNumberOfPerson = 0;

		while (!option.equals("Q")) {
			
			// if option is A
			if(option.equals("A")) {
				// read the time, size, bribe and name for the party
				int time = Integer.parseInt(inFile.next());
				int size = Integer.parseInt(inFile.next());
				int bribe = Integer.parseInt(inFile.next());
				String name = inFile.next();
				
				Party currentParty = new Party(time, size, bribe, name);
        		QueueLL tempQ = new QueueLL();
				
				// check if the bribe of the current party is smaller than or equal to
				// that of the front of queue and others (in the queue). As long as that 
				// is true dequeue from the queue and enqueue them in a temporary queue (tempQ)
/* 
				while(!queue.isEmpty() && (currentParty.getBribe() <= ((Party) queue.getFront()).getBribe())) {
					tempQ.enqueue(queue.dequeue());
				}
				*/
				while (!queue.isEmpty() && ((Party) queue.getFront()).getBribe() >= bribe) {
					tempQ.enqueue(queue.dequeue());
				}
		
				// Enqueue the current party
				tempQ.enqueue(currentParty);
		
				// Enqueue the rest of the parties in queue
				while (!queue.isEmpty()) {
					tempQ.enqueue(queue.dequeue());
				}
		
				// Now, tempQ has all the parties in the correct order, so assign it back to queue
				queue = tempQ;
				
				// print message
				System.out.println("Please wait at the bar,\nparty " + name + " of " + size + " people. (time=" + time + ")");
			}
			
			// if option is T 
			if (option.equals("T")) {
				// Dequeue from queue
				Party seatedParty = (Party) queue.dequeue();
				// Read time from file (when the table became available)
				int tableTime = Integer.parseInt(inFile.next());
				// Print message table for (party name)! (time = table time)
				System.out.println("Table for " + seatedParty.getName() + "! (time=" + tableTime + " )");
				// Calculate total wait time for party and number of parties
				totalWaitTimeForParty += (tableTime - seatedParty.getTime());
				totalNumberOfParties++;
			
				// Calculate total wait time for person and number of persons
				totalWaitTimeForPerson += (tableTime - seatedParty.getTime()) * seatedParty.getSize();
				totalNumberOfPerson += seatedParty.getSize();
			}
			option = inFile.next();
		}
		System.out.println("** Simulation Terminated **\n\n");
		
		// calculate average wait time per party
		/*
		 I don't know why this won't output as a decimal 
		 both keeps outputing as just 2.0 instead of the output on the docx
		 */
        System.out.println("The average waiting time per party: " + (float) (totalWaitTimeForParty / totalNumberOfParties));

		// calculate average wait time per person
        System.out.println("The average waiting time per party: " + (float) (totalWaitTimeForParty / totalNumberOfParties));

        // if queue is not empty (there are still parties waiting for a table)
        if (!queue.isEmpty()) {
          System.out.println("The following parties were never seated:");
    
          while (!queue.isEmpty()) {
            Party partyLeft = (Party) queue.dequeue();
            System.out.println("party " + partyLeft.getName() + " of " + partyLeft.getSize() + " people.");
          }
        }
    }
}
