/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Offre;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import service.gestion_offre_service;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Interface_formulaire_posteur_serviceController implements Initializable {
      @FXML
    private TextField Label_adresse;

    @FXML
    private DatePicker Label_date;

    @FXML
    private TextField Label_tel;

    @FXML
    private TextArea Label_description;

    @FXML
    private Button Btn_ajouter_service;

    @FXML
    private TextField Label_heure;

    /**
     * Initializes the controller class.
     */
    public boolean canInscription= true;
    
    
    @FXML
    void Ajouter_offre_service(ActionEvent event) {
        if(Label_adresse.getText().isEmpty()){
            canInscription = false;}
        
        if(Label_heure.getText().isEmpty()){
            canInscription = false;}
        if(Label_tel.getText().isEmpty()){
            canInscription = false;}
        if(Label_description.getText().isEmpty()){
            canInscription = false;}
     
        
        
        if(canInscription){
        
        String adresse = Label_adresse.getText();
        String Description = Label_description.getText();
        String Tel = Label_tel.getText();
        String Heure =Label_heure.getText();
        LocalDate LCD =Label_date.getValue();
         String date = LCD.toString();
         Offre O = new Offre(adresse,date ,Heure ,Description,Tel);
        gestion_offre_service g = new gestion_offre_service();
              g.creerOffre(O);
              JOptionPane.showMessageDialog(null, "Account Created Successfull");
    }
    else
       {
              JOptionPane.showMessageDialog(null, "Please fill all cases");
                          canInscription = true;

       }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
