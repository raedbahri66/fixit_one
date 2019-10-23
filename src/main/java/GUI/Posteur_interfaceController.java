/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.PosteurgestionController.NOW_LOCAL_DATE;
import entites.Posteur;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import service.PosteurService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Posteur_interfaceController implements Initializable {

    @FXML
    private Label nomp_1;
    @FXML
    private Label telp_1;
    @FXML
    private Label emailp_1;
    @FXML
    private Label prenomp_1;
    @FXML
    private Label datep_1;
    @FXML
    private TextField tf_nom1;
    @FXML
    private TextField tf_prenom1;
    @FXML
    private TextField tef_email1;
    @FXML
    private TextField tf_tel1;
    @FXML
    private DatePicker df_date1;
    
    public boolean canModif=true;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /////raed///
                df_date1.setValue(NOW_LOCAL_DATE());

        System.err.println(AcceuilController.cinlogin);
        PosteurService p = new PosteurService();
        Posteur p1= new Posteur();
        p1 = p.getPosteurInfobyCin(AcceuilController.cinlogin);
        nomp_1.setText(p1.getNom());
        prenomp_1.setText(p1.getPrenom());
        emailp_1.setText(p1.getEmail());
        telp_1.setText(Integer.toString(p1.getTel()));
         datep_1.setText(p1.getDate_naissance().toString());

    }    

    @FXML
    private void btn_modifprofil(ActionEvent event) {
        if(tf_nom1.getText().isEmpty()){
            canModif = false;
        }
        if(tf_prenom1.getText().isEmpty()){
            canModif = false;
        }
        if(tf_tel1.getText().isEmpty()){
            canModif = false;
        }
        if(tef_email1.getText().isEmpty()){
            canModif = false;
        }
        if(canModif)
        {
        LocalDate locald = df_date1.getValue();
        Date date = Date.valueOf(locald);
        PosteurService p = new PosteurService();
        Posteur p1= new Posteur(AcceuilController.cinlogin, tf_nom1.getText(), tf_prenom1.getText(), tef_email1.getText(), date, Integer.parseInt(tf_tel1.getText()));
        p.modifierProfil(p1);
        JOptionPane.showMessageDialog(null, "Account edited Successfull");
        nomp_1.setText(p1.getNom());
        prenomp_1.setText(p1.getPrenom());
        emailp_1.setText(p1.getEmail());
        telp_1.setText(Integer.toString(p1.getTel()));
         datep_1.setText(p1.getDate_naissance().toString());
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Please fill all cases");
                          canModif = true;
        }
        
    }
    
}
