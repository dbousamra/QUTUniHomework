package answers;

/* A counterpart to the "Secret Message Decoder" */

public class Encoder {

	/* This program encodes a secret message and prints the ciphertext */
	public static void main(String[] args) {

		/* The key for locking the message */
		final int key = 5;
		
		/* The secret message */
		final String message = new String("This is easy!");
		
		/* Extract the individual characters */
		char[] characters = message.toCharArray();
		
		/* Encode each character and print the resulting number */
		for (char aChar: characters) {
			System.out.print(((int)(aChar) - key) + " ");
		};
		
		/* Terminate with a newline */
		System.out.println();

	}

}
