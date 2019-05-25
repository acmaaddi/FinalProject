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
	
	private TableView<Payments> table = new TableView<Payments>();
   
  
    
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

	
	/*
	final Label label = new Label("Student Loans");
  
	table.setEditable(true);

    

    TableColumn paymentIDCol = new TableColumn("Payment#");
    paymentIDCol.setMinWidth(100);
    paymentIDCol.setCellValueFactory(
            new PropertyValueFactory<Payments, String>("firstName"));

    
    

    table.setItems(paymentList);
    table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

    final VBox vbox = new VBox();
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 0, 0, 10));
    vbox.getChildren().addAll(label, table);

    ((Group) scene.getRoot()).getChildren().addAll(vbox);

    stage.setScene(scene);
    stage.show();
    */
}
	



