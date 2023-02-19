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
import model.*;
import javafx.scene.image.Image;



public class SessionController extends Controller<Session> {
    public final Session getSession(){
        return model;
    }

    @FXML private void handleLogin(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("view/book.png"));
        stage.setX(ViewLoader.X);
        stage.setY(ViewLoader.Y);
        ViewLoader.showStage(getSession(),"/view/MMSlogin.fxml", "Sign In", stage);
    }
    
    @FXML private void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }
    
}
