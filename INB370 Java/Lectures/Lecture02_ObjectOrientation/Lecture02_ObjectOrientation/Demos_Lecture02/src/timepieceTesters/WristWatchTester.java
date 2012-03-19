package timepieceTesters;

import java.io.PrintWriter;

import timepieces.WristWatch;
import timepieces.WeekdayCalendar.Weekday;
import timepieces.WeekdayCalendar.Halfday;

public class WristWatchTester {

	/* This program tests the WristWatch class.  In particular, it
	 * shows how methods belonging to both the super- and sub-class
	 * can be called, and the effect of method overriding.
	 */
	public static void main(String[] args) {
		
		/* Declare a console output stream */
		PrintWriter screen = new PrintWriter(System.out, true);
		
		/* Declare a wrist watch */
		WristWatch seiko = new WristWatch();
		
		/* Show its default values */
		screen.println("After construction:");
		screen.println(seiko.getTimeAndDay());
		screen.println();
		
		/* Set the day and the time, using methods from both the
		 * super- and sub-class
		 */
		seiko.setCalendar(Weekday.THU, Halfday.PM);
		seiko.setTime(2, 30);
		screen.println("After setting the day and time:");
		screen.println(seiko.getTimeAndDay());
		screen.println();
		
		/* Test the wraparound feature for days, created by
		 * overriding the "tick" method
		 */
		for (int mins=0; mins < 660; mins++) // 11 hours
		  { seiko.tick(); }
		screen.println("After ticking for 11 hours:");
		screen.println(seiko.getTimeAndDay());
		screen.println();
		
		/* Check what happens at the end of the week
		 */
		for (int mins=0; mins < 3585; mins++) // 2 days, 11 hours and 45 minutes
		  { seiko.tick(); }
		screen.println("After ticking for 2 days, 11 hours and 45 minutes:");
		screen.println(seiko.getTimeAndDay());		
	}

}
