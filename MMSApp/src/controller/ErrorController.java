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

public class ErrorController extends Controller<Validator>{
    @FXML private Text errorTxt;
    
    public final Validator getValidator(){
        return model;
    }
    
    private void setError(String text){
        errorTxt.setText(text);
    }

    @FXML private void initialize(){
        String error = "";
        for (String temp : getValidator().errors()){
            error += temp;
        }
        setError(error);
    }
    @FXML private void handleOkay(){
        stage.close();
    }



}
