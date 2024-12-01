import java.io.*;
import java.util.*;

public class SingleLinkListMain {

    // you are calling this function from main which is a static method.
    // you can not call a non static method directly from a static method
    // public int menu() will result in error
    public static int menu() 
    {
        int ch;
        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.println("1.Exit ");
        System.out.println("--------------------------");
        System.out.println("2.Insert a node at beginning ");
        System.out.println("3.Insert a node at end");
        System.out.println("4.Insert a node at middle");
        System.out.println("--------------------------");
        System.out.println("5.Delete a node from beginning");
        System.out.println("6.Delete a node from Last");
        System.out.println("7.Delete a node from Middle");
        System.out.println("--------------------------");
        System.out.println("8.Traverse the list (Left to Right)");
        System.out.println("9.Traverse the list (Right to Left)");
        System.out.println("--------------------------");
        System.out.println("10. Search nodes ");
        System.out.println("11. Count occurence ");
        System.out.println("12. Search and Delete ");
        System.out.println("13. Delete Greater"); //MT2: don't call any other function
        System.out.println("Enter your choice: ");

        ch = in.nextInt();
        return ch;
    }

    
    public static void main(String[] args)
    {   
        int ch, n, itemtocount, itemtodelete, val, result, pos;
        Scanner in = new Scanner(System.in);
        SingleLinkList SLL = new SingleLinkList(); 

        while(true)
        {
            ch = menu();
            switch(ch)
            {
                case 1:
                    return;
                    //System.exit(0);

                case 2:
                    System.out.println("Enter the value to be inserted: ");
                    val = in.nextInt();
                    SLL.insert_at_beg(val);
                    SLL.traverse();
                    break;
                
                case 3:
                    System.out.println("Enter the value to be inserted: ");
                    val = in.nextInt();
                    SLL.insert_at_end(val);
                    SLL.traverse();
                    break;

                case 4:
                    System.out.println("Enter the position to insert: ");
                    pos = in.nextInt();
                    System.out.println("Enter the value to be inserted: ");
                    val = in.nextInt();
                    
                    SLL.insert_at_mid(pos, val);
                    SLL.traverse();
                    break;

                case 5:
                    SLL.delete_at_beg();
                    SLL.traverse();
                    break;

                case 6:
                    SLL.delete_at_end();
                    SLL.traverse();
                    break;

                case 7:
                    System.out.println("Enter the position to delete: ");
                    pos = in.nextInt();
                    SLL.delete_at_mid(pos);
                    SLL.traverse();
                    break;
                
                case 8:
                    SLL.traverse();
                    break;

                case 9:                   
                    System.out.println("The contents of List (Right to Left):");
                    SLL.rev_traverse();
                    System.out.println(" X ");                   
                    break;

                case 10:
                    System.out.println("Enter the value to search: ");
                    val = in.nextInt();
                    result = SLL.search(val);
                    if(result == -1)
                    {
                        System.out.println("Node is not present");
                    }
                    else
                    {
                        System.out.println("Node is present at index : " + result);
                    }
                    break;
                
                case 11:
                    System.out.println("What value are you looking for?");
                    val = in.nextInt();
                    System.out.println("Times of occurence " + SLL.count_occurence(val));
                    break;
                
                case 12:                    
                    System.out.println("Enter the value to delete");
                    val = in.nextInt();
                    SLL.search_delete(val);  
                    SLL.traverse();               
                    break;
                
                case 13:                    
                    System.out.println("Enter the value: ");
                    val = in.nextInt();
                    SLL.delete_greater(val);  
                    SLL.traverse();               
                    break;

                default:
                    System.out.println("Wrong Choice");
                    break;
            }
        }
        //return;
    }
    
    
}
