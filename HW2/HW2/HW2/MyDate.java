import java.util.*;

public class MyDate implements DateInterface{
    
    // decrale private variables
    
    private String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private String[] monthsOfYear = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private boolean leapYear = false;
    
    // accessor methods
    
    // set method

      
    public void tomorrow() {
        
        // if dayOfWeek reaches 6, make it  else simply add 1
        
        
        // check for leap year
        // if true, make the leapYear variable true and make the 
        // appropriate entry of daysOfMonth to be 29
        
        
        // If the month is January (month = 0) and day is 31, you need 
        // to make day to be 1 and month to be 1 (added 1 with current month value)
        // first check if day has reached its maximum by comparing it with daysOfMonth[month]
        // then if true, make day to be 1 and check for month
        // if month has reached its max value (11), make month 0 and increase year by 1 else simply increase month
        // if day is not equal to daysOfMonth[month], simply increase day
        
        
        // if the leapYear var was made true, now make it false and make daysOfMonth[1] to be 28 again
        
    }
    
    public String toString() {
        
    }

    // bonus
    public void today() {
        
        
    }
    
    // bonus
    public void yesterday() {
        
        // these codes would be just the opposite of the tomorrow function
        // with one extra thing to consider. Prior to 1583 leap year was calculated as just year%4 == 0

    }

}