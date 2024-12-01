public interface DateInterface {
	
	  /** @return the day of the month (1-31) */
	  public int getDay();
	  /** @return the day of the week (0-6) */
	  public int getDow();
	  /** @return the month of the year (0-11) */
	  public int getMonth();
	  /** @return the year (four digits) */
	  public int getYear();
	  /** sets the date
	      @param m the month of the year (0-11)
	      @param d the day of the month (1-31)
	      @param y the year (four digits)
	      @param dow the day of the week (0-6) */
	  public void set(int m, int d, int y, int dow);
	  /** moves the date forward by exactly one day */
	  public void tomorrow();
	  /** @return the date as a String in the format "Monday March 18, 2002" */
	  public String toString();

	  /** sets the date to today;
	      make this empty {} unless you do the extra credit. */
	  public void today();
	  /** Moves the date backword by exactly one day;
	      make this empty {} unless you do the extra credit. */
	  public void yesterday();

}
