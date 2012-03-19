package timepieces;

/**
 * This class implements a (named) 12-hour clock which maintains times
 * in hours and minutes.
 * 
 * @author Colin Fidge
 * @version 1.0
 *
 */
public class AnalogClock {

	/* Constant representing the number of minutes in two significant
	 * intervals
	 */
	private final int minsPerHour = 60;
	private final int minsPerHalfDay = 12 * minsPerHour;
	
	/* A field to hold the current time (demonstrating the principle of 
	 * encapsulation - note that the way times are represented within the
	 * class, as a single integer, is different to the way the class's
	 * users see them, as a distinct hour and minute.)
	 */
	private int now = 0;
	
	/* A field to hold this clock's name */
	private String name;
	
	/**
	 * When created a clock is given a name and is set to time 0:00
	 * by default.
	 * 
	 * @param givenName the name chosen to identify this clock
	 */
	public AnalogClock(String givenName) {
		name = givenName;
	}
	
	/**
	 * Given two integers representing hours and minutes, sets the
	 * clock to the specified time, provided it is a valid 12-hour time.
	 * 
	 * @param hours number of elapsed hours in the range 0 to 11
	 * @param minutes number of elapsed minutes in the range 0 to 59
	 * @return true if the parameters provided were valid and the 
	 * time was updated accordingly, false otherwise
	 */
	public boolean setTime(int hours, int minutes) {
		if (0 <= hours && hours <= 11 && 
				0 <= minutes && minutes <= 59) {
			now = (hours * minsPerHour) + minutes;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns a string containing the name of this clock.
	 * 
	 * @return the name given to the clock
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns a string containing the clock's current time.
	 * 
	 * @return the name of the clock and its time in a printable form
	 */
	public String getTime() {
		String hours = String.format("%02d", now / minsPerHour);
		String minutes = String.format("%02d", now % minsPerHour);
		return hours + ":" + minutes;
	}
	
	/**
	 * Advances the time on the clock by one minute.
	 */
	public void tick() {
		now = (now + 1) % minsPerHalfDay;
	}
}
