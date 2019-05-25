package app;
import java.time.Month;
import java.util.Calendar;

import org.apache.poi.ss.formula.functions.Finance;

import java.time.LocalDate;
import app.LoanCalculations;

public class Payments {

	private int PaymentNumber;
	private Month DueDate;
	private double pmtPayment;
	private double AdditionalPayment;
	private double Interest;
	private double Principal;
	private double Balance;
	
	public int getPaymentNumber() {
		return PaymentNumber;
	}

	public void setPaymentNumber(int paymentNumber) {
		PaymentNumber = paymentNumber;
	}

	public Month getDueDate() {
		return DueDate;
	}

	public void setDueDate(Month dueDate) {
		DueDate = dueDate;
	}

	//rest of getters and setters go here
	
	

	public Payments( int paymentID,Month startDate, double pmtPayment, double AdditionalPayment, double Interest, double Principal, double balance) {
		//double IPMT,double PPMT, double totalPrincipal, 
		this.DueDate= startDate;
		this.PaymentNumber = paymentID;
		
		this.AdditionalPayment= AdditionalPayment;
		this.Balance= balance;
		this.Interest= Interest;
		this.Principal= Principal;
		
		
	}

	public double getPmtPayment() {
		return pmtPayment;
	}

	public void setPmtPayment(double pmtPayment) {
		this.pmtPayment = pmtPayment;
	}

	public double getAdditionalPayment() {
		return AdditionalPayment;
	}

	public void setAdditionalPayment(double additionalPayment) {
		AdditionalPayment = additionalPayment;
	}

	public double getInterest() {
		return Interest;
	}

	public void setInterest(double interest) {
		Interest = interest;
	}

	public double getPrincipal() {
		return Principal;
	}

	public void setPrincipal(double principal) {
		Principal = principal;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}
	

	
}
	
	

