package allSameAnswer;

import java.lang.Exception;

/**
 * A (stateless) class that provides a function for checking
 * whether all natural numbers in a given array are identical.
 * 
 * @author Colin Fidge
 * @version 1.0 (correct version)
 *
 */
public class AllSame {

	/**
	 * Given a (non-empty) array of natural numbers (i.e., non-negative
	 * integers), returns true iff they are all the same.
	 * 
	 * @param naturals an array of natural numbers
	 * @return true if all the numbers are the same, false otherwise
	 * @throws Exception if there are no numbers in the array or if there
	 * are any non-natural numbers in the array
	 */
	public boolean same(int[] naturals) throws Exception {
		/* confirm that there are some numbers */
		if (naturals.length == 0)
			throw new Exception("No numbers to compare");
		/* confirm that the numbers are all natural */
		for (int number: naturals)
			if (number < 0) 
				throw new Exception("Non-natural number in array");
		/* see if they're all the same */
		int first = naturals[0];
		for (int index = 1; index < naturals.length; index++)
			if (naturals[index] != first)
				return false;
		return true;
	}

}
