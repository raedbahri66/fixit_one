/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Jobeur;
import entites.Service;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
   
    }
     
     Gestion_tableau_jobeur gt = new Gestion_tableau_jobeur();
    ArrayList jobeur= (ArrayList) gt.afficherJobeur();
    
    
    public ObservableList data = FXCollections.observableArrayList(jobeur);
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherTab_service();
        // TODO
    }    
    
}
