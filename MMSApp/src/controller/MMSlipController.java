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

public class MMSlipController extends Controller<MMSreport>{
    @FXML private Text totalCreditsTxt;
    @FXML private Text totalExpenseTxt;
    @FXML private Text gasDeductionTxt;
    @FXML private Text payPerCreditTxt;
    @FXML private Text dollarTxt;
    @FXML private Text deductionTxt;
    
    public final MMSreport getMMSreport(){
        return model;
    }
    @FXML private void initialize(){
        setTotalCredits();
        setTotalExpense();
        setGasDeduction();
        setPayPerCredit();
        setDollar();
        setDeduction();
    }
    private void setTotalCredits(){
        totalCreditsTxt.setText(formattedString(getTotalCredits()));
    }
    private double getTotalCredits(){
        return getMMSreport().gettotalCredits();
    }
    private void setTotalExpense(){
        totalExpenseTxt.setText("$" + formattedString(getTotalExpense()));
    }
    private double getTotalExpense(){
        return getMMSreport().getexpense();
    }
    private void setGasDeduction(){
        gasDeductionTxt.setText(formattedString(getGasDeduction()));
    }
    private double getGasDeduction(){
        return getMMSreport().getGasdeductionRate();
    }
    private void setPayPerCredit(){
        payPerCreditTxt.setText(formattedString(getPayPerCredit()));
    }
    private double getPayPerCredit(){
        return getMMSreport().getPayPerCredit();
    }
    private void setDollar(){
        dollarTxt.setText("$" + formattedString(getDollar()));
    }
    private double getDollar(){
        return getMMSreport().getDollarAvailable();
    }
    private void setDeduction(){
        deductionTxt.setText(formattedString(getDeduction()));
    }
    private double getDeduction(){
        return getMMSreport().getdeductionRate();
    }
    
    private String formattedString(Double value){
        return new DecimalFormat("###,##0.00").format(value);
    }
    @FXML private void handleClose(){
        stage.close();
    }
    
    
    
    


    }
