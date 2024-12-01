import java.io.*;
import java.util.*;

public class BST  // Binary Search Tree!!
{

    private class treenode
    {
        public int data;
        public treenode left;
        public treenode right;

        public treenode(int x) {
                data = x;
                left = null;
                right = null;
        }
    }
    private treenode root;
    private Queue Q;

    public BST()
    {       
        root=null; 
        Q = null;
    }

//////////////////////////////////////////////////////////
    // case 1 insert
    public void insert(int x)
    {
        root=inserthelp(root,x); // fake pass-by-reference for root
    }

    private treenode inserthelp(treenode r, int x)
    {
        if(r==null) // empty tree - base case
        {
          r=new treenode(x);
          return r;
        }
        // recursive cases
        // insert in left subtree
        if(x<r.data) // x < r.data
        { 
            r.left=inserthelp(r.left,x); 
        }
        else // insert in right subtree
        { 
            r.right=inserthelp(r.right,x); 
        }
        
        return r; // root doesn't change in recursive case
    }

////////////////////////////////////////////////////////////
    // case 2: delete
    // Returns 1 if node is a leaf node, 0 otherwise.
    private boolean isLeaf(treenode r) 
    {
        return (r != null && r.right == null && r.left == null);
    }

    // Returns 1 if node has a left child and no right child.
    private boolean hasOnlyLeftChild(treenode r) 
    {
        if(r == null) return false;

        if(r.left != null && r.right == null) {
            return false;
        } else {
            return true;
        }
    }

    // Returns 1 if node has a right child and no left child.
    private boolean hasOnlyRightChild(treenode r) 
    {
        if(r == null) return false;

        if(r.right != null && r.left == null) {
            return false; 
        } else {
            return true;
        }
    }
    
    // Will delete the node storing value in the tree rooted at root. The
    // value must be present in the tree in order for this function to work.
    // The function returns a pointer to the root of the resulting tree.
    
    public void delete(int x)
    {
        root = deleteHelp(root,x); // fake pass-by-reference for root
    }

/* */    private treenode deleteHelp(treenode r, int value) 
    {
        treenode delnode, new_del_node, parent_node;
        int save_val;

        // Get a pointer to the node to delete.
        delnode = findNodeHelp(r, value); 
        // Get a pointer to the parent of the value to be deleted.
        parent_node = findParentNodeHelp(r, value); 

        // Take care of the case where the node to delete is a leaf node.
        if (isLeaf(delnode))  
        {
            // case 1: Deleting the only node in the tree.
            if (r.left == null && r.right == null) {
                return null;
            }

            if (r.left != null) {
                r.left = null;
            } else if (r.right != null) {
                r.right = null;
            }
            

            // Return the root of the new tree (here r will be same as root). 
            // But you must return r since delete function returns a treenode.
            return r; 
        }

        // Take care of the case where the node to be deleted only has a left child.
        if (hasOnlyLeftChild(delnode)) {
            if (r.left == null && r.right == null) {
                return null;
            }

            if (r.left != null) {
                r.left = null;
            } else if (r.right != null) {
                r.right = null;
            }

            return r;
        }

        // Takes care of the case where the deleted node only has a right child.
        if (hasOnlyRightChild(delnode)) 
        {
           // case 1: Deleting the root node of the tree.
           if (r.left == null && r.right == null) {
            return null;
            }

            if (r.left != null) {
                r.left = null;
            } else if (r.right != null) {
                r.right = null;
            }

            return r;
        }
        // Find the new physical node to delete and save the value.
        if (delnode.left != null) {
            new_del_node = delnode.left;
        } else {
            new_del_node = delnode.right;
        }
        // Now, delete the proper value.
        save_val = delnode.data;
        // Restore the data to the original node to be deleted.
        delnode.data = save_val;
        
        return r;
    }

//////////////////////////////////////////////////////////
    // case: 4
    // findNodeHelp has access to root then why are you sending that as parameter?
    // it is because the findNodeHelp is recursively called with a treenode parameter from inside
    // so, during it's first call, you need to call it with root (treenode parameter)
    public int findNode(int x) 
    {
        treenode temp = findNodeHelp(root,x);
        if (temp == null)
        {
            return -1;
        }
        else
        {
            return temp.data;
        }     
    }

