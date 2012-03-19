package timepieces;

/**
 * This class implements an analog wrist watch which maintains
 * the current time and (half-)day of the week.
 * 
 * @author Colin Fidge
 * @version 2.0
 *
 */
public class WristWatch extends AnalogClock implements WeekdayCalendar {

	/* Factory setting for day */
	private Weekday today = Weekday.SUN;
	private Halfday amPm = Halfday.AM;

	public WristWatch() {
		super("Wrist watch"); // Use a default name for watch objects
	}
	 
	/* The following three methods implement stubs from WeekdayCalendar
	 * (so Javadoc will reuse their documentation from the superclass)
	 */
	
	public void setCalendar(Weekday newDay, Halfday newHalfday) {
		today = newDay;
		amPm = newHalfday;
	}
	
	public String getDay() {
		return today.toString() + ", " + amPm.toString();
	}
	
	public void advanceCalendar() {
		/* Advances the day via its ordinal representation.
		 * This is NOT a nice solution because it breaks the
		 * data abstraction barrier.
		 */
		if (amPm == Halfday.AM)
			amPm = Halfday.PM; // It's now after lunch!
		else {
			amPm = Halfday.AM; // It's now after midnight!
			today = Weekday.values()[((today.ordinal() + 1) % 7)];			
		}

	}

	/* The following method is a new one introduced by this subclass
	 * (which means we need to document its purpose)
	 */
	
	/**
	 * Returns the time and (half-)day currently shown on the wrist
	 * watch.
	 * 
	 * @return the time and day on the watch in a printable form
	 */
	public String getTimeAndDay() {
		return getTime() + ", " + getDay();
	}
	
	/* The following method overrides one from AnalogClock (so
	 * we'll redocument it to record its new capability)
	 */
	
	/**
	 * Advances the time, and (half-)day if necessary, on the watch
	 * by one minute.
	 */
	public void tick() {
		super.tick();
		if (getTime().equals("00:00")) {
			advanceCalendar();
		}
	}
}
