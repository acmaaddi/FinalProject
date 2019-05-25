package app;

import java.time.Month;
import java.util.LinkedList;

import org.apache.poi.ss.formula.function.*;
import org.apache.poi.ss.formula.functions.FinanceLib;
import org.apache.poi.ss.formula.functions.Finance;
import app.Payments;


public class LoanCalculations {
		
	private Month DueDate;
	public void setDueDate(Month dueDate) {
		DueDate = dueDate;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Month getDueDate() {
		return DueDate;
	}
	
	private double rate; //the interest rate
	private double extraPayment; 
	
	//private double totalPrinciple; delete getters and seters for this??
	
	private int termPeriod; //how many years
	
	private double loanAmount;

	//these are being tracked

	private int PaymentNumber; //1,2,3,4...
	private double realInterest; //dont htink i need this
	private double futureValue=0; //is this just loan amount??

	
	public LoanCalculations(double myRate,double myexPayment,int mytermPeriod,double myloanAmount) {
		this.rate=myRate;
		this.extraPayment=myexPayment;
		this.termPeriod=mytermPeriod;
		this.loanAmount= myloanAmount;
		
	}
		
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getExtraPayment() {
		return extraPayment;
	}
	public void setExtraPayment(double extraPayment) {
		this.extraPayment = extraPayment;
	}
	public int getTermPeriod() {
		return termPeriod;
	}
	public void setTermPeriod(int termPeriod) {
		this.termPeriod = termPeriod;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getPaymentNumber() {
		return PaymentNumber;
	}
	public void setPaymentNumber(int paymentNumber) {
		PaymentNumber = paymentNumber;
	}
	public double getRealInterest() {
		return realInterest;
	}
	public void setRealInterest(double realInterest) {
		this.realInterest = realInterest;
	}
	public double getFutureValue() {
		return futureValue;
	}
	public void setFutureValue(double futureValue) {
		this.futureValue = futureValue;
	}
	

	public double pmtCalculator(int thispayment) {

		double pmtnumber= Math.abs(FinanceLib.pmt(rate/12,thispayment*12, loanAmount,futureValue,false));
	
		return pmtnumber;
		//doenst return the correct number
		
	}
public double totalPrincipal(int thispayment) {
	

	double ppmtnumber=(Finance.ppmt(rate/12,termPeriod*12,thispayment,loanAmount, futureValue,0));
	//for some reason the do while loop only runs onces when I use the absolute value function 
	//cant resolve whats up with ppmt
	
	//definitely should be an absolute value
	
	//double ppmtnumber=Math.abs(Finance.ppmt(rate/12,termPeriod*12,thispayment,loanAmount, futureValue,0));

	
			
			return ppmtnumber+ extraPayment;

	
//PPMT WILL NOT RETURN THE CORRECT the correct answer for some reason
			// pmt and ipmt are giving me the same issues an di dont know how to resolve them

}

public double InterestonThisBalance(double ibalance) {
	
	//Finance.ipmt(rate/12, loanAmount, termPeriod*12,futureValue)- _____________;
	return ibalance*rate/12;
	
}


/*
public double balanceRemaining(int paynumb,double currentBalance) {
	return currentBalance-totalPrincipal(paynumb);
}
*/


public int totalPayments() {
	int myPaymentNumber = 0;
	double currentBalance= loanAmount;
	LinkedList<Payments> paymentList = new LinkedList<Payments>();
	double totalInterest=0;

	do {
		
		myPaymentNumber+=1;
		double ppmt= totalPrincipal(myPaymentNumber);
		
		
		currentBalance= currentBalance - ppmt;
		
		
		double pmt= this.pmtCalculator(myPaymentNumber);
		double iRealInterest= this.InterestonThisBalance(currentBalance);
		totalInterest= totalInterest+ iRealInterest;
		
		double itotalPrincipal = this.totalPrincipal(myPaymentNumber);
		
		
		Payments PC1= new Payments(myPaymentNumber,DueDate,pmt,extraPayment, iRealInterest,itotalPrincipal,currentBalance);
		
		paymentList.add(PC1);
		
		
		

		System.out.println("balance "+ currentBalance);
		//System.out.println("DueDate "+ DueDate);
		//System.out.println("extraPayment "+ extraPayment);
		//System.out.println("interest "+ iRealInterest);
		
	} while (currentBalance>=0);
	
	
	return myPaymentNumber;
}
public double totalInterestSum() {
	int myPaymentNumber = 0;
	double currentBalance= loanAmount;
	LinkedList<Payments> paymentList = new LinkedList<Payments>();
	double totalInterest=0;

	do {
		
		myPaymentNumber+=1;
		double ppmtTest= totalPrincipal(myPaymentNumber);
			
		currentBalance= currentBalance- ppmtTest;
		
	
		double iRealInterest= this.InterestonThisBalance(currentBalance);
		
		
		totalInterest= totalInterest+ iRealInterest;
		
	} while (currentBalance<=0) ;
	//this should be a greater than but it only gives zero if thats the case....so ill leave it as <=
	
	
	
	return totalInterest;
}


}
