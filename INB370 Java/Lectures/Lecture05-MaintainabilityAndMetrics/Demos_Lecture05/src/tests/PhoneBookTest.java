package tests;

import org.junit.Test;

import phones.NewPhoneNo;
import phones.PhoneBook;
import phones.PhoneNo;
import staff.Employee;
import staff.TitledEmployee;
import static org.junit.Assert.assertEquals;

public class PhoneBookTest {

	/* The following tests illustrate how the original phone book
	 * class can be extended without changing the original code
	 * 
	 * They are NOT a comprehensive or well-designed test suite
	 */
	
	/* Test that the original phone book definition works */
	@Test
	public void oldStylePhoneBook() throws Exception {
		
		/* Create and populate an old style phone book */
		PhoneBook oldBook = new PhoneBook();

		Employee colin = new Employee("Colin", "Fidge");
		oldBook.addEntry(colin, new PhoneNo("31382870"));

		Employee jim = new Employee("Jim", "Hogan");
		oldBook.addEntry(jim, new PhoneNo("31389328"));
		
		/* Check that it worked */
		assertEquals(oldBook.lookUpExtension(jim), "9328");
		assertEquals(oldBook.lookUpExtension(colin), "2870");
	}
	
	/* Test that the various extensions to the phone book work */
	@Test
	public void oldAndNewStylePhoneBook() throws Exception {

		/* Create and populate a new style phone book with
		 * old and new style entries */
		PhoneBook newBook = new PhoneBook();
		
		Employee colin = new Employee("Colin", "Fidge"); // old style entry
		newBook.addEntry(colin, new PhoneNo("31382870"));
		
		TitledEmployee jim = new TitledEmployee("Dr", "Jim", "Hogan"); // new style entry
		newBook.addEntry(jim, new NewPhoneNo("31389328"));		

		/* Check that it worked */
		assertEquals(newBook.lookUpExtension(jim), "89328"); // new style no
		assertEquals(newBook.lookUpExtension(colin), "2870"); // old style no
		assertEquals(jim.getName(), "Jim Hogan");
		assertEquals(jim.getFullName(), "Dr Jim Hogan"); // new style full name
		assertEquals(colin.getName(), "Colin Fidge"); // old style name
	}
	
}
