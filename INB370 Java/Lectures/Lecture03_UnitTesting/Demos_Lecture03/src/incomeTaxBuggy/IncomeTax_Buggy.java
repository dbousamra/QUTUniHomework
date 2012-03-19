package incomeTaxBuggy;

import java.math.BigDecimal;

/**
 * Calculator for income tax, based on Australian Taxation Office
 * data for the tax year July 2007-June 2008.
 * 
 * @author Donna Teague (Python version) and Colin Fidge (Java port)
 * @version 1.0 (buggy)
 */
public class IncomeTax_Buggy {

	/* 
	 * Round a big decimal number to two places, using bankers'
	 * rounding
	 */
	private BigDecimal rounded(BigDecimal aNumber) {
		return aNumber.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	/**
	 * Returns the amount of income tax payable on gross income.
	 * 
	 * @param income the taxpayer's total annual income, in Australian dollars
	 * @return the tax owing, in Australian dollars
	 */
	public BigDecimal taxPayable(BigDecimal income) {

		/* Tax bracket thresholds, in dollars */
		final BigDecimal threshold_0 =   new BigDecimal("6000.00");
		final BigDecimal threshold_1 =  new BigDecimal("30000.00");
		final BigDecimal threshold_2 =  new BigDecimal("75000.00");
		final BigDecimal threshold_3 = new BigDecimal("150000.00");

		/* Marginal tax rates, in percentages */
		final BigDecimal rate_1 = new BigDecimal(0.15);
		final BigDecimal rate_2 = new BigDecimal(0.30);
		final BigDecimal rate_3 = new BigDecimal(0.40);
		final BigDecimal rate_4 = new BigDecimal(0.45);

		/* Tax bases on threshold amounts, in dollars */
		final BigDecimal base_2 =  new BigDecimal("3600.00");
		final BigDecimal base_3 = new BigDecimal("17100.00");
		final BigDecimal base_4 = new BigDecimal("47100.00");

		/* tax payable */
		BigDecimal tax;
		
		/* $0-$6,000: No tax payable */
		tax = new BigDecimal("0.00");
		/* $6,001Ð$30,000: 15c for each $1 over $6,000 */
	    if (income.compareTo(threshold_0) == 1) // i.e., greater than
	        tax = rate_1.multiply(income.subtract(threshold_0)); 
	    /* $30,001Ð$75,000: $3,600 plus 30c for each $1 over $30,000 */
	    else if (income.compareTo(threshold_1) == 1)
	        tax = base_2.add(rate_2.multiply(income.subtract(threshold_1))); 
	    /* $75,001 Ð $150,000 = $17,100 plus 40c for each $1 over $75,000 */
	    else if (income.compareTo(threshold_2) == 1) 
	        tax = base_3.add(rate_3.multiply(income.subtract(threshold_2))); 
	    /* $150,001 and over: $47,100 plus 45c for each $1 over $150,000 */
	    else if (income.compareTo(threshold_3) == 1) 
	        tax = base_4.add(rate_4.multiply(income.subtract(threshold_3))); 
		
	    return rounded(tax);
	}
}
