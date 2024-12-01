// 1st position of LL means position 0

import java.io.*;
import java.util.Scanner;

public class SingleLinkList {
    // this is private since this class will only be used by member 
    // functions of SingleLinkList class. It shouldn't get called 
    // from main. 
    private class node{
        public int data; 
        public node next;
        
        public node(int x) {
            data = x;
            next = null;
        }
    }
    
    node start;
    int count;
    
    public SingleLinkList(){
        start = null;
        count = 0;
    }

    public void insert_at_beg(int val)
    {
        node newnode = new node (val);
        if(start == null)
        {
            start = newnode;
        }
        else
        {
            newnode.next = start;
            start = newnode;
        }

        count++;
        return;
    }

    public void insert_at_end(int val)
    {
        node temp;
        node newnode = new node (val);
        if(start == null)
        {
            start = newnode;
        }
        else
        {
            temp = start;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newnode;
        }

        count++;
        return;
    }

    public void insert_at_mid(int pos, int val)
    {
        int ctr = 1;
        node after, before; // version 1
        node temp; // version 2
        node newnode = new node (val);
        
        if(start == null)
        {
            return ;
        }
        else
        {
            //if(pos > 0 && pos < count - 1)
            if(pos > 0 && pos < count)
            {
                
                //version 1
                before = after = start;
                while(ctr <= pos)
                {
                    before = after;
                    after = after.next;
                    ctr ++;
                }
                // after coming out after-> node to be deleted
                before.next = newnode;
                newnode.next = after;
                

                /*
                //version 2
                temp = start;
                while(ctr < pos)
                {
                    temp = temp.next;
                    ctr ++;
                }
                // after coming out after-> node to be deleted
                newnode.next = temp.next;
                temp.next = newnode;
                */
            }
        }

        count++;
        return;
    }

    public void delete_at_beg()
    {
        if(start == null)
        {
            return;
        }
        else
        {
            start = start.next;
        }

        count--;
        return;
    }

    public void delete_at_end()
    {
        node after, before;

        if(start == null)
        {
            return;
        }
        else if (start.next == null)
        {
            start = null;
        }
        else
        {
            after = start;
            before = null;
            while(after.next != null)
            {
                before = after;
                after = after.next;
            }

            before.next = null;
        }

        /*
        node temp;
        // no node
        if(start == null)
        {
            return;
        }
        // one node
        else if (start.next == null)
        {
            start = null;
        }
        else
        {
            temp = start;
            while(temp.next.next != null)
            {
                temp = temp.next;
            }

            temp.next = null;
        }
        */

        count--;
        return;
    }

    public void delete_at_mid(int pos)
    {
        int ctr = 1;
        node after, before; // version 1
        node temp; // version 2
        
        if(start == null)
        {
            return ;
        }
        else
        {
            if(pos > 0 && pos < count - 1)
            {
                
                //version 1
                before = after = start;
                while(ctr <= pos)
                {
                    before = after;
                    after = after.next;
                    ctr ++;
                }
                // after coming out after-> node to be deleted
                before.next = after.next;
                

                /*
                //version 2
                temp = start;
                while(ctr < pos)
                {
                    temp = temp.next;
                    ctr ++;
                }
                // after coming out after-> node to be deleted
                temp.next = temp.next.next;
                */
            }
        }

        count--;
        return;
    }

    public void traverse()
    {
        node temp;
        System.out.println("Link list from L to R: ");
        temp = start;
        
        if(start == null)
        {
            System.out.println("Empty List");
            return;
        }

        while(temp != null)
        {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }

        System.out.println(" X");

        return;
    }

    //Print the data value of each node in the link list in reverse order using recursion
    public void rev_traverse()
    {
        rev_traverse_help(start);
        return;
    }

    private void rev_traverse_help(node h)
    {
        if(h == null)
        {
            return;
        }
        else
        {
            rev_traverse_help(h.next);
            System.out.print(h.data + "-->");
        }

        return;
    }

    public int count_occurence(int number)
    {
        int occurence = 0;
        node temp = start;
        
        while(temp != null)
        {
            if (temp.data == number)
            {
                occurence++;
            }
            temp = temp.next;
        }

        return occurence;
    }

    public int search(int number)
    {
        int index = 0;
        node temp = start;
        
        while(temp != null)
        {
            if (temp.data == number)
            {
                return index;
            }
            temp = temp.next;
            index++;
        }

        return -1;
    }

    public void search_delete(int number)
    {
        int index = search(number);
        if(index == -1)
        {
            System.out.println("Not Found");
        }
        else if(index == 0)
        {
            delete_at_beg();
        }
        else if (index == count -1)
        {
            delete_at_end();
        }
        else 
        {
            delete_at_mid(index);
        }

        return;
    }

    // MT2: Delete the nodes greater than a user given value
    // nodes to be deleted can only appear in the middle
    public void delete_greater(int number)
    {
        
        node after, before;

        if(start == null)
        {
            return;
        }
        else
        {
            after = start;
            before = null;
            while(after != null) {
                if(after.data > number)
                {
                        before.next = after.next;
                }
                else
                {
                    before = after;
                }
                after = after.next;
            }
        }
        return;
    }
}
