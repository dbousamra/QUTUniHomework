package answers;

/* A solution to the "Secret Message Decoder" exercise */

public class Decoder {

	/* This program decodes and prints the given secret message */
	public static void main(String[] args) {

		/* The key for unlocking the message */
		final int key = 5;
		
		/* The secret message */
		final int[] message = {82, 96, 103, 103, 27, 95, 106, 105, 96, 28};

		/* Decode and print each encoded character */
		for (int charcode: message) {
			System.out.print((char)(charcode + key));
		};
		
		/* Terminate with a newline */
		System.out.println();

	}

}
