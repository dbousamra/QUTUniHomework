package totaliserAnswer;

/**
 * A class that maintains the sum of a given series of numbers.
 * 
 * @author Colin Fidge
 * @version 1.0 (correct version)
 *
 */
public class Totaliser {

	private int total = 0;

	/**
	 * Reset the sum to zero.
	 */
	public void reset() {
		total = 0;
	}

	/**
	 * Returns the sum of the numbers entered since the last
	 * reset (or since construction).
	 * 
	 * @return the sum of the numbers entered since resetting
	 */
	public int getSum() {
		return total;
	}

	/**
	 * Adds the given new value to the sum of the numbers.
	 * 
	 * @param newValue the new value to be added to the sum
	 */
	public void enterValue(int newValue) {
		total += newValue;
	}

}
