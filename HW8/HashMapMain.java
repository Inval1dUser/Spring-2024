import java.io.*;
import java.util.*;

public class HashMapMain {

    // you are calling this function from main which is a static method.
    // you can not call a non static method directly from a static method
    // public int menu() will result in error
    // Prints out the menu of choices for the user and returns their choice. 
    public static int menu() 
    {
        int ch;
        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.println("1.Exit ");
        System.out.println("--------------------------");
        System.out.println("2.Insert an item");
        System.out.println("3.Delete an item");
        System.out.println("4.Search for an item");
        System.out.println("5.Current hash size");
        System.out.println("6.Display all the elements");
        System.out.println("Enter your choice: ");

        ch = in.nextInt();
        return ch;
    }

    public static void main(String[] args) throws IOException
    {   
        int ch, i, key, found, n, val1, val2, itemtocount, itemtodelete, val, result, pos;
        int N,D,S;
        Scanner in = new Scanner(new FileReader("input.txt"));
        N = in.nextInt();
        D = in.nextInt();
        S = in.nextInt();

        HashMap hash = new HashMap(); 
        
        for(i = 0; i < N; i++)
        {
            key = in.nextInt();
            hash.insert(key);
        }

        System.out.println("HashTable after inserting values");
        hash.display();

        // Delete keys received from files and call the display function
        for (i = 0; i < D; i++) {
            key = in.nextInt();
            hash.remove(key);
        }
        System.out.println("HashTable after deleting values");
        hash.display();

        // Search keys received from files and call the display function
        for (i = 0; i < S; i++) 
        {
            key = in.nextInt();
            found = hash.search(key);
            if (found == -1) {
                System.out.println(key + " not found");
            } 
            else 
            {
                System.out.println(key + " found at index " + found);
            }
        }
        //Scanner in = new Scanner(System.in); will generate error since Scanner 
        //in has already been defined once but you can ask it to refer to another object.

        while(true)
        {
            ch = menu();
            switch(ch)
            {
                case 1:
                    return;
                    //System.exit(0);

                case 2:
                    //insert
                    System.out.println("Enter the value to be inserted: ");
                    key = in.nextInt();
                    hash.insert(key);
                    hash.display();
                    break;
                
                case 3:
                    //delete
                    System.out.println("Enter the value to be deleted: ");
                    key = in.nextInt();
                    hash.remove(key);
                    hash.display();
                    break;

                case 4:
                    //search
                    System.out.println("Enter the value to be searched: ");
                    key = in.nextInt();
                    result = hash.search(key);
                    if(result == -1)
                    {
                        System.out.println("Not Found");
                    }
                    else
                    {
                        System.out.println("Found");
                    }
                    break;

                case 5:
                    System.out.println("Current hash size:" + hash.getSize());
                    break;

                case 6:
                    hash.display();
                    break;

                default:
                    System.out.println("Wrong Choice");
                    break;
            }
        }
    }
      
}

    