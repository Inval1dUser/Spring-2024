// Enqueue at the end, Dequeue at the front using 2 pointers (front->1st node and back->last node inserted): style 1
// front is always pointing/referencing to the first node
// O(1)

public class QueueLL implements Queue{
       
    // We don't want this class to be accessed from outside and hence it is private 
    // Any private member (function/var/class) of a class is accessible only from within that class.
    // So, this class is accessible to other functions of queueLL class
    // Anything private of a class is only accessible to the members of that class only  
    // So, if data and next are private it would be only accessible from within the queuenode class
    // But other functions like push needs to access these queuenode variables and hence they are public
    // as a result these variables can be accessed by functions in queueLL but not from anywhere else
    private class queuenode {
        public Object data;
        public queuenode next;
        
        public queuenode(Object x) {
            data = x;
            next = null;
        }
    }
    
    queuenode front, back;
    int count;
    
    public QueueLL() {
        front = back = null;
        count = 0;
    }
    
    public void enqueue(Object x) {
        queuenode newnode = new queuenode(x);
        
        // case 1: no node
        if(front == null) {
            front = newnode;
            back = newnode;
        }
        // case 2: when the link has nodes
        else {
            back.next = newnode;
            back = newnode;
        }
        count++;
    }
    
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        
        Object saveditem = front.data;
        if(front.next == null) {
            front = back = null;
        }
        else {
            front = front.next; 
        }
        
        count--;
        return saveditem;
    }
    
    public Object getFront() {
        // ternary operation
        return isEmpty()? null: front.data;
    }
    
    public int size() {
        return count;
    }
    
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        else {
            return false;
        }
        // you could also write the one line: return count == 0;
    }
    
    // We are using LL so it can never be full
    public boolean isFull() {
        return false;
    }
    
    public void makeEmpty() {
        front = back = null;
        count = 0;
    }
}
