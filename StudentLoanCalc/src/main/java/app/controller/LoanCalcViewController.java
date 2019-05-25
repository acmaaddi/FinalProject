package app.controller;

import app.StudentCalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import app.LoanCalculations;
import app.Payments;

//GONNA NEED TO IMPORT EXCEL PMT THING HERE


public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;

	@FXML
	private TextField LoanAmount;

	
	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private Label lblTotalInterest;
	
	@FXML
	private DatePicker PaymentStartDate;
	



	@FXML
	private TextField InterestRate;

	@FXML
	private TextField TermofLoan;
	
	@FXML
	private TextField AdditionalPayment;
	

	/*
	@FXML
	private Label lblTotalInterest;
*/
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {
			System.out.println("Amount: " + LoanAmount.getText());
			double dLoanAmount = Double.parseDouble(LoanAmount.getText());
			double dinterestRate=Double.parseDouble(InterestRate.getText());
			
			
			int dloanTerm=Integer.parseInt(TermofLoan.getText()); 			//why doenst it like this
			double dadditionalPayment=Double.parseDouble(AdditionalPayment.getText()); //this too...???
			
			
			LoanCalculations LC= new LoanCalculations(dinterestRate,dadditionalPayment,dloanTerm,dLoanAmount);
			
			
			double dPaymentTotal= LC.totalPayments();
			//START HERE
			
			
			System.out.println("Amount: " + dLoanAmount);	
			
			
			lblTotalPayemnts.setText(" " + dPaymentTotal);
			System.out.print(dPaymentTotal);
			LocalDate localDate = PaymentStartDate.getValue();
		 
			System.out.println(localDate);
			
			
			
			double dTotalinterest= LC.totalInterestSum();
			
			 double rounded= java.lang.Math.round(dTotalinterest);
			 
			lblTotalInterest.setText(""+ rounded);
			
		
			
			
			
		}
		
		
		
	
}
