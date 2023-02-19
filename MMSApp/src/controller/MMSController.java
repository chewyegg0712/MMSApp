package controller;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import au.edu.uts.ap.javafx.*;
import javafx.scene.image.Image;
import java.text.DecimalFormat;
import model.*;
import javafx.event.*;
import java.text.DecimalFormat;


public class MMSController extends Controller<MMS>{
    @FXML private TableView<Membership> reportsTv;
    @FXML private TableColumn<Membership, String> nameClm;
    @FXML private TableColumn<Membership, String> typeClm;
    @FXML private TableColumn<Membership, String> expenseClm;
    @FXML private TableColumn<Membership, String> creditsClm;
    @FXML private TableColumn<Membership, String> gasDeductionClm;
    @FXML private TableColumn<Membership, String> deductionClm;
    @FXML private TableColumn<Membership, String> payPerCreditClm;
    @FXML private TableColumn<Membership, String> dollarClm;
    @FXML private Text totalExpenseTxt;
    @FXML private Text avgGasDeductionTxt;
    @FXML private Text avgPayPerCreditTxt;
    @FXML private Text totalCreditsTxt;
    @FXML private Text avgDeductionTxt;
    @FXML private Text totalDollarTxt;
    
    public final MMS getMMS(){
        return model;
    }
    @FXML private void initialize(){
        nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        typeClm.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        expenseClm.setCellValueFactory(cellData -> cellData.getValue().expenseProperty().asString("$%.2f"));
        creditsClm.setCellValueFactory(cellData -> cellData.getValue().totalCreditsProperty().asString("%.2f"));
        gasDeductionClm.setCellValueFactory(cellData -> cellData.getValue().GasdeductionRateProperty().asString("%.2f"));
        deductionClm.setCellValueFactory(cellData -> cellData.getValue().deductionRateProperty().asString("%.2f"));
        payPerCreditClm.setCellValueFactory(cellData -> cellData.getValue().payPerCreditProperty().asString("%.2f"));
        dollarClm.setCellValueFactory(cellData -> cellData.getValue().DollarAvailableProperty().asString("$%d").concat(".00"));
        setTotalExpense();
        setAvgGasDeduction();
        setAvgPayPerCredit();
        setTotalCredits();
        setAvgDeduction();
        setTotalDollar();
    }
    private void setTotalExpense(){
        totalExpenseTxt.setText("$" + formattedString(getTotalExpense()));
    }
    private double getTotalExpense(){
        return getMMS().getTotalExpense();
    }
    private void setAvgGasDeduction(){
        avgGasDeductionTxt.setText(formattedString(getAvgGasDeduction()));
    }
    private double getAvgGasDeduction(){
        return getMMS().getAvgGasdeductionRate();
    }
    private void setAvgPayPerCredit(){
        avgPayPerCreditTxt.setText(formattedString(getAvgPayPerCredit()));
    }
    private double getAvgPayPerCredit(){
        return getMMS().getAvgPayPerCredit();
    }
    private void setTotalCredits(){
        totalCreditsTxt.setText(formattedString(getTotalCredits()));
    }
    private double getTotalCredits(){
        return getMMS().getTotalCredits();
    }
    private void setAvgDeduction(){
        avgDeductionTxt.setText(formattedString(getAvgDeduction()));
    }
    private double getAvgDeduction(){
        return getMMS().getAvgdeductionRate();
    }
    private void setTotalDollar(){
        totalDollarTxt.setText("$" + formattedString(getTotalDollar()));
    }
    private double getTotalDollar(){
        return getMMS().getTotalDollarAvailable();
    }

    
    private String formattedString(Double value){
        return new DecimalFormat("###,##0.00").format(value);
    }
    @FXML private void handleClose(){
        stage.close();
    }
    
    
    


}
