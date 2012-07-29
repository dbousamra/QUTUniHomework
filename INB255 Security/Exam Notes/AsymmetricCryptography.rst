Key Establishment:

Symmetric Ciphers:

	1. Generate a key before the session

		How many keys? n(n-1)/2

		Not practical for large participants

	2. Use a trusted third party service

		Need a key to communicate with that party



	3. Diffie-Hellman Algorithm
		
		Both pick mathematical functions. Then they combine then and that becomes the key. 
		
		Still an issue because there is no assurance they send the functions them each other. MITM attack possible


