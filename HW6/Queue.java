
public interface Queue extends Container{
    public void enqueue(Object x); // mutator
    public Object dequeue(); // mutator
    public Object getFront(); // accessor
}
