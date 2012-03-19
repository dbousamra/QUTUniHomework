package staff;

/**
 * An "old style" employee record that just records the employee's
 * first name and surname.
 * 
 * @author Colin Fidge
 * @version 1.0
 *
 */
public class Employee {

	private String firstName;
	private String surname;
	
	/* Automatically-generated constructor */
	public Employee(String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
	}
	
	/* Automatically-generated setters and getters */
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/* A method to return the employee's full name */
	public String getName() {
		return firstName + " " + surname;
	}

}
