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



public class SuperMarketController extends Controller<SuperMarket>  {
    @FXML private TableView<Membership> membershipsTv;
    @FXML private TableColumn<Membership, String> nameClm;
    @FXML private TableColumn<Membership, String> emailClm;
    @FXML private TableColumn<Membership, String> phoneClm;
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    @FXML private Button deleteBtn;
    @FXML private Button selectBtn;
    @FXML private Button slipBtn;
    
    @FXML private void initialize(){
        nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        emailClm.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        phoneClm.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        membershipsTv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSubject, newSubject) -> deleteBtn.setDisable(newSubject == null));
        membershipsTv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSubject, newSubject) -> selectBtn.setDisable(newSubject == null));
        membershipsTv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSubject, newSubject) -> slipBtn.setDisable(newSubject == null));
        nameTf.textProperty().addListener(
                (observable, oldSubject, newSubject) -> getSuperMarket().filterList(newSubject, newSubject));
        emailTf.textProperty().addListener(
                (observable, oldSubject, newSubject) -> getSuperMarket().filterList(newSubject, newSubject));
        
    }
    
    private String getNameTf(){
        return nameTf.getText();
    }
    private String getEmailTf(){
        return emailTf.getText();
    }
    private String getName(Membership name){
        return name.getName();
    }
    

    public final SuperMarket getSuperMarket(){
        return model;    
    }
    
    private Membership getSelectedMembership(){
        return membershipsTv.getSelectionModel().getSelectedItem();
    }
    @FXML private void handleAdd(ActionEvent event) throws Exception{
        Stage stage1 = new Stage();
        stage1.getIcons().add(new Image("view/edit.png"));
        stage1.setX(ViewLoader.X);
        stage1.setY(ViewLoader.Y);
        Membership membership = new Membership("", "", "", "", "", 0.0);
        membership.setSuperMarket(getSuperMarket());
        ViewLoader.showStage(membership,"/view/Membership.fxml", "Adding New Membership", stage1);
        
    }
    
    @FXML private void handleDelete(){
        getSuperMarket().removeMembership(getSelectedMembership());
    }
    
    
    @FXML private void handleSelect(ActionEvent event) throws Exception{
        Stage stage1 = new Stage();
        stage1.getIcons().add(new Image("view/edit.png"));
        stage1.setX(ViewLoader.X);
        stage1.setY(ViewLoader.Y);
        ViewLoader.showStage(getSelectedMembership(),"/view/Membership.fxml", "Accessing File: " + getSelectedMembership().getName(), stage1);
        
    }
    @FXML private void handleSlip(ActionEvent event) throws Exception{
        Stage stage1 = new Stage();
        stage1.getIcons().add(new Image("view/edit.png"));
        stage1.setX(ViewLoader.X);
        stage1.setY(ViewLoader.Y);
        ViewLoader.showStage(new MMSreport(getSelectedMembership()),"/view/slip.fxml", getName(getSelectedMembership()) + " SLIP Report", stage1);
    }
    @FXML private void handleReport(ActionEvent event) throws Exception{
        Stage stage1 = new Stage();
        stage1.getIcons().add(new Image("view/uts.jpeg"));
        stage1.setX(ViewLoader.X);
        stage1.setY(ViewLoader.Y);
        ViewLoader.showStage(new MMS(getSuperMarket()),"/view/mms.fxml","MMS Report", stage1);
    }
    @FXML private void handleClose(){
        stage.close();
    }
    

    


}
