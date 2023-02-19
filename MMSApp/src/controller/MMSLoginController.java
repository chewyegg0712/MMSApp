package controller;

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
import model.*;

public class MMSLoginController extends Controller<Session>  {
    @FXML private TextField emailTf;
    @FXML private PasswordField passwordPf;
    @FXML private Label errorLbl;
    
    public final Session getSession(){
        return model;
    }
    private String getName(SuperMarket superMarket){
        return superMarket.getName();
    }
    public String getEmail(){
        return emailTf.getText();
    }
    
    public String getPassword(){
        return passwordPf.getText();
    }
    private void setIncorrectLogin(){
        errorLbl.setText("Incorrect login details");
    }
    private void setEmail(){
        emailTf.setText("");
    }
    private void setPasswordPf(){
        passwordPf.setText("");
    }
    
    
    
    @FXML private void handleOK(ActionEvent event) throws Exception{
        if (getSession().getSuperMarket(getEmail(), getPassword()) != null){
            Stage stage1 = new Stage();
            stage1.getIcons().add(new Image("view/SuperMarket.png"));
            stage1.setX(ViewLoader.X);
            stage1.setY(ViewLoader.Y);
            ViewLoader.showStage(new SuperMarket(), "/view/SuperMarket.fxml", "Session Admin: " + getName(getSession().getSuperMarket(getEmail(), getPassword())), stage1);
            stage.close();
        }
        else{
            setIncorrectLogin(); 
            setEmail();
            setPasswordPf();
        }
    }
    
    @FXML private void handleCancel(ActionEvent event) throws Exception{
        stage.close();
    }
    

}

