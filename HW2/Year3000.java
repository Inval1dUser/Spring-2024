import java.io.*;

/**
  Driver class for The Dating Game programming assignment.
  @author Sean Sullivan
*/
public class Year3000
{
  public static void main(String [] args) throws IOException
  {
    DateInterface d = new MyDate();
    d.set(1,22,2023,0);  // sets the date to Sunday, January 22nd, 2023
    
    while(d.getYear()<3000)
    {
      d.tomorrow();
    }
    // at this point, d represents January 1, 3000
    System.out.println(d);
    
    
    // If you are doing the bonus part of yesterday()
    
    while(d.getYear()>1799) {
    	d.yesterday();
    } 
    /* 
    // at this point, d represents Dec 31, 1799
    d.tomorrow();
    // at this point, d represents January 1, 1800

    System.out.println(d);
    
    while(d.getYear()>999) {
    	d.yesterday();
    }
    
    // at this point, d represents Dec 31, 999
    d.tomorrow();
    // at this point, d represents January 1, 1000

    System.out.println(d);
    */
  }
}