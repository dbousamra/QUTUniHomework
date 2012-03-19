package phones;

/**
 * An "old style" phone number with a 4-digit extension.
 * 
 * @author Colin Fidge
 * @version 2.0
 *
 */
public class PhoneNo {

	protected final int lengthPhoneNo = 8;
	protected String phoneNo;

	/* Constructor checks that the given number is valid */
	public PhoneNo(String newNo) throws Exception {
		/* Save the phone number */
		phoneNo = newNo;
		/* Check number is of valid length and consists only of digits  */
		if (phoneNo.length() != lengthPhoneNo)
			throw new Exception("Invalid number of digits");
		for (char digit : phoneNo.toCharArray())
			if (!Character.isDigit(digit))
				throw new Exception("Invalid digit: " + digit);

		}

	/* Returns the whole phone number */
	public String getPhoneNo() {
		return new String(phoneNo);
	}
	
	/* Returns the number's suffix */
	public String getExtension() {
		final int lengthOfExtension = 4; // old numbers have 4-digit extensions
		return phoneNo.substring(phoneNo.length() - lengthOfExtension, phoneNo.length());		
	}

}
