package ch.makery.address.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.UUID;

import base.RateDAL;
import ch.makery.address.MainApp;
import ch.makery.address.model.Rate;
import domain.RateDomainModel;

import static ch.makery.address.model.Rate.*;

public class MortgageController {

	@FXML
    private TextField income;
	@FXML
    private TextField expenses;
	@FXML
    private TextField creditScore;
	@FXML
    private TextField houseCost;
	
	
	@FXML
    private ComboBox<Integer> Combobox1;
	
	@FXML
	private Label FinalLabel;
	
	private double Income;
	private double Expenses;
	private int CreditScore;
	private int HouseCost;
	private int Term;
	private RateDomainModel rate = new RateDomainModel();
	

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MortgageController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
    	Combobox1.getItems().addAll(15, 30);
	}

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    
    public void Actions(ActionEvent event) {
    	
    	this.Income = Double.valueOf(income.getText());
		this.Expenses = Double.valueOf(expenses.getText());
		this.CreditScore = Integer.valueOf(creditScore.getText());
		this.HouseCost = Integer.valueOf(houseCost.getText());
		this.Term = (int) Combobox1.getValue();
		
		if (!income.getText().equals("")) {
			Income = 0;
		}
		if (!expenses.getText().equals("")){
			Expenses = 0;
		}
		if (!creditScore.getText().equals("")){
			CreditScore = 0;
		}
		if (!houseCost.getText().equals("")){
			HouseCost = 0;
		}
		if ((!Combobox1.getValue().equals(15) && !Combobox1.getValue().equals(30))) {
			Term = 15;
		}
		
		rate.setInterestRate(RateDAL.getRate(CreditScore));
		rate.setMinCreditScore(CreditScore);
		
		double payment = getPayment(this.CreditScore, this.Term * 12, this.HouseCost);
		
		if (payment <= this.Income * 0.36 && payment <= (this.Income - this.Expenses * 12) * 0.28){
			
			this.FinalLabel.setText("House Cost too high");
		}
			
		else {
				this.FinalLabel.setText("Mortgage payment per month" + "$" + String.valueOf(payment));
		}
    	
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
   
}