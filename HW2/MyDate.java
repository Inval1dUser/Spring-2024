import java.util.*;

public class MyDate implements DateInterface {

    // decrale private variables
    public int day, month, year, dayOf, dayofweekCounter;
    private int weeks, years;
    private String dayOfWeek;
    private String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private String[] monthsOfYear = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private boolean leapYear = false;
    public String fullDate;

    // accessor methods
    public int getDay() {
        return this.day;
    }

    public int getDow() {
        return this.dayOf;
    }

    public int getMonth() {
        return this.month;
    }
 
    public int getYear() {
        return this.year;
    }
    //set method
    
    public void set(int m, int d, int y, int dow) {
        this.day = d;
        this.month = m;
        this.year = y;
        this.dayOf = dow;
    }
    
    
/**
 * Decreases the date by one day.
 */
    public void tomorrow() {
        dayOf = (dayOf + 1) % 7;
        //checks for leap year
        if (year % 4 == 0) {
            daysOfMonth[1] = 29;
        } else {
            daysOfMonth[1] = 28;
        }

        if (day == 31 && month == 0) {
            day = 1;
            month = 1;
        } else if (day == daysOfMonth[month]) {
            day = 1;
            if (month == 11) {
                month = 0;
                year++;
            } else {
                month++;
            }
        } else {
            day++;
        }
    }   
    //returns the date in "dayOfWeek month, year" form
    public String toString() { 
        return daysOfWeek[dayOf] + " " + monthsOfYear[month] + " " + day + ", " + year;
}


//bonus
public void today() {
    
}

public void yesterday() {
    // If it's the first day of the month
    if (day == 1) {
        // If it's January, then set the date to December 31 of the previous year
        if (month == 1) {
            day = 31;
            month = 12;
            year--;
        } else {
            // Decrement the month
            month--;
            // Update the day based on the new month
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                day = 30;
            } else if (month == 2) {
                // Update the day for February based on leap year
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    day = 29;
                } else {
                    day = 28;
                }
            } else {
                day = 31;
            }
        }
    } else {
        // Just decrement the day
        day--;
    }
}

}
    