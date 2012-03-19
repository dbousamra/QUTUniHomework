package rainfallAverage;

import java.util.ArrayList;

/**
 * A class to keep track of average rainfall in a period of time, based
 * on regular (assumed to be daily) rainfall figures.
 * 
 * @author Colin Fidge
 * @version 1.0
 */
public class RainfallAverage {

	private ArrayList<Integer> suppliedValues = new ArrayList<Integer>();

	/* Initially there are no rainfall readings */
	RainfallAverage() {
		reset();
	}

	/**
	 * Clears the collected data.
	 */
	public void reset() {
		suppliedValues.clear();
	}

	/**
	 * Adds a new rainfall reading.
	 * 
	 * @param newReading the new value, in millimetres
	 * @return true if the rainfall value was valid and was stored
	 * successfully, false otherwise
	 */
	public boolean addTodaysRain(Integer newReading) {
		if (newReading >= 0) {
			suppliedValues.add(newReading);
			return true;
		} else // can't have negative rainfall
			return false;
	}

	/**
	 * Return the average of the currently stored values, since object construction
	 * or the last reset, in millimetres.
	 * Generates an exception if called when there are no values.
	 * 
	 * @return the average of the rainfall readings supplied
	 */
	public Integer getAverage() {
		int total = 0;
		for (int reading : suppliedValues) { total += reading; };
		return total / suppliedValues.size();
	}

}
