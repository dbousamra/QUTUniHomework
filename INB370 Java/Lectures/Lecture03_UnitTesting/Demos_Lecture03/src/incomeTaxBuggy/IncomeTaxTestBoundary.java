package incomeTaxBuggy;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import incomeTaxBuggy.IncomeTax_Buggy;

/* 
 * Some "boundary" tests for the taxPayable method
 */
public class IncomeTaxTestBoundary {

	private IncomeTax_Buggy underTest;
	
	@Before public void setUp() {
		underTest = new IncomeTax_Buggy();
	}
	
	/* Borderline 15% tax rate */
	@Test public void borderline15PercentRate() {
		final BigDecimal income = new BigDecimal("30000.00");
		final BigDecimal expectedTax = new BigDecimal("3600.00");
		assertTrue(underTest.taxPayable(income).equals(expectedTax));
	}
	
	/* Borderline case - no income */
	@Test public void noIncome() {
		final BigDecimal income = new BigDecimal("0.00");
		final BigDecimal expectedTax = new BigDecimal("0.00");
		assertTrue(underTest.taxPayable(income).equals(expectedTax));
		}

	/* Borderline cases - from 0% to 15% tax rate */
	@Test public void from0To15Percent() {
		final BigDecimal justBelow = new BigDecimal("5999.00");
		final BigDecimal onTheLine = new BigDecimal("6000.00");
		final BigDecimal justAbove = new BigDecimal("6001.00");
		final BigDecimal fifteenCents = new BigDecimal("0.15");
		assertTrue(underTest.taxPayable(justBelow).equals(underTest.taxPayable(onTheLine)) &&
				underTest.taxPayable(onTheLine).equals(underTest.taxPayable(justAbove).subtract(fifteenCents)));
	}
	
	/* Borderline cases - from 30% to 40% tax rate */
	@Test public void from30To40Percent() {
		final BigDecimal justBelow = new BigDecimal("74999.00");
		final BigDecimal onTheLine = new BigDecimal("75000.00");
		final BigDecimal justAbove = new BigDecimal("75001.00");
		final BigDecimal thirtyCents = new BigDecimal("0.30");
		final BigDecimal fortyCents = new BigDecimal("0.40");
		assertTrue((underTest.taxPayable(justBelow).add(thirtyCents)).equals(underTest.taxPayable(onTheLine)) &&
				underTest.taxPayable(onTheLine).equals(underTest.taxPayable(justAbove).subtract(fortyCents)));
	}

}
