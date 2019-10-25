/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Jobeur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Affiche_porfilejobeurController implements Initializable {
    @FXML
    private Label cin_J;
    @FXML
    private Label nom_J;
    @FXML
    private Label prenom_J;
    @FXML
    private Label datenaissance_J;
    @FXML
    private Label tele_J;
    @FXML
    private Label Email_J;
    @FXML
    private ImageView photo_profile;
    @FXML
    private TextArea Commentaire;
    @FXML
    private TableColumn<?, ?> Id_C;
    @FXML
    private TableColumn<?, ?> Nom_Pc;
    @FXML
    private TableColumn<?, ?> Prenom_PC;
    @FXML
    private TableColumn<?, ?> Avis_PC;
    @FXML
    private TableColumn <?, ?> Cin_J;
    @FXML
    private TableColumn<?, ?> Cin_P;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Jobeur A=new Jobeur();
        A=Interface_choisir_jobeurController.j1;
        nom_J.setText(A.getNom());
        prenom_J.setText(A.getPrenom());
        String date=A.getDate_naissance().toLocalDate().toString();
        datenaissance_J.setText(date);
        String tele= String.valueOf(A.getTel());
        tele_J.setText(tele);
        Email_J.setText(A.getEmail());
        String cin= String.valueOf(A.getCin());
        cin_J.setText(cin);
      
        
        System.out.println(Interface_choisir_jobeurController.j1);
    }    

    @FXML
    private void Ajouter_C(ActionEvent event) {
    }

    @FXML
    private void Modifier_c(ActionEvent event) {
    }

    @FXML
    private void Supprimer_C(ActionEvent event) {
    }

    @FXML
    private void Retour(ActionEvent event) {
    }

    @FXML
    private void favoris(ActionEvent event) {
    }

    @FXML
    private void Demander_Service(ActionEvent event) {
    }

   
    
}
