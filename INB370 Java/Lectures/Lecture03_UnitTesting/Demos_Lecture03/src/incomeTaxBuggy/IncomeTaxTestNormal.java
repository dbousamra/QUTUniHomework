package incomeTaxBuggy;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.math.BigDecimal;

import incomeTaxBuggy.IncomeTax_Buggy;

/* 
 * "Normal" tests for the taxPayable method
 */

public class IncomeTaxTestNormal {

	private IncomeTax_Buggy underTest;
	
	@Before public void setUp() {
		underTest = new IncomeTax_Buggy();
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
