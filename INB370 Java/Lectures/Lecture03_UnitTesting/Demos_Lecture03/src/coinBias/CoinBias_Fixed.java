package coinBias;

/** 
 * Check the fairness of a coin.
 * 
 * @author Colin Fidge
 * @version 1.0 (correct, with assertions)
 */
public class CoinBias_Fixed {

	/**
	 * Given the results of flipping a coin several times, return which
	 * face occurred most often.
	 * 
	 * @param tosses the results of flipping the coin, with 'H' for a
	 * head and 'T' for a tail
	 * @return the face that appears most often, or 'X' if heads and
	 * tails occur the same number of times
	 */
	public static char checkCoin(char[] tosses) {
		
		int numHeads = 0;
		int numTails = 0;
		
		// Assert the correctness of the input
		for (char inChar : tosses) {
			assert inChar == 'H' || inChar == 'T' : "Invalid data";
		}
		
		/* Although this would be most elegantly done using a
		 * "for each" loop, we use an indexed one here for the
		 * sake of illustration
		 */
		for (int i = 0; i < tosses.length; i++) {
			// Check loop invariant
			assert numHeads + numTails == i : "Loop invariant failed";
			
			if (tosses[i] == 'H')
				numHeads += 1;
			else // must be a tail
				numTails += 1;
		}
		// Check loop invariant on exit
		assert numHeads + numTails == tosses.length : 
			"Loop invariant failed on exit";
		
		if (numHeads > numTails)
			return 'H';
		else if (numHeads < numTails)
			return 'T';
		else // they must be equal
			return 'X';
	}
	
	
	/*
	 * Main program to test the checkCoin function
	 */
	public static void main(String[] args) {
		
		/* Some valid inputs */
		System.out.println("More heads than tails: " + 
				checkCoin(new char[] {'H', 'H', 'T', 'H', 'T', 'H'}));
		System.out.println("More tails than heads: " + 
				checkCoin(new char[] {'T', 'H', 'T', 'H', 'T', 'H', 'T'}));
		System.out.println("Equal number of tails and heads: " + 
				checkCoin(new char[] {'T', 'H', 'T', 'H', 'H', 'T'}));
		System.out.println("All tails: " + 
				checkCoin(new char[] {'T', 'T', 'T', 'T', 'T'}));
		System.out.println("No tosses: " + 
				checkCoin(new char[] {}));
		
		/* An invalid input */
		System.out.println("Corrupted data: " + 
				checkCoin(new char[] {'T', 'H', 'A', 'T', 'H', 'B', 'H'}));
	}

}
