package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import au.edu.uts.ap.javafx.*;
import model.*;
import au.edu.uts.ap.javafx.*;
import au.edu.uts.ap.javafx.ViewLoader;
import java.util.HashSet;
import java.util.Set;
import javafx.event.*;
import javafx.scene.image.Image;



public class MembershipController extends Controller<Membership> {
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    @FXML private TextField phoneTf;
    @FXML private TextField addressTf;
    @FXML private TextField idTf;
    @FXML private TextField expenseTf;
    @FXML private Text typeTf;
    @FXML private Button addBtn;
    @FXML private Button updateBtn;
    @FXML private Button deleteBtn;
    
    private final Membership getMembership(){
        return model;
    }
    
    @FXML private void initialize(){
        setName();
        setEmail();
        setPhone();
        setAddress();
        setID();
        setExpense();
        setType();
        setDisable();
        getMembership();
    }
    
    private void setName(){
        nameTf.setText(getMembership().getName());
    }
    private String getName(){
        return nameTf.getText();
    }
    private String getEmail(){
        return emailTf.getText();
    }
    private void setEmail(){
        emailTf.setText(getMembership().getEmail());
    }
    
    private String getPhone(){
        return phoneTf.getText();
    }
    
    private void setPhone(){
        phoneTf.setText(getMembership().getPhone());
    }
    
    private String getAddress(){
        return addressTf.getText();
    }
    private void setAddress(){
        addressTf.setText(getMembership().getAddress());
    }
    private String getID(){
        return idTf.getText();
    }
    private void setID(){
        idTf.setText(getMembership().getID());
    }
    private double getExpense(){
        return Double.parseDouble(expenseTf.getText());
    }
    
    private void setExpense(){
        expenseTf.setText(Double.toString(getMembership().getexpense()));
    }
    
    private void setType(){
        typeTf.setText(getMembership().getType());
    }
    
    private void setDisable(){
        updateBtn.setDisable(getName().equals(""));
        addBtn.setDisable(!getName().equals(""));
    }
    
    private boolean isValid(){
        Validator validator = new Validator();
        if (validator.isValid(getName(), getEmail(), getPhone(), getAddress(), getID(), getExpense())){
            return true;
        }
        return false;
    }
    
    private void updateDetails(){
        getMembership().updateDetails(getName(), getEmail(), getPhone(), getAddress(), getID(), getExpense());
    }
    
    @FXML private void handleAdd(ActionEvent event) throws Exception{
        Validator validator = new Validator();
        if (isValid()){
            updateDetails();
            getMembership().getSuperMarket().addMembership(getMembership());
        }
        else{
            validator.generateErrors(getName(), getEmail(), getPhone(), getAddress(), getID(), getExpense());
            Stage stage = new Stage();
            stage.getIcons().add(new Image("view/error.png"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            ViewLoader.showStage(validator,"/view/error.fxml", "Input Exceptions", stage); 
        }
    }
    
    @FXML private void handleUpdate(ActionEvent event) throws Exception{
        Validator validator = new Validator();
        if (isValid()){
            updateDetails();
            stage.close();
        }
        else{
            validator.generateErrors(getName(), getEmail(), getPhone(), getAddress(), getID(), getExpense());
            Stage stage = new Stage();
            stage.getIcons().add(new Image("view/error.png"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            ViewLoader.showStage(validator,"/view/error.fxml", "Input Exceptions", stage);
        }
    }
    
    @FXML private void handleClose(){
        stage.close();
    }
    
                
            
    
    
    
    
    
    


}
