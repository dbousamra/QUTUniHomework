package timepieces;

/**
 * This interface defines the essential characteristics of a
 * two-pages per day diary/calendar which keeps track of each
 * half day of the week.
 * 
 * @author Colin Fidge
 * @version 2.0
 */
public interface WeekdayCalendar {


	/**
	 * Days of the week.
	 *
	 * @author Colin Fidge
	 * @version 1.0
	 */
	public enum Weekday {SUN, MON, TUE, WED, THU, FRI, SAT};
	
	/**
	 * Ante or post meridiem.
	 *
	 * @author Colin Fidge
	 * @version 1.0
	 */
	public enum Halfday {AM, PM};
	
	/**
	 * Sets the calendar to a specific (half-)day of the week.
	 * 
	 * @param newDay the day to set the calendar to
	 * @param newHalfday whether it's morning or afternoon
	 */
	public void setCalendar(Weekday newDay, Halfday newHalfday);
	
	/**
	 * Returns the current (half-)day of the week in a printable form.
	 * 
	 * @return a string representation of the current week day
	 */
	public String getDay();
	
	/**
	 * Advances the (half-)day of the week, wrapping around if
	 * necessary.
	 */
	public void advanceCalendar();
}
