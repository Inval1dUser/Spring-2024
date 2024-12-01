import java.io.*;
import java.util.*;

public class Restaurantstarter {

	public static void main(String[] args) throws IOException {
		
		System.out.println("*** Welcome to the La Food Restaurant Simulator ***\n");

    	Scanner option = new Scanner(new File("in.txt"));
		QueueLL queue = new QueueLL();
		
		while (!option.equals("Q")) {
			String event = option.next();
			
			if(option.equals("A")) {
				int time = option.nextInt();
				int size = option.nextInt();
				int bribe = option.nextInt();
				String name = option.next();
				
				Party newParty = new Party(time, size, bribe, name);
				
				QueueLL tempQ = new QueueLL();
				
				while(!queue.isEmpty() && (int) queue.getFront() >= bribe) {
					tempQ.enqueue(queue.dequeue());
				}
				
				tempQ.enqueue(newParty);
				
				while(!queue.isEmpty()) {
					tempQ.enqueue(queue.dequeue());
				}
				
				queue = tempQ;
				
				System.out.println("Please wait at the bar,\nparty " + name + " of " + size + " people. (time=" + time + ")");

			}
			else if(event.equals("T")) {
				int time = option.nextInt();
				
			 Party nextParty = (Party)queue.dequeue();
			if(nextParty != null) {
			 System.out.println("Table for " + nextParty.getName() + "! (time=" + time + ")");
			 } else {
				System.out.println("No party to seat at the table");
			 }
			 
			}
			else if(event.equals("Q")) {
				break;
			}
		}
		
		System.out.println("\n** Simulation Terminated **\n");
		
		// calculate average wait time per party
		int averageWaitTimePerParty = 0;
		if (totalNumberOfParties != 0) {
		  averageWaitTimePerParty = totalWaitTimeForParty / totalNumberOfParties;
		}
		// calculate average wait time per person
		int averageWaitTimePerPerson = 0;
		if (totalNumberOfPerson != 0) {
		  averageWaitTimePerPerson = totalWaitTimeForPerson / totalNumberOfPerson;
		}
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
// Below is the first attempt at this assignment from Restaurant.java
/*
import java.io.*;
import java.util.*;

public class Restaurant {

	public static void main(String[] args) throws IOException {
		
		System.out.println("*** Welcome to the La Food Restaurant Simulator ***\n");

		//declare scanner class to read from file in a variable named option
		Scanner option = new Scanner(new File("in.txt"));
		QueueLL queue = new QueueLL();
		
		
		while (!option.equals("Q")) {
			
			// if option is A
			if(option.equals("A")) {
				// read the time, size, bribe and name for the party
				int time = Integer.parseInt(option.next());
				int size = Integer.parseInt(option.next());
				int bribe = Integer.parseInt(option.next());
				String name = option.next();
				
				Party currentParty = new Party(time, size, bribe, name);

				QueueLL tempQ = new QueueLL();
				
				// check if the bribe of the current party is smaller than or equal to
				// that of the front of queue and others (in the queue). As long as that 
				// is true dequeue from the queue and enqueue them in a temporary queue (tempQ)

				while(!queue.isEmpty() && (int) queue.getFront() >= bribe) { //
					tempQ.enqueue(queue.dequeue());
				}
				
				
				// Sorts the queue in a temporary QueueLL and copies it back
				QueueLL sortedQueue = new QueueLL(); //create a new temp queue for data storage

				while(!tempQ.isEmpty()) {
					Party tmp = (Party) tempQ.dequeue();

					while(!sortedQueue.isEmpty() && (int) sortedQueue.getFront() >= tmp.getBribe()) {
						tempQ.enqueue(sortedQueue.dequeue());
					}

					sortedQueue.enqueue(tmp);
				}
				queue = sortedQueue;
				

						// now insert the current party in tempQ which will be now in correct bribing order
				tempQ.enqueue(currentParty); //enqueue current party into tempQ
						
						// now add the rest of the parties in queue who bribed less than this current party in tempQ
						while(!queue.isEmpty() && (int) queue.getFront() < (int) currentParty.getBribe()) {
							tempQ.enqueue(queue.dequeue());
						}
				
				//enqueue tempQ's dequeued element till tempQ is empty
				while(!tempQ.isEmpty()) {
					queue.enqueue(tempQ.dequeue());
				}
				
				
				// The while loop is working on queue. So queue should now point 
				// to tempQ so that it woks on this updated queue in next iteration.
				queue = tempQ; 
				
				// print message
				/* if (event.equals("A")) {
					System.out.println("Please wait at the bar,\nparty " + name + " of " + size + " people. (time=" + time + ")");
				} else if (event.equals("T")) {
					System.out.println("Table for " + nextParty.getName() + "! (time=" + time + ")");
				}
        
			}
			
			// if option is T 
				if(option.equals("T")) {
				// dequeue from queue
				queue.dequeue();
				// read time from file (when the table became available)
				int tableTime = Integer.parseInt(option.next());
				// print message  table for (party name)! (time = table time)
				System.out.println("Table for " + party.getName() + "! (time=" + tableTime + " )");
				// calculate total wait time for party and number of parties
				int totalWaitTimeForParty = 0;
				int totalNumberOfParties = 0;

				QueueLL tempQueue = new QueueLL();

				while (!queue.isEmpty()) {
					Party party = (Party) queue.dequeue();
					totalWaitTimeForParty += (tableTime - party.getTime());
					totalNumberOfParties++;
					tempQueue.enqueue(party);
				}

				while (!tempQueue.isEmpty()) {
					queue.enqueue(tempQueue.dequeue());
				}
				// calculate total wait time for person and number of person
				int totaleWaitTimeForPerson = totalWaitTimeForParty = totalNumberOfParties;
			}
			option = inFile.next();
		}
		System.out.println("** Simulation Terminated **\n\n");
		
		int averageWaitTimePerParty = 0;
		int averageWaitTimePerPerson = 0;
		if (totalNumberOfParties != 0) {
			averageWaitTimePerParty = totalWaitTimeForParty / totalNumberOfParties;
		}
		if (totalNumberOfPerson != 0) {
			averageWaitTimePerPerson = totalWaitTimeForPerson / totalNumberOfPerson;
		}
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
*/
