package journeyPlannerAnswer;

import static java.lang.Math.abs;

/**
 * A tool to help plan pedestrian journeys in a large city's
 * central business district which is laid out in a 10-block grid.
 * 
 * @author Colin Fidge
 * @version 1.0 (correct version)
 */
public class JourneyPlanner {

	private int originX, originY = 0; // measured in blocks
	private int destinationX, destinationY = 0;
	private int minutesPerBlock;

	/**
	 * When constructed a journey planner needs to know how many
	 * minutes it takes you to walk one city block on average.
	 * 
	 * @param walkingSpeed how many minutes it takes you to walk one block
	 * @throws Exception if the given speed is zero or negative
	 */
	public JourneyPlanner(int walkingSpeed) throws Exception {
		if (walkingSpeed > 0)
			minutesPerBlock = walkingSpeed;
		else
			throw new Exception("Walking speed must be positive");
	}

	/**
	 * Sets the origin for your planned journey (provided a valid
	 * coordinate is supplied).
	 * 
	 * @param X the origin's X-coordinate from 0 to 10
	 * @param Y the origin's Y-coordinate from 0 to 10
	 * @return true if a valid origin has been supplied, false otherwise
	 */
	public boolean setOrigin(int X, int Y) {
		if (0 <= X && X <= 10 && 0 <= Y && Y <= 10) {
			originX = X; originY = Y;
			return true;
		} else
			return false;
	}

	/**
	 * Sets the destination for your planned journey (provided a valid
	 * coordinate is supplied).
	 * 
	 * @param X the destination's X-coordinate from 0 to 10
	 * @param Y the destination's Y-coordinate from 0 to 10
	 * @return true if a valid destination has been supplied, false otherwise
	 */
	public boolean setDestination(int X, int Y) {
		if (0 <= X && X <= 10 && 0 <= Y && Y <= 10) {
			destinationX = X; destinationY = Y;
			return true;
		} else
			return false;
	}

	/**
	 * Returns the journey time from the origin to the destination
	 * (calculated using Manhattan distances).
	 * 
	 * @return your journey time in minutes
	 */
	public int journeyTime() {
		return (abs(destinationX - originX) + abs(destinationY - originY))
		* minutesPerBlock;	
	}

}
