package timepieceTesters;

import java.io.PrintWriter;

import timepieces.AnalogClock;

public class AnalogClockTester {

	/* This program tests the AnalogClock class.  In particular, it
	 * shows how objects generated from the class maintain distinct
	 * states.
	 */
	public static void main(String[] args) {
		
		/* Declare a console output stream */
		PrintWriter screen = new PrintWriter(System.out, true);
		
		/* First declare two "wall clocks" */
		AnalogClock grandfather = new AnalogClock("Grandfather clock");
		AnalogClock mantle = new AnalogClock("Mantle clock");
		
		/* Tick them a different number of times and show that they
		 * have different times
		 */
		grandfather.tick(); grandfather.tick(); // twice
		mantle.tick(); mantle.tick(); mantle.tick(); //thrice
		screen.println("After the ticking test:");
		screen.println(grandfather.getName() + " - " +
				grandfather.getTime());
		screen.println(mantle.getName() + " - " +
				mantle.getTime());
		screen.println();
		
		/* Now reset the clocks to specific times
		 */
		grandfather.setTime(6, 34);
		mantle.setTime(11, 55);
		screen.println("After the resetting test:");
		screen.println(grandfather.getName() + " - " +
				grandfather.getTime());
		screen.println(mantle.getName() + " - " +
				mantle.getTime());
		screen.println();
	
		/* Tick the clocks by a few minutes to make sure the times
		 * wraparound correctly
		 */
		for (int mins=0; mins < 30; mins++) { grandfather.tick(); }
		for (int mins=0; mins < 75; mins++) { mantle.tick(); }
		screen.println("After the wraparound test:");
		screen.println(grandfather.getName() + " - " +
				grandfather.getTime());
		screen.println(mantle.getName() + " - " +
				mantle.getTime());
	}

}
