
public class StackArray implements Stack{
    int top;
    Object [] item;
    
    public StackArray(int maxsize) {
        top = -1;
        item = new Object[maxsize];
    }
    
    public void push(Object x) {
        if (isFull()) {
            return;
        }
 
        top++;
        item [top] = x;
        //item[++top] = x;
    }
    
    public Object pop() {
        if (isEmpty()) {
            return null;
        }

        return item[top--];
    }
    
    public Object getTop() {
        // ternary operation
        return isEmpty()? null: item[top];
    }
    
    public int size() {
        return top + 1;
    }
    public boolean isEmpty() {
        if (top <= -1) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isFull() {
        if (top == item.length) {
            return true;
        }
        else {
            return false;
        }
    }
    public void makeEmpty() {
        top = -1;
    }

    
}
