/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Jobeur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.JobeurService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class top5Controller implements Initializable {
    @FXML
    private AnchorPane like;
    @FXML
    private TableView<?> Table_Jobeur;
    @FXML
    private TableColumn<?, ?> Column_nomj;
    @FXML
    private TableColumn<?, ?> Column_prenomj;
    @FXML
    private TableColumn<?, ?> Column_adress;
    @FXML
    private TableColumn<?, ?> Column_sexej;
    @FXML
    private TableColumn<?, ?> Column_tel;
    @FXML
    private TableColumn<?, ?> Column_job;
    @FXML
    private TableColumn<?, ?> Date_naissanceJ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
   JobeurService p = new JobeurService();
    Jobeur p1= new Jobeur();
     ArrayList Jobeurs = null;
        try {
            Jobeurs = (ArrayList) p.top5();
        } catch (SQLException ex) {
            Logger.getLogger(top5Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
     ObservableList data = FXCollections.observableArrayList(Jobeurs);
     Table_Jobeur.setItems(data);
     Column_nomj.setCellValueFactory(new PropertyValueFactory <>("nom"));
     Column_prenomj.setCellValueFactory(new PropertyValueFactory <>("prenom"));
     Column_adress.setCellValueFactory(new PropertyValueFactory <>("address"));
     Column_sexej.setCellValueFactory(new PropertyValueFactory <>("sexe"));
     Column_tel.setCellValueFactory(new PropertyValueFactory <>("tel"));
     Column_job.setCellValueFactory(new PropertyValueFactory <>("job"));
     Date_naissanceJ.setCellValueFactory(new PropertyValueFactory<>("like"));
   
    }    

    @FXML
    private void btn_retour(ActionEvent event) {
         Parent root = null;
        try {
             root = FXMLLoader.load(getClass().getResource("/fxml/Interface_choisir_jobeur.fxml"));
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
