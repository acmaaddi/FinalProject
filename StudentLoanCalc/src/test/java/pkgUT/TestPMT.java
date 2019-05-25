package pkgUT;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.apache.poi.ss.formula.functions.*;
import org.junit.Test;

import app.Payments;
import app.LoanCalculations;

public class TestPMT {

	@Test
	public void test() {
		double PMT;
		double r = 0.07 / 12;
		double n = 20 * 12;
		double p = 150000;
		double f = 0;
		boolean t = false;
		PMT = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		
		double PMTExpected = 1162.95;
		
		
		assertEquals(PMTExpected, PMT, 0.01);
		
		
		
	}
	@Test
	public void testppmt() {
		double PPMT;
		double r = 0.07 / 12;
		int n = 20 * 12;
		double p = 5000;
		double f = 0;
		boolean t = false;
		PPMT =Math.abs(Finance.ppmt(r,n,1,p,0, 0));

		double PMTExpected = 28.89;
		
		System.out.println(PPMT);
		//why is this such a big and wrong number
		assertEquals(PMTExpected, PPMT, 0.01);
		//this ppmt isn't working..??
		
		
		
	}
	@Test
	public void testpayments() {

	double dinterestRate = 0.07 / 12;
	int dloanTerm = 20 * 12;
	double dLoanAmount = 5000;
	double f = 0;
	boolean t = false;
	double dadditionalPayment =0;
	LoanCalculations LC= new LoanCalculations(dinterestRate,dadditionalPayment,dloanTerm,dLoanAmount);
	
	double totalnum= LC.totalPayments();

	
	double paymentsExpected =1400;
	//number generated from excel
	
	
	//why is this such a big and wrong number
	assertEquals(totalnum, paymentsExpected, 0.01);
	}
	

	
	
	@Test
	public void testInterest() {

	double dinterestRate = 0.07 / 12;
	int dloanTerm = 20 * 12;
	double dLoanAmount = 5000;
	double f = 0;
	boolean t = false;
	double dadditionalPayment =0;
	LoanCalculations LC= new LoanCalculations(dinterestRate,dadditionalPayment,dloanTerm,dLoanAmount);
	
	double totalnum= LC.totalInterestSum();

	
	double interestExpected =74.57;
	//number generated from excel
	
	
	//why is this such a big and wrong number
	assertEquals(totalnum, interestExpected, 0.01);
	}
	
}

 

