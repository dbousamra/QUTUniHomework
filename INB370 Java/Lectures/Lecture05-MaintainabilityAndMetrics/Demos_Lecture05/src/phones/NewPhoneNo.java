package phones;

/**
 * A "new style" phone number that has a 5-digit extension.
 * 
 * @author Colin Fidge
 * @version 2.0
 *
 */
public class NewPhoneNo extends PhoneNo {

	/* Constructor just calls superclass's constructor */
	public NewPhoneNo(String newNo) throws Exception {
		super(newNo);
	}
	
	/* Overriding method that returns a longer suffix than for old numbers */
	public String getExtension() {
		final int lengthOfExtension = 5; // new style numbers have 5-digit extensions
		return phoneNo.substring(phoneNo.length() - lengthOfExtension, phoneNo.length());
	}

}
