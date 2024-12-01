import java.io.*;
import java.util.*;

public class BSTMain {

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
        System.out.println("2.Insert an item into your tree");
        System.out.println("3.Delete an item from your tree");
        System.out.println("4.Search for an item in your tree");
        System.out.println("--------------------------");
        System.out.println("5.Inorder traversal");
        System.out.println("6.Preorder traversal");
        System.out.println("7.Postorder traversal");
        System.out.println("8.Level order traversal");
        System.out.println("--------------------------");
        System.out.println("9.Find minimum value");
        System.out.println("10.Find maximum value");
        System.out.println("11.Find the parent node");
        System.out.println("12.Number of nodes with one child");
        System.out.println("13.Sum of height of nodes");
        System.out.println("14.Sum of the nodes in your tree");
        System.out.println("15.kth smallest value in your tree");
        System.out.println("16.Number of nodes recursive (not using count)");
        System.out.println("17.Print nodes between two given numbers");
        System.out.println("18.Sum of odd non-leaf values");
        System.out.println("19.Height of the tree");
        System.out.println("20.Non recursive search for an item");
        System.out.println("Enter your choice: ");

        ch = in.nextInt();
        return ch;
    }

    
    public static void main(String[] args) throws IOException
    {   
        int ch, n, val1, val2, itemtocount, itemtodelete, val, result, pos;
        Scanner in = new Scanner(new FileReader("bsttest.txt"));
        n = in.nextInt();
        BST t = new BST(); 
        
        for(int i = 0; i < n; i++)
        {
            t.insert(in.nextInt());
        }
        
        t.levelOrder();
        n = in.nextInt();
        
        for(int i = 0; i < n; i++)
        {
            t.delete(in.nextInt());
            t.levelOrder();
        }

        in.close();
        in = new Scanner(System.in); 
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
                    val = in.nextInt();
                    t.insert(val);
                    t.inOrder();
                    break;
                
                case 3:
                    //delete
                    System.out.println("Enter the value to be deleted: ");
                    val = in.nextInt();
                    t.delete(val);
                    t.levelOrder();
                    break;

                case 4:
                    //search
                    System.out.println("Enter the value to be searched: ");
                    val = in.nextInt();
                    result = t.findNode(val);
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
                    //inorder
                    t.inOrder();
                    break;

                case 6:
                    //preorder
                    t.preOrder();
                    break;

                case 7:
                    //postorder
                    t.postOrder();
                    break;
                
                case 8:
                    //level order
                    t.levelOrder();
                    break;

                case 9:                   
                    // find the minimum value
                    result = t.minVal();   
                    System.out.println("Minimum value: " + result);              
                    break;

                case 10:
                    // find the maximum value
                    result = t.maxVal();   
                    System.out.println("Maximum value: " + result);              
                    break;
                
                case 11:
                    // find the parent node of a given node
                    System.out.println("Enter the value: ");
                    val = in.nextInt();
                    result = t.findParentNode(val);
                    if(result == -1)
                    {
                        System.out.println("No parent found");
                    }
                    else
                    {
                        System.out.println("Parent of" + val + " is " + result);
                    }          
                    break;
                
                case 12:                    
                    //#node with 1 child
                    result = t.numNodesOneChild();   
                    System.out.println("Number of nodes with 1 child: " + result);              
                    break;
                
                case 13:                   
                    //sum of height of nodes
                    result = t.sumDepthRec();   
                    System.out.println("Sum of height of nodes: " + result);              
                    break;

                case 14:
                    //sum of nodes
                    result = t.sumNodes();   
                    System.out.println("Sum of nodes: " + result);              
                    break;
                
                case 15:
                    // kth smallest
                    System.out.println("Enter the value: ");
                    val = in.nextInt();
                    result = t.findKthSmallest(val);   
                    System.out.println("Kth smallest value: " + result); 
                    break;
                
                case 16:                    
                    //# of nodes recursive
                    result = t.numNodes();   
                    System.out.println("Num of nodes: " + result);              
                    break; 
                
                case 17:
                    //print the nodes whose value fall between two given values
                    System.out.println("Enter the values: ");
                    val1 = in.nextInt();
                    val2 = in.nextInt();
                    t.findBetween(val1, val2);   
                    break;
                
                case 18:
                    // Sum of all odd nodes except leaves
                    result = t.sumOdd();   
                    System.out.println("Sum of all odd nodes except leaves: " + result);              
                    break;

                case 19:
                    // height
                    result = t.height();   
                    System.out.println("Tree height: " + result);              
                    break;

                case 20:
                    // Non recursive search
                    System.out.println("Enter the value to be searched: ");
                    val = in.nextInt();
                    result = t.findNodeNonRecursive(val);
                    if(result == -1)
                    {
                        System.out.println("Not Found");
                    }
                    else
                    {
                        System.out.println("Found");
                    }
                    break;

                default:
                    System.out.println("Wrong Choice");
                    break;
            }
        }
       //return;
    }
    
}

    