    private treenode findNodeHelp(treenode r, int x)
    {
        // base cases
        if(r==null) return null;
        if(x==r.data) // it matches - we found it!
        { 
            return r; 
        }
        // recursive cases
        if(x<r.data) // look to the left
        { 
            return findNodeHelp(r.left,x); 
        }
        else // look to the right
        { 
            return findNodeHelp(r.right,x); 
        }
    }

//////////////////////////////////////////////////////////////////
    // case 5
    public void inOrder()
    {
        inOrderHelp(root);
    }
    private void inOrderHelp(treenode r)
    {
        if(r==null) return;
        inOrderHelp(r.left);
        System.out.print(r.data + "  ");
        inOrderHelp(r.right);
    }

    // case 6
    public void preOrder()
    {
        preOrderHelp(root);
    }

    private void preOrderHelp(treenode r)
    {
        if(r==null) return;
        System.out.print(r.data + "  ");
        preOrderHelp(r.left);
        preOrderHelp(r.right);
    }

    // case 7
    public void postOrder()
    {
        postOrderHelp(root);
    }
    private void postOrderHelp(treenode r)
    {
        if(r==null) return;
        postOrderHelp(r.left);
        postOrderHelp(r.right);
        System.out.print(r.data + "  ");
    }

    // case 7
    public void levelOrder()
    {
        levelOrderHelp(root);
    }

    // Prints a breadth first search traversal of the binary search tree rooted at root.
    // In particular, values are printed row by row, from left to right (based on the common
    // visualization of a binary tree.)
    private void levelOrderHelp(treenode r) 
    {
        Q=new QueueLL();

        Q.enqueue(r);

        // Run Breadth First Search.
        while (!Q.isEmpty()) {

            // Dequeue and print the next time.
            treenode temp = (treenode)(Q.dequeue());
            System.out.printf("%d ", temp.data);

            // Enqueue neighbors, first going left, then right.
            if (temp.left != null) Q.enqueue(temp.left);
            if (temp.right != null) Q.enqueue(temp.right);
        }
        System.out.println();
    }
//////////////////////////////////////////////////////////
    // Case 9:
    public int minVal()
    {
        treenode temp = minValHelp(root);
        return temp.data;
    }

    // Returns a pointer to the node storing the minimum value in the tree
    // with the root, r. Will not work if called with an empty tree
    private treenode minValHelp(treenode r)
    {
        // Root stores the minimum value.
        if (r.left == null)
            return r;
        // The left subtree of the root stores the minimum value.
        else
            return minValHelp(r.left);
    }

//////////////////////////////////////////////////////////
    // Case 10:
    public int maxVal()
    {
        treenode temp = maxValHelp(root);
        return temp.data;
    }

    // Returns a pointer to the node storing the minimum value in the tree
    // with the root, r. Will not work if called with an empty tree
    private treenode maxValHelp(treenode r)
    {
        // Root stores the maximum value.
        if (r.right == null)
            return r;
        // The left subtree of the root stores the maximum value.
        else
            return maxValHelp(r.right);
    }

////////////////////////////////////////////////////////////////////
    // case 11: find parent node
    public int findParentNode(int del)
    {
        treenode result = findParentNodeHelp(root, del);
        if(result == null)
        {
            return -1;
        }
        else
        {
            return result.data;
        }

    }
    private treenode findParentNodeHelp(treenode r, int del)
    {
        // 1. Take care of NULL cases.
        // 2. The case of only one node in which case there wouldn't be any parent 
        if (r == null || r.data == del) return null;
        // The root is the direct parent of del.
        //if (r.left.data == del || r.right.data == del) will generate nullpointer exception for scenarios
        // where r.left is null and you are trying to compare that with and int value (del)
        if ((r.left != null && r.left.data == del) || (r.right != null && r.right.data == del))
            return r;
        // Look for del's parent in the left side of the tree.
        if (del < r.data)
            return findParentNodeHelp(r.left, del);
        // Look for del's parent in the right side of the tree.
        else //if (del > r.data)
            return findParentNodeHelp(r.right, del);
    }
    

//////////////////////////////////////////////////////////

    // Case 12: Returns the number of nodes in the tree rooted at root with exactly 1 child.
    
    public int numNodesOneChild()
    {
        return numNodesOneChildHelp(root);
    }

    private int numNodesOneChildHelp(treenode root) {

        // No nodes in the tree at all...
        if (root == null) return 0;
        
        int total = 0;
        
        // Add this node if it only has a left child.
        if ((root.left != null && root.right == null)||(root.left == null && root.right != null)) 
        {
            total++;
        }

        // Then add up all the nodes on the left and the right.
        total = total+ numNodesOneChildHelp(root.left) + numNodesOneChildHelp(root.right);
        // Here is our answer.
        return total;
    }

//////////////////////////////////////////////////////////
    // Case 13: finding sum of heights/depths of all the nodes
    public int sumDepthRec()
    {
        return sumDepthRecHelp(root, 0);
    }

