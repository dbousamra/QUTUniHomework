package incomeTaxFixed;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.math.BigDecimal;

import incomeTaxFixed.IncomeTax_Correct;

/* 
 * "Normal" tests for the taxPayable method
 */

public class IncomeTaxTestNormal {

	private IncomeTax_Correct underTest;  // <-- change this to change tests
	
	@Before public void setUp() {
		underTest = new IncomeTax_Correct();  // <-- change this to change tests
	}
	/* A very poor taxpayer */
	@Test public void normalNoTax() {
		final BigDecimal income = new BigDecimal("10.00");
		final BigDecimal expectedTax = new BigDecimal("0.00");
		assertTrue(underTest.taxPayable(income).equals(expectedTax));
	}
	
	/* A blue-collar worker */
	@Test public void normal30PercentTax() {
		final BigDecimal income = new BigDecimal("50000.00");
		final BigDecimal expectedTax = new BigDecimal("9600.00");
		assertTrue(underTest.taxPayable(income).equals(expectedTax));
	}
	
	/* A white-collar worker */
	@Test public void normal40PercentTax() {
		final BigDecimal income = new BigDecimal("100000.00");
		final BigDecimal expectedTax = new BigDecimal("27100.00");
		assertTrue(underTest.taxPayable(income).equals(expectedTax));
	}
		
	/* A politician or company director */
	@Test public void normalMaxTax() {
		final BigDecimal income = new BigDecimal("200000.00");
		final BigDecimal expectedTax = new BigDecimal("69600.00");
		assertTrue(underTest.taxPayable(income).equals(expectedTax));
	}
}
