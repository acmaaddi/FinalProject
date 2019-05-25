package app;

import java.io.IOException;

import app.controller.LoanCalcViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class StudentCalc extends Application {

	private Stage primaryStage;
	
	private BorderPane LoanScreen = null;
	
	private LoanCalcViewController LCVC = null;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		ShowScreen();
		
	}
	
	
  
    
	public void ShowScreen() {
		// Parent root;
		try {

			FXMLLoader loader = new FXMLLoader();
			loader = new FXMLLoader(getClass()
					.getResource("/app/view/LoanCalcView.fxml"));
			LoanScreen = (BorderPane) loader.load();
			Scene scene = new Scene(LoanScreen);
			primaryStage.setScene(scene);
			LCVC = loader.getController();
			LCVC.setMainApp(this);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/*public class StudentLoanTable extends Application {
	 * 
	 * private TableView<Payments> table = new TableView<Payments>();
	 private final ObservableList<Person> data =
		        FXCollections.LinkedList(
		            
		            
		            //this is where my payments list would go...but i created it in loanCalculations...
		             * something tells me it should have bee created in another class		            
		            
		            
		            )
		        );
		        
		        
		        
	final Label label = new Label("Student Loans");
  
	table.setEditable(true);

	private TableView<Payments> table = new TableView<Payments>();
	 private final LinkedList<Person> data =
		        FXCollections.LinkedList(
		         
		         
		         //this is where my data would have gone from paymentList 
		        );
    

    TableColumn paymentIDCol = new TableColumn("Payment#");
    paymentIDCol.setMinWidth(100);
    paymentIDCol.setCellValueFactory(
            new PropertyValueFactory<Payments, String>("Payment#"));
	
    TableColumn paymentIDCol = new TableColumn("Due Date");
    paymentIDCol.setMinWidth(100);
    paymentIDCol.setCellValueFactory(
            new PropertyValueFactory<Payments, String>("Due Date"));

        TableColumn paymentIDCol = new TableColumn("Payment");
    paymentIDCol.setMinWidth(100);
    paymentIDCol.setCellValueFactory(
            new PropertyValueFactory<Payments, String>("Payment"));
	
    TableColumn paymentIDCol = new TableColumn("Interest");
    paymentIDCol.setMinWidth(100);
    paymentIDCol.setCellValueFactory(
            new PropertyValueFactory<Payments, String>("Due Date"));

        TableColumn paymentIDCol = new TableColumn("Principal");
    paymentIDCol.setMinWidth(100);
    paymentIDCol.setCellValueFactory(
            new PropertyValueFactory<Payments, String>("Principal"));
	
    TableColumn paymentIDCol = new TableColumn("Balance");
    paymentIDCol.setMinWidth(100);
    paymentIDCol.setCellValueFactory(
            new PropertyValueFactory<Payments, String>("Balance"));

    
    
    
    

    table.setItems(paymentList);
    table.getColumns().addAll(paymentIDCol, lastNameCol, emailCol);

    final VBox vbox = new VBox();
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 0, 0, 10));
    vbox.getChildren().addAll(label, table);

    ((Group) scene.getRoot()).getChildren().addAll(vbox);

    stage.setScene(scene);
    stage.show();
    */
}
	