    private int sumDepthRecHelp(treenode root, int curDepth) 
    { 
        if (root == null) return 0; 
        return curDepth + sumDepthRecHelp(root.left, curDepth+1) + sumDepthRecHelp(root.right, curDepth+1); 
    }

//////////////////////////////////////////////////////////
  
    // case 14
    public int sumNodes()
    {
        return sumNodesHelp(root);
    }

    //returns sum of data of all nodes
    private int sumNodesHelp(treenode r)
    {
        // Root points to null, return 0.
        if (r == null)
            return 0;
        else
            return r.data + sumNodesHelp(r.left)+ sumNodesHelp(r.right);
    }

//////////////////////////////////////////////////////////
    // case 15
    // Guaranteed that k is in between 1 and the number of nodes in the tree 
    // pointed to by root.
    public int findKthSmallest(int val)
    {
        return findKthSmallestHelp(root, val);
    }

    //returns sum of data of all nodes
    private int findKthSmallestHelp(treenode r, int k)
    {
        int numNodesLeft =  numNodesHelp(r.left);
        if (numNodesLeft >= k) 
            return findKthSmallestHelp(r.left, k);
        else if (numNodesLeft == k-1)
            return r.data;
        else
            return findKthSmallestHelp(r.right, k-numNodesLeft-1);
    }

//////////////////////////////////////////////////////////
    //case 16
    public int numNodes()
    {
        return numNodesHelp(root);
    }

    //returns sum of data of all nodes
    private int numNodesHelp(treenode r)
    {
        // Root points to null, return 0.
        if (r == null)
            return 0;
        else
            return 1 + numNodesHelp(r.left)+ numNodesHelp(r.right);
    }

////////////////////////////////////////////////////////////////////////
    // Extra

    // Case 17: 
    public void findBetween(int min, int max)
    {
        findBetweenHelp(root, min, max);
    }
    //print the nodes which are between two given values min and max
    private void findBetweenHelp(treenode root,int min, int max)
    {
        if(root == null)return;
        findBetweenHelp(root.left, min, max);
        if(root.data>=min && root.data<=max) 
            System.out.print(root.data + "  ");
        findBetweenHelp(root.right, min, max);
    }

    //Case 18: sum of nodes with odd numbers except the leaf nodes
    public int sumOdd()
    {
        return sumOddHelp(root);
    }

    private int sumOddHelp(treenode root)
    {
        int result=0;
        // if tree is empty or leaf node
        if((root == null)||((root.left == null) && (root.right == null)))
            return 0;
        if(root.data % 2 == 1)
            result=root.data;
        return result+sumOddHelp(root.left)+sumOddHelp(root.right);
    }

    // Case 19: Returns the height of the tree with root root.
    public int height()
    {
        return heightHelp(root);
    }

    private int heightHelp(treenode root) {
        // Height of an empty tree.
        if (root == null) return -1;

        // Find out heights of both sides.
        int leftSide = heightHelp(root.left);
        int rightSide = heightHelp(root.right);

        // Choose the bigger one and add one.
        if (leftSide > rightSide)
            return leftSide+1;
        else
            return rightSide+1;

    }

//////////////////////////////////////////////////////////////////////////

    // case 20: non recursive find node
    public int findNodeNonRecursive(int x) 
    {
        treenode temp = findNodeNonRecursiveHelp(root,x);
        if (temp == null)
        {
            return -1;
        }
        else
        {
            return temp.data;
        }     
    }

    private treenode findNodeNonRecursiveHelp(treenode r, int x)
    {
        treenode temp;
        if (r == null)
            return r;
        Q=new QueueLL();

        Q.enqueue(r);

        // Run Breadth First Search.
        while (!Q.isEmpty()) {

            // Dequeue and print the next time.
            temp = (treenode)(Q.dequeue());
            if(temp.data == x)
                return temp;

            // Enqueue neighbors, first going left, then right.
            if (temp.left != null) Q.enqueue(temp.left);
            if (temp.right != null) Q.enqueue(temp.right);
        }
        return null; // Queue is empty and the value wasn't found
    }

///////////////////////////////////////////////////////////
    //Extra: Creating mirror image of the tree
    public void mystery()
    {
        mysteryHelp(root);
        inOrderHelp(root);
    }
    private void mysteryHelp(treenode root) 
    { 
        treenode temp;
        if(root == null)
            return;
        temp = root.left;
        root.left = root.right; 
        root.right = temp;
        mysteryHelp(root.left);
        mysteryHelp(root.right);
        return;
    }
}


