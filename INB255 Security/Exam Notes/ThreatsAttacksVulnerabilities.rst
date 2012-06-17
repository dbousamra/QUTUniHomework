Goals
=====

Confidentiality
	Preventing the unauthorised disclosure of information

Integrity
	Preventing the unauthorised modification or destruction of information

Availability
	Ensuring resources are accessible when required by an authorised entity


Security Measures or Controls:

Preventive controls:
	Prevents attempts to exploit vulnerabilities (Encryption, firewall etc)

Detective controls:
	Warns or attempts to exploit vulnerabilities (Intrusion detection system, Anti-Virus scan)

Corrective controls:
	Correct error or irregularities that have been detected (Anti-Virus fix, System restore etc)


Threats
=======

External
	Threat that is outside an organisation/entity

Internal
	Threat that lies within the organisation/entity

Types
-----

- Natural event - something naturally occurring (earthquake, flood etc)

- Human action - something deliberate (eavesdropping, fire, fraud etc)

Vulnerabilities
---------------

Weaknesses in a system that could cause harm to information assets

Need to consider components of information system.
	
	Property, People, Procedures

Property includes: Physical assets, hardware, software, data. 
Aspects to consider include the location of these assets and whether they are susceptible to threats, maintenance, and monitoring and logging of physical access.

Attacks
=======

Occurs when a vulnerability is deliberately exploited

The attacker is a person who deliberately attempts to exploit a vulnerability to A.) Gain unauthorized access or B.) Perform unauthorized actions

Types
-----

Passive
	Attackers goal is to obtain information, and does not intend to alter information. Difficult to detect and often trying to prevent the attack

	Eavesdropping: Listening in on conversations involving sensitive data

	Shoulder surfing: Watching the actions of others without their knowledge or consent (PIN, passwords etc)

	Network monitoring/interception/eavesdropping: Using wireshark or a packet sniffer to view their network traffic.


Active
	Attackers goal may be to obtain, modify or replicate information. Requires some action or inteaction with the system by the attacker.

	Denial Of Service (DoS) attack: Make the information unavailable to authorized users

	Distributed Denial of Service (DDoS) attack:

	Masquerade/Spoofing: Where an entitiy pretends to be another in order to deceieve. Email address spoofing etc

	Phising: Pretending to be something it's not. I.e. making a webpage look identical to the banking login page so users accidentally input their credentials.

	Man in the middle attack (MITM): Spoofing where a person places themselves inbetween two parties and intercepts data. That person could just intercept, but they could also MODIFY data.

	Social engineering: Uses social skills to convince people to reveal information

	Replay attack: Valid data is retransmitted at a later date. I.e. password is encrypted, but you could submit an encrypted password and it still works (they don't actually know what the password plain text is)

Information Flows:

::

	Normal info flow: Alice -----> Bob

	Interception flow: Alice -----> Bob
	                           |
	                           V
	          Third Party (Breaches confidentiality)

	Interruption flow: Alice ---|   Bob (Stops availability)

	Modification flow: Alice ---|---> Bob
							   ||
							   V|
			   Third Party (Breaches availability)

	Fabrication flow: Alice     |---> Bob
								|
								|
			   Third Party (Breaches authenticity)








