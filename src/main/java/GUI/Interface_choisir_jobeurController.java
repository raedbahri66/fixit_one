/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.AcceuilController.A1;
import entites.Article;
import entites.Jobeur;
import entites.Service;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.Gestion_tableau_jobeur;
import service.gestion_service;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Interface_choisir_jobeurController implements Initializable {

    @FXML
    private TableView<Jobeur> Table_Jobeur;
    @FXML
    private TableColumn<Jobeur,String> Column_nomj;

    @FXML
    private TableColumn<Jobeur,String> Column_prenomj;

    @FXML
    private TableColumn<Jobeur,String> Column_emailj;

    @FXML
    private TableColumn<Jobeur,String> Column_sexej;
     @FXML
    private TableColumn<Jobeur,Integer> Column_tel;
    @FXML
    private TableColumn<Jobeur,String> Column_job;
    @FXML
    private TableColumn<Jobeur,Integer> column_cin;
    @FXML
    private TableColumn<Jobeur,Date> Date_naissanceJ;
    @FXML
    private TextField Label_recherche;

    @FXML
    private Button Btn_recherche_jobeur;
    @FXML
    void RechercheJobeur(ActionEvent event) {
        data.clear();
        String nom =Label_recherche.getText();
      Gestion_tableau_jobeur gt = new Gestion_tableau_jobeur();
      ArrayList Jobeur= (ArrayList) gt.RechercheJobeur(nom);
      data= FXCollections.observableArrayList(Jobeur);
     Table_Jobeur.setItems(data);
     Column_nomj.setCellValueFactory(new PropertyValueFactory <Jobeur,String>("nom"));
     Column_prenomj.setCellValueFactory(new PropertyValueFactory <Jobeur,String>("prenom"));
     Column_emailj.setCellValueFactory(new PropertyValueFactory <Jobeur,String>("email"));
     Column_sexej.setCellValueFactory(new PropertyValueFactory <Jobeur,String>("sexe"));
     Column_tel.setCellValueFactory(new PropertyValueFactory <Jobeur,Integer>("tel"));
     Column_job.setCellValueFactory(new PropertyValueFactory <Jobeur,String>("job"));
     Date_naissanceJ.setCellValueFactory(new PropertyValueFactory<Jobeur,Date>("date_naissance"));
     column_cin.setCellValueFactory(new PropertyValueFactory <Jobeur,Integer>("cin"));

    }
  

    /**
     * Initializes the controller class.
     */
     public void afficherTab_service()
    {
        
     gt.afficherJobeur();
     Table_Jobeur.setItems(data);
     Column_nomj.setCellValueFactory(new PropertyValueFactory <Jobeur,String>("nom"));
     Column_prenomj.setCellValueFactory(new PropertyValueFactory <Jobeur,String>("prenom"));
     Column_emailj.setCellValueFactory(new PropertyValueFactory <Jobeur,String>("email"));
     Column_sexej.setCellValueFactory(new PropertyValueFactory <Jobeur,String>("sexe"));
     Column_tel.setCellValueFactory(new PropertyValueFactory <Jobeur,Integer>("tel"));
     Column_job.setCellValueFactory(new PropertyValueFactory <Jobeur,String>("job"));
     Date_naissanceJ.setCellValueFactory(new PropertyValueFactory<Jobeur,Date>("date_naissance"));
     column_cin.setCellValueFactory(new PropertyValueFactory <Jobeur,Integer>("cin"));

   
    }
     public static Jobeur j1;
     
     Gestion_tableau_jobeur gt = new Gestion_tableau_jobeur();
    ArrayList jobeur= (ArrayList) gt.afficherJobeur();
    
    
    public ObservableList data = FXCollections.observableArrayList(jobeur);
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherTab_service();
        Table_Jobeur.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
         Jobeur A=new Jobeur();
          A = (Jobeur) Table_Jobeur.getItems().get(Table_Jobeur.getSelectionModel().getSelectedIndex());
         j1=A;
          Parent root = null;
                System.out.println(A);
                try {
                    root = FXMLLoader.load(getClass().getResource("/fxml/affiche_profilJobeur.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                }
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show(); 
                
         }});
    }
        // TODO

    @FXML
    private void btn_top5(ActionEvent event) {
           Parent root = null;
        try {
             root = FXMLLoader.load(getClass().getResource("/fxml/top5.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show(); 
    
    
    }
    }    
    

