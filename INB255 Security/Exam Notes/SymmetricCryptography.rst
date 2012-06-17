Basic crypto:

	Plaintext ---> Encryption ---> CipherText ---> Decryption operation ---> Plaintext
				 Algorithm + KEY					  Algorithm + KEY


Two types of modern ciphers:

	Symmetric (one key) --> Stream and Block

		Encryption and Decryption keys are the same (or one can easily be deduced from the other). The key (K) must be kept secret so has to be distributed or stored securely.

	Asymmetric (two keys)

		Much newer.

		Encryption and Decryption keys are different and disclosing one does not compromise the other.


Encryption: C = E(P, K)
			Ciphertext = Encryption(Plaintext, Key)

Decryption: P = D(C, K)
			Plaintext = Decryption(Ciphertext, Key)

Two types of symmetric ciphers:
	Stream cipher and block cipher


STREAM CIPHER:

	Plaintext and ciphertext are viewed as a STREAM of characters. Character may be 1 bit, or n-bit word (eg 8-bit byte).

	Encrypted one character at a time under a time varying function of the key

	Decrypted one character at a time under a time varying function of the key

	Most common type is a binary additive stream cipher. Plaintext, keystream and ciphertext are all streams of bits and combining operation is just XOR

	FAST - can be used in real time

One time pad:
	
	Plaintext is a stream of bits.

	Key is a stream of bits:
		BUT: Truly random, same length as message, and used only ONCE

	Ciphertext is just the XOR of key and plaintext. Simple.

	Plaintext is just the XOR of key and ciphertext.

	Can't reuse keys.

	Problems:
		We can't reuse keys. So, if you are trnasmitting a key of the same length as the cipher... and you are able to do so securely, then why not send the plaintext then?
		Major problem is key management.

Keystreams:

	Pseudo random. 

	Must be used in same position to decrypt properly.
		If a loss or order occurs then the whole thing is usesless and cannot be recovered.
		If a bitflip occurs then it's just that letter 
	To recover from loss of sync you could try:
		Keystream offsets at receiver end
		Request retransmission







