package staff;

/**
 * A "new style" employee record with includes the employee's title.
 * 
 * @author Colin Fidge
 * @version 1.0
 *
 */
public class TitledEmployee extends Employee {

	/* New field for titled employees */
	String title;
	
	/* Constructor calls the superclass's constructor to store the given
	 * first name and surname
	 */
	public TitledEmployee(String title, String firstName, String surname) {
		super(firstName, surname);
		this.title = title;
	}

	/* Automatically-generated setter and getter */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	/* New method to return a titled employee's full name */
	public String getFullName() {
		return title + " " + getName();
	}

}
