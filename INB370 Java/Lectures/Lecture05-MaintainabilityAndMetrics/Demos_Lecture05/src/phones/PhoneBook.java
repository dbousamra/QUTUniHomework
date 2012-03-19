package phones;

import java.util.Map;
import java.util.HashMap;

import staff.Employee;

/**
 * A simple phone directory for employees that allows new (or replacement)
 * entries to be added and extension numbers to be looked up.
 * 
 * @author Colin Fidge
 * @version 1.0
 *
 */

public class PhoneBook {

	/* Phone books are represented as mappings from employee to
	 * phone number
	 */
	Map<Employee, PhoneNo> theBook = new HashMap<Employee, PhoneNo>();
	
	/* Add a new entry to the phone book (or replace an existing one) */
	public void addEntry(Employee name, PhoneNo phone) {
		theBook.put(name, phone);		
	}
	
	/* Return an employee's extension number, if the employee exists */
	public String lookUpExtension(Employee name) {
		if (theBook.containsKey(name))
			return theBook.get(name).getExtension();
		else
			return "Unknown";
	}

}
