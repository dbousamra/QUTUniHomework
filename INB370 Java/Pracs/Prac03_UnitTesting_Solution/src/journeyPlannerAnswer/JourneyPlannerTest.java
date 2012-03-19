package journeyPlannerAnswer;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import journeyPlannerAnswer.JourneyPlanner; // <-- change for different planners (A or B)

public class JourneyPlannerTest {

	/* The following tests are sufficient to reveal the
	 * bugs in the incorrect version of the JourneyPlanner
	 * program, but should not be considered a thorough
	 * test suite
	 */

	private JourneyPlanner planner; // <-- change this

	@Before
	/*
	 * Create a fresh planner before each test
	 */
	public void newPlanner() throws Exception {
		planner = new JourneyPlanner(3);  // <-- change this
	}

	@Test
	/* A typical case - passed by both versions */
	public void normalCase() {
		planner.setOrigin(0, 1);
		planner.setDestination(3, 4);
		assertEquals(planner.journeyTime(), 18);
	}

	@Test
	/* An extreme case - passed by both versions */
	public void alongTheBorder() {
		planner.setOrigin(0, 0);
		planner.setDestination(10, 0);
		assertEquals(planner.journeyTime(), 30);
	}

	@Test
	/* Ensure destination can be changed - passed by both versions */
	public void changeDestination() {
		planner.setOrigin(5, 1);
		planner.setDestination(2, 3);
		planner.setDestination(1, 2);
		assertEquals(planner.journeyTime(), 15);
	}

	@Test
	/* Extreme case - passed by both versions */
	public void goingNowhere() {
		planner.setOrigin(8, 9);
		planner.setDestination(8, 9);
		assertEquals(planner.journeyTime(), 0);
	}

	@Test
	/* Extreme case - passed by both versions */
	public void longestJourney() {
		planner.setOrigin(0, 0);
		planner.setDestination(10, 10);
		assertEquals(planner.journeyTime(), 60);
	}

	@Test
	/* Another normal case, but failed by JourneyPlannerB because
	 * of an arithmetic error when the origin's Y coordinate is
	 * greater than the destination's Y coordinate
	 */
	public void towardsZeroZero() {
		planner.setOrigin(6, 5);
		planner.setDestination(1, 2);
		assertEquals(planner.journeyTime(), 24);
	}
	
	@Test
	/* An extreme case which is failed by JourneyPlannerB
	 * because it has an incorrect boolean condition which
	 * prevents the origin coordinates from being set to 10
	 */
	public void startingAtTen() {
		planner.setOrigin(10, 2);
		planner.setDestination(8, 5);
		assertEquals(planner.journeyTime(), 15);
	}
}
